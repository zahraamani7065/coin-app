package android.company.coin.Data;

import android.company.coin.AppConstant;
import android.company.coin.Data.Model.User;
import android.company.coin.Data.Model.UserInformation;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;

public class LocalRepo {
    public static LocalRepo localRepo;
    public static User cachedUserInformation;
    private final Gson gson;
    private final SharedPreferences sharedPreferences;


    public static LocalRepo getInstance(Context context){

        if(localRepo==null){
            localRepo=new LocalRepo(context,new Gson());
        }
        return localRepo;

    }

    public LocalRepo(Context context , Gson gson) {

        this.gson=gson;
        this.sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);

    }
    public void setUserInfo(User userInformation){

        sharedPreferences.edit().putString(AppConstant.USER_INFO,gson.toJson(userInformation)).apply();
        cachedUserInformation=userInformation;

    }
    public User getUserInfo(){
        if(cachedUserInformation==null){

            String userInfo=sharedPreferences.getString(AppConstant.USER_INFO,null);
            if(!TextUtils.isEmpty(userInfo)){
                cachedUserInformation=gson.fromJson(userInfo,User.class);
            }
        }
        return cachedUserInformation;
    }

    public void logOut(){
        cachedUserInformation=null;
        sharedPreferences.edit().clear().apply();
    }
}

package android.company.coin.Data;

import android.company.coin.Data.Model.User;
import android.company.coin.Data.Model.UserInformation;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class LocalRepo {
    public static LocalRepo localRepo;
    public static UserInformation cachedUserInformation;
    private final Gson gson;
    private final SharedPreferences sharedPreferences;
    private static final String USER_INFO="_user_info";


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
    public void setUserInfo(UserInformation userInformation){
        sharedPreferences.edit().putString(USER_INFO,gson.toJson(userInformation)).apply();
        cachedUserInformation=userInformation;
    }
    public UserInformation getUserInfo(){
        if(cachedUserInformation==null){
            String userInfo=sharedPreferences.getString(USER_INFO,null);
            if(!userInfo.isEmpty()){
                cachedUserInformation=gson.fromJson(userInfo,UserInformation.class);
            }
        }
        return cachedUserInformation;
    }

    public void logOut(){
        cachedUserInformation=null;
        sharedPreferences.edit().clear().apply();
    }
}

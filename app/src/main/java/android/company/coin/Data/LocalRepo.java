package android.company.coin.Data;

import android.company.coin.AppConstant;
import android.company.coin.Data.Model.SignUp.User;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

public class LocalRepo {
    public static LocalRepo localRepo;
    public static User cachedUserInformationSignUp;
    public  static android.company.coin.Data.Model.LogIn.User cachedInformationLogIn;
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
    public void setUserInfoSignUp(@NonNull User userInformation){

        sharedPreferences.edit().putString(AppConstant.USER_INFO,gson.toJson(userInformation)).apply();
        cachedUserInformationSignUp=userInformation;

    }
    public void setUserInfoLogIn(@NonNull android.company.coin.Data.Model.LogIn.User user){
        sharedPreferences.edit().putString(AppConstant.USER_INFO,gson.toJson(user)).apply();
        cachedInformationLogIn=user;
    }
    public User getUserInfoSignUp(){
        if(cachedUserInformationSignUp==null){

            String userInfo=sharedPreferences.getString(AppConstant.USER_INFO,null);
            if(!TextUtils.isEmpty(userInfo)){
                cachedUserInformationSignUp=gson.fromJson(userInfo,User.class);
            }
        }
        return cachedUserInformationSignUp;
    }
    public android.company.coin.Data.Model.LogIn.User getUserInfoLogIn(){
        if(cachedInformationLogIn==null){
            String userInfo=sharedPreferences.getString(AppConstant.USER_INFO,null);
            if(!TextUtils.isEmpty(userInfo)){
                cachedInformationLogIn=gson.fromJson(userInfo, android.company.coin.Data.Model.LogIn.User.class);
            }
        }
        return cachedInformationLogIn;
    }

    public void logOut(){
        cachedUserInformationSignUp=null;
        sharedPreferences.edit().clear().apply();
    }
}

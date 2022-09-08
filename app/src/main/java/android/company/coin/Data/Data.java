package android.company.coin.Data;


import android.company.coin.ApiService;
import android.company.coin.AppConstant;
import android.company.coin.Data.Model.SignUpRequest;
import android.company.coin.Data.Model.User;
import android.company.coin.Data.Model.UserInformation;
import android.company.coin.Utils.Commons;
import android.content.Context;

import java.util.HashMap;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Data {
    private static Data data;
    private final ApiService apiService;



    public static Data getInstance(Context context) {

//        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        if(data==null){
        ApiService apiService=new Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(Commons.getHttpClient())
                    .build().create(ApiService.class);

        data=new Data(apiService);
        }

        return data;
    }


    public Data(ApiService apiService) {
        this.apiService=apiService;
    }

    public Single<User> sinUpRequest(String name,String email,String password,String passwordConfirmation){
        SignUpRequest signUpRequest=new SignUpRequest();
        signUpRequest.setName(name);
        signUpRequest.setPassword(password);
        signUpRequest.setEmail(email);
        signUpRequest.setPasswordConfirmation(passwordConfirmation);
        return apiService.requestSignUp(signUpRequest);

    }
}

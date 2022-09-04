package android.company.coin.Data;


import android.company.coin.ApiService;
import android.company.coin.AppConstant;
import android.company.coin.Data.Model.SignUpRequest;
import android.company.coin.Data.Model.User;
import android.company.coin.Data.Model.UserInformation;
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
    private final LocalRepo localRepo;
    private final ApiService apiService;



    public static Data getInstance(Context context) {

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        if(data==null){
        ApiService apiService=new Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build().create(ApiService.class);

        data=new Data(LocalRepo.getInstance(context),apiService);
        }

        return data;
    }


    public Data(LocalRepo  localRepo,ApiService apiService) {
        this.apiService=apiService;
        this.localRepo=localRepo;
    }

    public Single<User> sinUpRequest(String name,String email,String password){
        SignUpRequest signUpRequest=new SignUpRequest();
        signUpRequest.setName(name);
        signUpRequest.setPassword(password);
        signUpRequest.setEmail(email);
        return apiService.requestSignUp(signUpRequest);

    }
}

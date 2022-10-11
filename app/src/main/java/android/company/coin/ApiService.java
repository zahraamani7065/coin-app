package android.company.coin;

import android.company.coin.Data.Model.ListCoin.CryptoCurrencyList;
import android.company.coin.Data.Model.ListCoin.Data;
import android.company.coin.Data.Model.LogIn.LogInRequest;
import android.company.coin.Data.Model.SignUp.Root;
import android.company.coin.Data.Model.SignUp.SignUpRequest;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register")
    Single<Root> requestSignUp(@Body SignUpRequest signUpRequest);

    @POST("login")
    Single<android.company.coin.Data.Model.LogIn.Root> requestLogIn(@Body LogInRequest logInRequest);

    @GET("v3/cryptocurrency/listing?start=1&limit=20")
    Single<android.company.coin.Data.Model.ListCoin.Root> getCryptoList();

}

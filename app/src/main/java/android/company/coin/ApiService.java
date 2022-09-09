package android.company.coin;

import android.company.coin.Data.Model.Root;
import android.company.coin.Data.Model.SignUpRequest;
import android.company.coin.Data.Model.User;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register")
    Single<Root> requestSignUp(@Body SignUpRequest signUpRequest);
}

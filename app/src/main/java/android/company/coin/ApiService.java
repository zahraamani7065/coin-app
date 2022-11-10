package android.company.coin;

import android.company.coin.Data.Model.LogIn.LogInRequest;
import android.company.coin.Data.Model.SignUp.Root;
import android.company.coin.Data.Model.SignUp.SignUpRequest;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("register")
    Single<Root> requestSignUp(@Body SignUpRequest signUpRequest);

    @POST("login")
    Single<android.company.coin.Data.Model.LogIn.Root> requestLogIn(@Body LogInRequest logInRequest);

    @GET("v3/cryptocurrency/listing?start=1&limit")
    Single<android.company.coin.Data.Model.ListCoin.Root> getCryptoList();
   @GET("v3/cryptocurrency/listing?start=1&sortBy=market_cap&sortType=desc&convert=USD&" +
           "cryptoType=all&tagType=all&audited=false&aux=ath,atl,high24h,low24h,num_market_pairs," +
           "cmc_rank,date_added,max_supply,circulating_supply,total_supply,volume_7d,volume_30d," +
           "self_reported_circulating_supply,self_reported_market_cap")
    Single<android.company.coin.Data.Model.TopCoins.Root> getTopCoins();

   @GET("v3/cryptocurrency/listing?start=1&sortBy=percent_change_24h&sortType=desc&convert=USD&" +
           "cryptoType=all&tagType=all&audited=false&aux=ath,atl,high24h,low24h,num_market_pairs,cmc_rank," +
           "date_added,max_supply,circulating_supply,total_supply,volume_7d,volume_30d,self_reported_circulating_supply" +
           ",self_reported_market_cap")
    Single<android.company.coin.Data.Model.TopGainers.Root> getTopGainers();

   @GET("v3/cryptocurrency/listing?start=1&sortBy=percent_change_24h&sortType=asc&convert=USD&cryptoType=all&" +
           "tagType=all&audited=false&aux=ath,atl,high24h,low24h,num_market_pairs,cmc_rank,date_added,max_supply," +
           "circulating_supply,total_supply,volume_7d,volume_30d,self_reported_circulating_supply,self_reported_market_cap")
    Single<android.company.coin.Data.Model.TopLosers.Root> getTopLosers();
}

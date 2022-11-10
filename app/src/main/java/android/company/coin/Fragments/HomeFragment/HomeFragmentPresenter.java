package android.company.coin.Fragments.HomeFragment;

import android.company.coin.Data.Data;
import android.company.coin.Data.Model.ListCoin.CryptoCurrencyList;
import android.company.coin.Data.Model.ListCoin.Root;
import android.company.coin.adapter.CryptoListAdapter;
import android.company.coin.adapter.TopCoinsAdapter;
import android.company.coin.adapter.TopGainersAdapter;
import android.company.coin.adapter.TopLosersAdapter;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    HomeFragmentContract.View view;
    Disposable disposable;
    CryptoListAdapter adapter;
    TopCoinsAdapter topCoinsAdapter;
    TopGainersAdapter topGainersAdapter;
    TopLosersAdapter topLosersAdapter;
    RecyclerView rv;

    public HomeFragmentPresenter() {
    }

    public HomeFragmentPresenter(RecyclerView rv) {
        this.rv=rv;
    }

    @Override
    public void onAttach(HomeFragmentContract.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void loadCoinList() {
        Data.getInstance().getCryptoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<Root>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(Root root) {
                                view.stopShimmer();
                                view.showRecyclerView();
                                Log.i("datas", "onSuccess: "+root.getData().getTotalCount());
                                adapter=new CryptoListAdapter(root.getData().getCryptoCurrencyList(),view.getContext());
                                rv.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                                view.showLoadMore();
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.showErrorMessage();
                                Log.i("error message", "onError: "+e);
                            }
                        });
    }


    @Override
    public void loadTopCoins() {
        Data.getInstance().getTopCoins()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<android.company.coin.Data.Model.TopCoins.Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(android.company.coin.Data.Model.TopCoins.Root root) {
                        view.stopShimmer();
                        view.showRecyclerView();
                        Log.i("datas", "onSuccess: "+root.getData().getTotalCount());
                        topCoinsAdapter=new TopCoinsAdapter(root.getData().getCryptoCurrencyList(),view.getContext());
                        rv.setAdapter(topCoinsAdapter);
                        topCoinsAdapter.notifyDataSetChanged();
                        view.showLoadMore();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    @Override
    public void loadTopGainers() {
        Data.getInstance().getTopGainers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<android.company.coin.Data.Model.TopGainers.Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(android.company.coin.Data.Model.TopGainers.Root root) {
                        view.stopShimmer();
                        view.showRecyclerView();
                        Log.i("datas", "onSuccess: "+root.getData().getTotalCount());
                        topGainersAdapter=new TopGainersAdapter(root.getData().getCryptoCurrencyList(),view.getContext());
                        rv.setAdapter(topGainersAdapter);
                        topGainersAdapter.notifyDataSetChanged();
                        view.showLoadMore();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

    @Override
    public void loadTopLosers() {
        Data.getInstance().getTopLosers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<android.company.coin.Data.Model.TopLosers.Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(android.company.coin.Data.Model.TopLosers.Root root) {
                        view.stopShimmer();
                        view.showRecyclerView();
                        Log.i("datas", "onSuccess: "+root.getData().getTotalCount());
                        topLosersAdapter=new TopLosersAdapter(root.getData().getCryptoCurrencyList(),view.getContext());
                        rv.setAdapter(topLosersAdapter);
                        topLosersAdapter.notifyDataSetChanged();
                        view.showLoadMore();

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showErrorMessage();
                        Log.i("getTopLoser", "onError: "+e);

                    }
                });

    }

    @Override
    public void loadMoreItems() {
        if(HomeFragment.selectedCoin=="mainCoins"){
            CryptoListAdapter.pos=CryptoListAdapter.pos+10;
            adapter.notifyDataSetChanged();}
        else if (HomeFragment.selectedCoin=="topCoins"){
            TopCoinsAdapter.pos=TopCoinsAdapter.pos+10;
            topCoinsAdapter.notifyDataSetChanged();
        }
        else if (HomeFragment.selectedCoin=="gainerCoins"){
            TopGainersAdapter.pos=TopGainersAdapter.pos+10;
            topGainersAdapter.notifyDataSetChanged();
        }
        else if (HomeFragment.selectedCoin=="LoserCoins"){
            TopLosersAdapter.pos=TopLosersAdapter.pos+10;
            topLosersAdapter.notifyDataSetChanged();

        }

    }



}

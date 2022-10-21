package android.company.coin.Fragments.HomeFragment;

import android.company.coin.Data.Data;
import android.company.coin.Data.Model.ListCoin.CryptoCurrencyList;
import android.company.coin.Data.Model.ListCoin.Root;
import android.company.coin.adapter.CryptoListAdapter;
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

    @Override
    public void onAttach(HomeFragmentContract.View view) {
        this.view=view;
        this.view.showLoading();
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void loadCoinList(RecyclerView rv) {
        Data.getInstance().getCryptoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<Root>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(Root root) {
                                view.GoneLoading();
                                Log.i("datas", "onSuccess: "+root.getData().getTotalCount());
                                adapter=new CryptoListAdapter(root.getData().getCryptoCurrencyList(),view.getContext());
                                rv.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                                view.showLoadMore();
                            }

                            @Override
                            public void onError(Throwable e) {
                                view.GoneLoading();
                                view.showErrorMessage(e);
                                Log.i("error message", "onError: "+e);
                            }
                        });
    }

    @Override
    public void loadMoreItems() {
        CryptoListAdapter.pos=CryptoListAdapter.pos+10;
        adapter.notifyDataSetChanged();
    }
}

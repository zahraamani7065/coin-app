package android.company.coin.Fragments.ChatBarFragment;

import android.company.coin.BaseView;
import android.company.coin.Data.Data;
import android.company.coin.Data.Model.ListCoin.Root;
import android.company.coin.adapter.CryptoListAdapter;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ChatBarFragmentPresenter implements ChatBarFragmentContract.Presenter{
    ChatBarFragmentContract.View view;
    RecyclerView rv;
    CryptoListAdapter adapter;

    public ChatBarFragmentPresenter(RecyclerView rv) {
        this.rv = rv;
    }

    @Override
    public void onAttach(ChatBarFragmentContract.View view) {
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
                        Log.i("data", "onSuccess: "+root.getData().getTotalCount());
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
    public void loadMoreItems() {
        CryptoListAdapter.pos=CryptoListAdapter.pos+10;
        adapter.notifyDataSetChanged();

    }
}

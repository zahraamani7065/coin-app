package android.company.coin.Fragments.HomeFragment;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

import androidx.recyclerview.widget.RecyclerView;

public interface HomeFragmentContract {
    interface View extends BaseView{
        void showErrorMessage();
        void showLoadMore();
        void stopShimmer();
        void showRecyclerView();
        void setGoneErrorMessage();
    }

    interface Presenter extends BasePresenter<View>{
        void loadCoinList();
        void loadMoreItems();
        void loadTopCoins();
        void loadTopGainers();
        void loadTopLosers();

    }

}

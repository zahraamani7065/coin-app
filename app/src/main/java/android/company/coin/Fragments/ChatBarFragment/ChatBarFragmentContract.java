package android.company.coin.Fragments.ChatBarFragment;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

public interface ChatBarFragmentContract {
    interface View extends BaseView{
        void showErrorMessage();
        void showLoadMore();
        void stopShimmer();
        void showRecyclerView();
    }
    interface Presenter extends BasePresenter<View>{
        void loadCoinList();
        void loadMoreItems();
    }

}

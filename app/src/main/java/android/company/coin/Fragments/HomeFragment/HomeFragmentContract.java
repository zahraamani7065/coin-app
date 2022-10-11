package android.company.coin.Fragments.HomeFragment;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

import androidx.recyclerview.widget.RecyclerView;

public interface HomeFragmentContract {
    interface View extends BaseView{
        void showLoading();
        void GoneLoading();
        void showErrorMessage(Throwable e);
    }
    interface Presenter extends BasePresenter<View>{
        void loadCoinList(RecyclerView rv);
    }

}

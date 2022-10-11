package android.company.coin.Main;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public interface HomePageContract {
    interface View extends BaseView {
        void showTitle();
    }
    interface Presenter extends BasePresenter<View> {
        void navigation(BottomNavigationView view);
        void getListCrypto();
    }

}

package android.company.coin.LogIn;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

public interface LogInContract {
    interface View extends BaseView {
        void showSignUpError();
        void setProgressBarVisibility();

    }
    interface Presenter extends BasePresenter<View> {
        void doLogIn(String userName,String passWord);
        void goToLogIn();


    }
}

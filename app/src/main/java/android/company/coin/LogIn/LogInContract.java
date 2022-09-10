package android.company.coin.LogIn;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

public interface LogInContract {
    interface View extends BaseView {
        void setProgressBarVisible();
        void setProgressBarGone();
        void showLogInError(int message);
        void errorMessageGone();
        void showSuccess();

    }
    interface Presenter extends BasePresenter<View> {
        void doLogIn(String email,String passWord);
        void checkValidation(String getEmail,String getPassword);

    }
}

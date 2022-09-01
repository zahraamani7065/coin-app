package android.company.coin.Signup;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;
import android.company.coin.LogIn.LogInContract;

public class SignUpContract {


    interface View extends BaseView {


        void showSignUpError();

        void setProgressBarVisibility();

    }


    interface Presenter extends BasePresenter<LogInContract.View> {

        void signUpButtonClick(String userName,String email,String passWord);

        void goToLogIn();

        void logInButtonClick(String userName,String email,String password);

    }
}

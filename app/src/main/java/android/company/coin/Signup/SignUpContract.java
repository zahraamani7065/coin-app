package android.company.coin.Signup;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

public interface SignUpContract {


    interface View extends BaseView {

        void showSignUpError(Throwable e);

        void setProgressBarVisible();

        void setProgressBarGone();

        void showSignUpSuccessFull();

        void showEmailValidationError();
    }


    interface Presenter extends BasePresenter<SignUpContract.View> {

        void signUpButtonClick(String userName,String email,String passWord,String passwordConfirmation2);

        void goToLogIn();

        void logInButtonClick(String userName,String email,String password);

    }
}

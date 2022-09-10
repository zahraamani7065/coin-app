package android.company.coin.Signup;

import android.company.coin.BasePresenter;
import android.company.coin.BaseView;

public interface SignUpContract {

    interface View extends BaseView {

        void showErrorMessage(int massage);

        void showSignUpError(String message);

        void setProgressBarVisible();

        void setProgressBarGone();

        void showSignUpSuccessFull();

        void errorMassageGone();
    }

    interface Presenter extends BasePresenter<SignUpContract.View> {

        void doSignUp(String userName, String email, String passWord, String passwordConfirmation2);
        void checkValidation(String userName,String email,String passWord,String passwordConfirmation2);
    }
}

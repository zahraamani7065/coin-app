package android.company.coin.Signup;

import android.company.coin.ContextProvider;
import android.company.coin.LogIn.LogInContract;
import android.company.coin.Utils.Commons;

public class SignupPresenter implements SignUpContract.Presenter{

    SignUpContract.View view;
    ContextProvider contextProvider;

    @Override
    public void onAttach(LogInContract.View view) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void signUpButtonClick(String userName,String email, String passWord) {
        view.setProgressBarVisibility();
        if(!Commons.CheckConnection(view.getContext())){
            view.showNetworkError();
            return;
        }
        view.setProgressBarVisibility();





    }

    @Override
    public void goToLogIn() {

    }

    @Override
    public void logInButtonClick(String userName,String email,String password) {

    }
}

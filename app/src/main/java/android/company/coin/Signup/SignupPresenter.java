package android.company.coin.Signup;

import android.company.coin.AppConstant;
import android.company.coin.Data.Data;
import android.company.coin.Data.LocalRepo;
import android.company.coin.Data.Model.SignUp.Root;
import android.company.coin.R;
import android.company.coin.Utils.Commons;
import android.util.Log;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SignupPresenter implements SignUpContract.Presenter{

    SignUpContract.View view;
    LocalRepo localRepo;
    Disposable disposable;

    @Override
    public void onAttach(SignUpContract.View view) {
        this.view=  view;
        localRepo=LocalRepo.getInstance(view.getContext());
    }

    @Override
    public void onDetach() {
        view=null;

    }

    @Override
    public void doSignUp(String userName, String email, String passWord, String passwordConfirmation) {
        view.errorMassageGone();
        view.setProgressBarVisible();

        Data.getInstance(view.getContext()).sinUpRequest(userName,email,passWord,passwordConfirmation)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.i(AppConstant.TAG, "onSubscribe: ");
                        disposable=d;
                    }

                    @Override
                    public void onSuccess(Root root) {
                        if(root.getUser()!=null){
                            localRepo.setUserInfoSignUp(root.getUser());
                            view.showSignUpSuccessFull();
                            onDetach();
                        }

                        else{
                            view.showSignUpError(root.getMessage());
                            view.setProgressBarGone();
                        }

                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i("test", "onError: "+e);
                        view.showSignUpError("server error");
                        view.setProgressBarGone();
                    }
                });

    }

    @Override
    public void checkValidation(String getUserName, String getEmail, String getPassword, String getPasswordConfirmation) {
        view.errorMassageGone();
        if(getUserName.isEmpty()){
            view.showErrorMessage(R.string.empty_field_message);
                          Log.i(AppConstant.TAG, "onSubscribe: ");
            return;
        }
        if(getEmail.isEmpty()){
            view.showErrorMessage(R.string.empty_field_message);
            return;
        }
        if(getPassword.isEmpty()){
            view.showErrorMessage(R.string.empty_field_message);
            return;
        }
        if(getPasswordConfirmation.isEmpty()){
            view.showErrorMessage(R.string.empty_field_message);
            return;
        }
        if(getPassword.length()<8){
            view.showErrorMessage(R.string.invalid_password);
        }
        if(!getEmail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            view.showErrorMessage(R.string.email_validation_error);
            view.setProgressBarGone();
            return;
        }
        if(!Commons.CheckConnection(view.getContext())){
            view.showNetworkError();
            view.setProgressBarGone();
            return;
        }

    }

}

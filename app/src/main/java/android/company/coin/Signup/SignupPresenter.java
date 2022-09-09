package android.company.coin.Signup;

import android.company.coin.AppConstant;
import android.company.coin.ContextProvider;
import android.company.coin.Data.Data;
import android.company.coin.Data.LocalRepo;
import android.company.coin.Data.Model.Root;
import android.company.coin.Data.Model.User;
import android.company.coin.R;
import android.company.coin.Utils.Commons;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SignupPresenter implements SignUpContract.Presenter{

    SignUpContract.View view;
    ContextProvider contextProvider;
    Single<User> user;
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
        disposable.dispose();

    }

    @Override
    public void signUpButtonClick(String userName,String email, String passWord,String passwordConfirmation) {
        view.setProgressBarVisible();

        if(!Commons.CheckConnection(view.getContext())){
            view.showNetworkError();
            view.setProgressBarGone();
            return;
        }
        if(!email.endsWith(String.valueOf(R.string.email_contains))){
            view.showEmailValidationError();
            view.setProgressBarGone();
            return;
        }

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

                        Log.i("statusss", "onSuccess: " + root.status);
                        if(root.getUser()!=null){
                          Log.i(AppConstant.TAG, "onSubscribe: ");
                          Log.i("ssds", "onSuccess: "+root.user.getName());
                          localRepo.setUserInfo(root.user);

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
                        view.showSignUpError(e.toString());
                        view.setProgressBarGone();
                    }
                });

    }

    @Override
    public void goToLogIn() {
    }


    @Override
    public void logInButtonClick(String userName,String email,String password) {


    }
}

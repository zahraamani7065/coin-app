package android.company.coin.LogIn;

import android.company.coin.Data.Data;
import android.company.coin.Data.LocalRepo;
import android.company.coin.Data.Model.LogIn.Root;
import android.company.coin.R;
import android.company.coin.Utils.Commons;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LogInPresenter implements LogInContract.Presenter{
    LogInContract.View view;
    LocalRepo localRepo;
    Disposable disposable;

    public LogInPresenter(LocalRepo localRepo) {
        this.localRepo = localRepo;
    }

    @Override
    public void onAttach(LogInContract.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        view=null;
        disposable.dispose();

    }

    @Override
    public void doLogIn(String email, String passWord) {
        view.setProgressBarVisible();
        Data.getInstance(view.getContext()).LogInRequest(email,passWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Root>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable=d;
                    }

                    @Override
                    public void onSuccess(Root root) {
                        if(root.getUser()!=null){
                            localRepo.setUserInfoLogIn(root.getUser());
                            view.showSuccess();
                            onDetach();
                        }
                        else{
                            view.setProgressBarGone();
                            view.showLogInError(root.getMessage());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showLogInError("error");
                    }
                });
    }

    @Override
    public void checkValidation(String getEmail, String getPassword) {
        view.errorMessageGone();
        if(getEmail==null){
            view.showLogInError(R.string.empty_field_message);
            return;
        }

        if(getPassword == null){
            view.showLogInError(R.string.empty_field_message);
            return;
        }
        if(!getEmail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            view.showLogInError(R.string.email_validation_error);
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

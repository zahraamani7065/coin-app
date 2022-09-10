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

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });



    }

}

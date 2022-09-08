package android.company.coin.LogIn;

public class LogInPresenter implements LogInContract.Presenter{
    LogInContract.View view;
    @Override
    public void onAttach(LogInContract.View view) {
        this.view=view;
    }

    @Override
    public void onDetach() {
        view=null;
    }

    @Override
    public void doLogIn(String userName, String passWord) {

    }

    @Override
    public void goToLogIn() {

    }
}

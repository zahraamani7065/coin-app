package android.company.coin.LogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.company.coin.R;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity implements LogInContract.View  {
    EditText email,password;
    Button logInBtn,logInGoogleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }


    @Override
    public void showNetworkError() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showSignUpError() {

    }

    @Override
    public void setProgressBarVisibility() {

    }
    private void initialViews(){
        email=findViewById(R.id.LogIn_email);
        password=findViewById(R.id.log_in_password);
        logInBtn=findViewById(R.id.login_button);
        logInGoogleBtn=findViewById(R.id.sign_up_google_btn);

    }
}
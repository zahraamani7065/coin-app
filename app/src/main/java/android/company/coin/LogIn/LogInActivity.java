package android.company.coin.LogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.company.coin.Data.LocalRepo;
import android.company.coin.Main.MainActivity;
import android.company.coin.R;
import android.company.coin.Signup.SignUpActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity implements LogInContract.View  {

    EditText email,password;
    Button logInBtn,logInGoogleBtn,signUpBtn;
    TextView errorMessage;
    ProgressBar progressBar;
    LogInContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initialViews();
        presenter=new LogInPresenter(LocalRepo.getInstance(this));
        presenter.onAttach(this);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getEmail=email.getText().toString().trim();
                String getPassword=password.getText().toString().trim();

                Log.i("email", "onCreate: "+getEmail);
                presenter.checkValidation(getEmail,getPassword);

                if(errorMessage.getText()==""){
                presenter.doLogIn(getEmail,getPassword);
                }

            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this, SignUpActivity.class));
                finish();
            }
        });


    }



    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setProgressBarVisible() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void setProgressBarGone() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLogInError(int message) {
        errorMessage.setText(message);
    }

    @Override
    public void errorMessageGone() {
        errorMessage.setText("");
    }

    @Override
    public void showSuccess() {
        startActivity(new Intent(LogInActivity.this, MainActivity.class));
        Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showLogInError(String massage) {
        errorMessage.setText(massage);
    }

    private void initialViews(){
        email=findViewById(R.id.LogIn_email);
        password=findViewById(R.id.log_in_password);
        logInBtn=findViewById(R.id.login_button);
        logInGoogleBtn=findViewById(R.id.sign_up_google_btn);
        errorMessage=findViewById(R.id.LogIn_error_Message);
        progressBar=findViewById(R.id.logIn_progressBar);
        signUpBtn=findViewById(R.id.log_in_sign_up);

    }

    @Override
    public void showNetworkError() {

    }
}
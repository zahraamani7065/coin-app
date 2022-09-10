package android.company.coin.LogIn;

import androidx.appcompat.app.AppCompatActivity;

import android.company.coin.Data.LocalRepo;
import android.company.coin.R;
import android.company.coin.Signup.SignUpActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

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
        presenter=new LogInPresenter(LocalRepo.getInstance(this));
        presenter.onAttach(this);
        initialViews();
        String getEmail=email.getText().toString();
        if(getEmail.isEmpty()){
            errorMessage.setText(R.string.empty_field_message);
        }
        String getPassword=password.getText().toString();
        if(getPassword.isEmpty()){
            errorMessage.setText(R.string.empty_field_message);
        }
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.doLogIn(getEmail,getPassword);

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
    public void showNetworkError() {

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
    public void showEmailValidationError() {
        errorMessage.setText(R.string.email_validation_error);
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
}
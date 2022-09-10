package android.company.coin.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.company.coin.LogIn.LogInActivity;
import android.company.coin.Main.MainActivity;
import android.company.coin.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View {
    Button logInBtn,signUpBtn,signUpGoogleBtn;
    EditText fullName,email,password,passwordConfirmation;
    ProgressBar progressBar;
    SignUpContract.Presenter signUpPresenter;
    public static TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpPresenter=new SignupPresenter();
        initialView();
        signUpPresenter.onAttach(this);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String getUserName=fullName.getText().toString();
                 String getEmail=email.getText().toString().trim();
                 String getPassword=password.getText().toString();
                 String getPasswordConfirmation=passwordConfirmation.getText().toString();

                 signUpPresenter.checkValidation(getUserName,getEmail,getPassword,getPasswordConfirmation);

                 if(errorMessage.getText()==""){
                     signUpPresenter.doSignUp(getUserName,getEmail,getPassword,getPasswordConfirmation);
                 }
            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LogInActivity.class));
            }
        });


    }
    @Override
    public void showErrorMessage(int text) {
        errorMessage.setText(text);

    }

    @Override
    public void showSignUpError(String message) {
        errorMessage.setText(message);
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
    public void showSignUpSuccessFull() {
        setProgressBarVisible();
        MainActivity.start(this);
        Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public void errorMassageGone() {
        errorMessage.setText("");
    }

    private void initialView() {
        logInBtn=findViewById(R.id.log_in_Button);
        signUpBtn=findViewById(R.id.sign_up_button);
        signUpGoogleBtn=findViewById(R.id.sign_up_google_btn);
        fullName=findViewById(R.id.sign_up_Full_name);
        email=findViewById(R.id.sign_up_email);
        password=findViewById(R.id.sing_up_password);
        passwordConfirmation=findViewById(R.id.sing_up_password_confirmation);
        errorMessage=findViewById(R.id.error_Message);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void showNetworkError() {
        setProgressBarVisible();
        errorMessage.setText(R.string.network_not_available_error);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signUpPresenter.onDetach();
    }
}
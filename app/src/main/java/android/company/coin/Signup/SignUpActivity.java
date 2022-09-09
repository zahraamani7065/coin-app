package android.company.coin.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

                if(fullName.getText()==null){
                        errorMessage.setText(R.string.empty_field_message);
                        return;
                }

                String getEmail=email.getText().toString();
                if(getEmail.isEmpty()){
                    errorMessage.setText(R.string.empty_field_message);
                    return;
                }

                String getPassword=password.getText().toString();
                 if(getPassword.isEmpty()){
                    errorMessage.setText(R.string.empty_field_message);
                    return;
                }

                if(getPassword.length()<8){
                     errorMessage.setText(R.string.invalid_password);
                     return;
                 }

                 String getPasswordConfirmation=passwordConfirmation.getText().toString();

                 if(getPasswordConfirmation.isEmpty()){
                     errorMessage.setText(R.string.empty_field_message);
                     return;
                 }


                 signUpPresenter.signUpButtonClick(getUserName,getEmail,getPassword,getPasswordConfirmation);

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
    public void showSignUpError(String text) {
        errorMessage.setText(text);

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
        finish();
    }

    @Override
    public void showEmailValidationError() {
        errorMessage.setText(R.string.email_validation_error);
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
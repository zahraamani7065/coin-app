package android.company.coin.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.company.coin.ContextProvider;
import android.company.coin.R;
import android.content.Context;
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
    TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpPresenter=new SignupPresenter();
        initialView();
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUserName=fullName.getText().toString();
                if(getUserName.isEmpty()){
                        errorMessage.setText(R.string.empty_field_message);
                }

                String getEmail=email.getText().toString();
                if(getEmail.isEmpty()){
                    errorMessage.setText(R.string.empty_field_message);
                }

                String getPassword=password.getText().toString();
                 if(getPassword.isEmpty()){
                    errorMessage.setText(R.string.empty_field_message);
                }

                 else if(getPassword.length()<8){
                     errorMessage.setText(R.string.invalid_password);
                 }

                 String getPasswordConfirmation=passwordConfirmation.getText().toString();
                 if(getPasswordConfirmation.isEmpty()){
                     errorMessage.setText(R.string.empty_field_message);
                 }

                 if(getPassword!=getPasswordConfirmation){
                     errorMessage.setText(R.string.passwordConfirmation);
                 }
                 signUpPresenter.logInButtonClick(getUserName,getEmail,getPassword);

            }
        });
    }
    @Override
    public void showSignUpError() {
    }

    @Override
    public void setProgressBarVisibility() {
        if(progressBar.getVisibility()==View.VISIBLE){
            progressBar.setVisibility(View.GONE);
        }
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

        progressBar=findViewById(R.id.progressBar);

    }


    @Override
    public void showNetworkError() {
        dismissDialog();
        errorMessage.setText(R.string.network_not_available_error);


    }
    private void dismissDialog(){
        if(progressBar.getVisibility()==View.GONE){
            progressBar.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public Context getContext() {
        return this;
    }
}
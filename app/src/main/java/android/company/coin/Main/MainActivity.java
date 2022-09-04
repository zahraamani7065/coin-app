package android.company.coin.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.company.coin.Data.LocalRepo;
import android.company.coin.R;
import android.company.coin.Signup.SignUpActivity;
import android.company.coin.Signup.SignUpContract;
import android.company.coin.Signup.SignupPresenter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   Button logOutBtn;
   LocalRepo localRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logOutBtn=findViewById(R.id.log_out_btn);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localRepo=LocalRepo.getInstance(getApplicationContext());
                localRepo.logOut();
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });


    }
    public static void start(Activity activity){
        Intent intent=new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }

}
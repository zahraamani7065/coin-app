package android.company.coin.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.company.coin.LogIn.LogInActivity;
import android.company.coin.R;
import android.company.coin.Signup.SignUpActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashActivity extends AppCompatActivity {
    private TextView splashText;
    Animation animationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashText=findViewById(R.id.text_splash);
        animationText= AnimationUtils.loadAnimation(this,R.anim.text_animation);


        splashText.setAnimation(animationText);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(splashActivity.this, SignUpActivity.class));
                finish();
            }
        }.start();

    }
}
package android.company.coin.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.company.coin.R;
import android.content.Context;
import android.os.Bundle;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity implements HomePageContract.View {
   HomePageContract.Presenter presenter;
   BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initialViews();
        presenter.onAttach(this);
        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        presenter.navigation(bottomNavigationView,navHostFragment);
//        NavController navController= Navigation.findNavController(this,R.id.fragment);
//        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }
    @Override
    public void showNetworkError() {
    }

    @Override
    public Activity getContext() {
        return this;
    }

    @Override
    public void showTitle() {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbarMain));
    }

    private void initialViews(){
         bottomNavigationView=findViewById(R.id.bottomNavigation_main);
         presenter=new HomePagePresenter(this);
    }
}
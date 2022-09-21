package android.company.coin.Main;

import android.company.coin.R;
import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePagePresenter implements HomePageContract.Presenter{
    HomePageContract.View view ;

    public HomePagePresenter(HomePageContract.View view) {
        this.view = view;
    }

    @Override
    public void onAttach(HomePageContract.View view) {
        this.view=view;
        this.view.showTitle();
    }

    @Override
    public void onDetach() {
        view=null;
    }

    @Override
    public void navigation(BottomNavigationView bottomNavigationView,NavHostFragment navHostFragment) {

        NavController navController= Navigation.findNavController(view.getContext(),R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
//        NavController navController=navHostFragment.getNavController();


    }
}

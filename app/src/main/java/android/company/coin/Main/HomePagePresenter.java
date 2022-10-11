package android.company.coin.Main;

import android.app.Activity;
import android.company.coin.R;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
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
    public void navigation(BottomNavigationView bottomNavigationView) {

        NavController navController= Navigation.findNavController((Activity) view.getContext(),R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }

    @Override
    public void getListCrypto() {



    }
}

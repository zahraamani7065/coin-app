package android.company.coin.Fragments.HomeFragment;


import android.annotation.SuppressLint;
import android.company.coin.R;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;


public class HomeFragment extends Fragment implements HomeFragmentContract.View {
  RecyclerView rv;
  TextView errorMessage,loadMore;
  HomeFragmentContract.Presenter presenter;
  ShimmerFrameLayout shimmerFrameLayout;
  Button topCoinsBtn, topGainersBtn, topLosersBtn;
  public static String selectedCoin;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_home, container, false);
        viewBinding(view);
        shimmerFrameLayout.startShimmer();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);

        presenter=new HomeFragmentPresenter(rv);
        presenter.onAttach(this);
        presenter.loadCoinList();
        selectedCoin="mainCoins";
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadMoreItems();
            }
        });

        topCoinsBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                rv.setVisibility(View.GONE);
                shimmerFrameLayout.startShimmer();
                topGainersBtn.setBackgroundResource(R.drawable.button_background_top_coins);
                topLosersBtn.setBackgroundResource(R.drawable.button_background_top_coins);
                topCoinsBtn.setBackgroundResource(R.drawable.button_bachground_coins_clicked);
                presenter.loadTopCoins();
                selectedCoin="topCoins";
            }
        });

        topGainersBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {

                rv.setVisibility(View.GONE);
                shimmerFrameLayout.startShimmer();
                topGainersBtn.setBackgroundResource(R.drawable.button_bachground_coins_clicked);
                topLosersBtn.setBackgroundResource(R.drawable.button_background_top_coins);
                topCoinsBtn.setBackgroundResource(R.drawable.button_background_top_coins);
                presenter.loadTopGainers();
                selectedCoin="gainerCoins";

            }
        });

        topLosersBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                topGainersBtn.setBackgroundResource(R.drawable.button_background_top_coins);
                topLosersBtn.setBackgroundResource(R.drawable.button_bachground_coins_clicked);
                topCoinsBtn.setBackgroundResource(R.drawable.button_background_top_coins);
                rv.setVisibility(View.GONE);
                shimmerFrameLayout.startShimmer();

                presenter.loadTopLosers();
                selectedCoin="LoserCoins";
            }
        });

    }

    @Override
    public void showNetworkError() {
    }

    @Override
    public void showErrorMessage() {
        errorMessage.setVisibility(View.VISIBLE);
        errorMessage.setText(R.string.network_not_available_error);
        rv.setVisibility(View.GONE);
        shimmerFrameLayout.setVisibility(View.GONE);

    }

    @Override
    public void showLoadMore() {
        loadMore.setVisibility(View.VISIBLE);

    }

    @Override
    public void stopShimmer() {
        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);
    }

    @Override
    public void showRecyclerView() {
        rv.setVisibility(View.VISIBLE);
    }

    private void viewBinding(View view){
        rv=view.findViewById(R.id.rc_list_crypto);
        shimmerFrameLayout=view.findViewById(R.id.shimmer);
        errorMessage=view.findViewById(R.id.error_message_homeFragment);
        loadMore=view.findViewById(R.id.load_more);
        topCoinsBtn =view.findViewById(R.id.btn_top_coins);
        topGainersBtn =view.findViewById(R.id.btn_top_gainers);
        topLosersBtn =view.findViewById(R.id.btn_top_losers);
    }

}
package android.company.coin.Fragments.HomeFragment;


import android.company.coin.R;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeFragment extends Fragment implements HomeFragmentContract.View {
  RecyclerView rv;
  TextView loadTextView,errorMessage,loadMore;
  HomeFragmentContract.Presenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_home, container, false);
        presenter=new HomeFragmentPresenter();
        rv=view.findViewById(R.id.rc_list_crypto);
        loadTextView=view.findViewById(R.id.loading_textView);
        errorMessage=view.findViewById(R.id.error_message_homeFragment);
        loadMore=view.findViewById(R.id.load_more);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        presenter.onAttach(this);
        presenter.loadCoinList(rv);
        loadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadMoreItems();
            }
        });
        return view;
    }


    @Override
    public void showNetworkError() {
    }

    @Override
    public void showLoading() {
    loadTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void GoneLoading() {
        loadTextView.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(Throwable e) {
        errorMessage.setVisibility(View.VISIBLE);
        errorMessage.setText(e.toString());
    }

    @Override
    public void showLoadMore() {
        loadMore.setVisibility(View.VISIBLE);

    }

}
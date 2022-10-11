package android.company.coin.Fragments.HomeFragment;

import android.app.Activity;
import android.app.Application;
import android.company.coin.R;
import android.company.coin.adapter.CryptoListAdapter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

public class HomeFragment extends Fragment implements HomeFragmentContract.View {
  RecyclerView rv;
  TextView loadTextView,errorMessage;
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
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        presenter.onAttach(this);
        presenter.loadCoinList(rv);
        return view;

    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        presenter=new HomeFragmentPresenter();
//        rv=getActivity().findViewById(R.id.rc_list_crypto);
//        loadTextView=getActivity().findViewById(R.id.loading_textView);
//        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//        presenter.onAttach(this);
//        presenter.loadCoinList(rv);
//    }

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

}
package android.company.coin.Fragments.ChatBarFragment;

import android.company.coin.Fragments.HomeFragment.HomeFragmentContract;
import android.company.coin.Fragments.HomeFragment.HomeFragmentPresenter;
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
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

import org.jetbrains.annotations.Contract;


public class ChatBarFragment extends Fragment implements ChatBarFragmentContract.View{
    RecyclerView rv;
    TextView errorMessage,loadMore;
    ChatBarFragmentContract.Presenter presenter;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_chat_bar, container, false);
        viewBinding(view);

        shimmerFrameLayout.startShimmer();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);

        presenter=new ChatBarFragmentPresenter(rv);
        presenter.onAttach(this);
        presenter.loadCoinList();

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
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showErrorMessage() {

        shimmerFrameLayout.setVisibility(View.GONE);
        shimmerFrameLayout.setVisibility(View.GONE);
        rv.setVisibility(View.GONE);
        errorMessage.setVisibility(View.VISIBLE);
        errorMessage.setText(R.string.network_not_available_error);


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
    void viewBinding(View view){

        rv=view.findViewById(R.id.rc_list_crypto_chatBar);
        shimmerFrameLayout=view.findViewById(R.id.shimmer_chatBar);
        errorMessage=view.findViewById(R.id.error_message_chatBarFragment);
        loadMore=view.findViewById(R.id.load_more_chatBar);

    }
}
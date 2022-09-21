package android.company.coin.Fragments.ProfileFragment;

import android.company.coin.Data.LocalRepo;
import android.company.coin.R;
import android.company.coin.Signup.SignUpActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfileFragment extends Fragment {
    Button buttonLogOut;
    LocalRepo localRepo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonLogOut=getView().findViewById(R.id.log_out_btn);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localRepo= LocalRepo.getInstance(getContext());
                localRepo.logOut();
                startActivity(new Intent(getActivity(), SignUpActivity.class));

            }
        });
    }
}
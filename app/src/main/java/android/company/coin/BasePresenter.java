package android.company.coin;

import android.company.coin.BaseView;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);

    void onDetach();
}

package android.company.coin;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);

    void onDetach();
}

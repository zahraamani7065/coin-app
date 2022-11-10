package android.company.coin.Data.Model.TopGainers;

import java.util.ArrayList;

public class Data {
    public ArrayList<CryptoCurrencyList> cryptoCurrencyList;
    public String totalCount;

    public ArrayList<CryptoCurrencyList> getCryptoCurrencyList() {
        return cryptoCurrencyList;
    }

    public void setCryptoCurrencyList(ArrayList<CryptoCurrencyList> cryptoCurrencyList) {
        this.cryptoCurrencyList = cryptoCurrencyList;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}

package android.company.coin.Data.Model.TopCoins;

import android.company.coin.Data.Model.ListCoin.Quote;

import java.util.ArrayList;
import java.util.Date;

public class CryptoCurrencyList {
    public int id;
    public String name;
    public String symbol;
    public String slug;
    public int cmcRank;
    public int marketPairCount;
    public double circulatingSupply;
    public int selfReportedCirculatingSupply;
    public double totalSupply;
    public double maxSupply;
    public double ath;
    public double atl;
    public double high24h;
    public double low24h;
    public int isActive;
    public Date lastUpdated;
    public Date dateAdded;
    public ArrayList<Quote> quotes;
    public boolean isAudited;
    public ArrayList<AuditInfoList> auditInfoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getCmcRank() {
        return cmcRank;
    }

    public void setCmcRank(int cmcRank) {
        this.cmcRank = cmcRank;
    }

    public int getMarketPairCount() {
        return marketPairCount;
    }

    public void setMarketPairCount(int marketPairCount) {
        this.marketPairCount = marketPairCount;
    }

    public double getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(double circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public int getSelfReportedCirculatingSupply() {
        return selfReportedCirculatingSupply;
    }

    public void setSelfReportedCirculatingSupply(int selfReportedCirculatingSupply) {
        this.selfReportedCirculatingSupply = selfReportedCirculatingSupply;
    }

    public double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public double getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(double maxSupply) {
        this.maxSupply = maxSupply;
    }

    public double getAth() {
        return ath;
    }

    public void setAth(double ath) {
        this.ath = ath;
    }

    public double getAtl() {
        return atl;
    }

    public void setAtl(double atl) {
        this.atl = atl;
    }

    public double getHigh24h() {
        return high24h;
    }

    public void setHigh24h(double high24h) {
        this.high24h = high24h;
    }

    public double getLow24h() {
        return low24h;
    }

    public void setLow24h(double low24h) {
        this.low24h = low24h;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }

    public boolean isAudited() {
        return isAudited;
    }

    public void setAudited(boolean audited) {
        isAudited = audited;
    }

    public ArrayList<AuditInfoList> getAuditInfoList() {
        return auditInfoList;
    }

    public void setAuditInfoList(ArrayList<AuditInfoList> auditInfoList) {
        this.auditInfoList = auditInfoList;
    }
}

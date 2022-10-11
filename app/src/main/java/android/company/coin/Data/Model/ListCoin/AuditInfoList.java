package android.company.coin.Data.Model.ListCoin;

public class AuditInfoList {
    public String coinId;
    public String auditor;
    public int auditStatus;
    public String reportUrl;
    public String score;
    public Object auditTime;
    public String contractAddress;
    public String contractPlatform;

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Object getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Object auditTime) {
        this.auditTime = auditTime;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getContractPlatform() {
        return contractPlatform;
    }

    public void setContractPlatform(String contractPlatform) {
        this.contractPlatform = contractPlatform;
    }
}
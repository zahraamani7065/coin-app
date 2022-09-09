package android.company.coin.Data.Model;

public class Status {
    public Status(String message) {
        this.message = message;
    }

    public Status() {

    }

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

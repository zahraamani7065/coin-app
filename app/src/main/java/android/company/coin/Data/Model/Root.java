package android.company.coin.Data.Model;

public class Root {
    public User user;
    public String token;
    public Status status;

    public Root(User user, String token, Status status) {
        this.user = user;
        this.token = token;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

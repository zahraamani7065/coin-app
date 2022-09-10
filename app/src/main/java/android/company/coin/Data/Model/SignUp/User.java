package android.company.coin.Data.Model.SignUp;

import java.util.Date;

public class User {


    public String name;
    public String email;
    public int authenticate_state;
    public String authenticate_state_name;
    public Date updated_at;
    public Date created_at;
    public int id;

    public User(String name, String email, int authenticate_state, String authenticate_state_name, Date updated_at, Date created_at, int id) {
        this.name = name;
        this.email = email;
        this.authenticate_state = authenticate_state;
        this.authenticate_state_name = authenticate_state_name;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAuthenticate_state() {
        return authenticate_state;
    }

    public void setAuthenticate_state(int authenticate_state) {
        this.authenticate_state = authenticate_state;
    }

    public String getAuthenticate_state_name() {
        return authenticate_state_name;
    }

    public void setAuthenticate_state_name(String authenticate_state_name) {
        this.authenticate_state_name = authenticate_state_name;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

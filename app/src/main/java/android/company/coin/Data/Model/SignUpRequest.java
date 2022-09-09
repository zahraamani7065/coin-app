package android.company.coin.Data.Model;

public class SignUpRequest {
    String name;
    String password;
    String email;
    String password_confirmation;
    




    public void setPasswordConfirmation(String passwordConfirmation) {
        this.password_confirmation = passwordConfirmation;
    }
    public String getPasswordConfirmation() {
        return password_confirmation;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

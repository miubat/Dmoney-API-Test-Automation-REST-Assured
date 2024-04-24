package utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserModel {
    private String email;
    private String password;
    private String name;
    private String phone_number;
    private String nid;
    private String role;

    private String from_account;
    private String to_account;
    private String amount;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserModel(String name, String email, String password, String phone_number, String nid, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.nid = nid;
        this.role = role;
    }

    public UserModel(String from_account, String to_account, String amount) {
        this.from_account = from_account;
        this.to_account = to_account;
        this.amount = amount;
    }

    public UserModel() {

    }
}

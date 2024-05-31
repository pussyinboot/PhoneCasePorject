package org.example.dto;

public class LoginDataTransferObject {
    private String Customid;
    private String CustomerPassword;

    public LoginDataTransferObject(String Customid, String CustomerPassword) {
        this.Customid = Customid;
        this.CustomerPassword = CustomerPassword;
    }
}

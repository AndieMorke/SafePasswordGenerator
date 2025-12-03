package PasswordController;
import model.Password;

public class PasswordController {

    public static void main(String[] args) {

        Password pwd = new Password();
        pwd.setUserPassword(12);
        pwd.fillUserPassword();

        while(!pwd.safePassword()){
            pwd.fillUserPassword();
        }

        pwd.showPassword();


    }
}


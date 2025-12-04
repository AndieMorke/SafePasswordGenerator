package controller;
import model.Password;
import view.PasswordView;

public class Main {
    public static void main(String[] args) {
        Password pwd = new Password();
        PasswordView view = new PasswordView();
        boolean exit = false;

        do {
            if (view.menu() == 1) {
                pwd.setUserPassword(view.askLength());
                pwd.createUserPassword();
                view.showPassword(pwd);

            } else exit = true;

        }while (!exit);






    }
}



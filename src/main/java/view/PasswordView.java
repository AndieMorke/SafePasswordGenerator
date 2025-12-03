package view;

public class PasswordView {

    public void showPassword() {
        for (int i = 0; i < this.getUserPassword().length; i++) {
            System.out.print(this.getUserPassword()[i]);
        }
    }
}
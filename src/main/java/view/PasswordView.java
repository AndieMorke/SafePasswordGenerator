package view;

import model.Password;

import java.util.Scanner;

public class PasswordView {
    Scanner input = new Scanner(System.in);
    public void showPassword(Password pwd) {
        System.out.println("-------------------");
        System.out.print(new String(pwd.getUserPassword()));
        System.out.println();
        System.out.println("-------------------");
    }

    public int askLength(){

        try {
            int length;
            do {
                System.out.print("Introduzca la longitud deseada para la contraseña: ");
                length = input.nextInt();
                if (length > 0) {
                    return length;
                } else if (length <= 0) {
                    System.out.println("Cifra incorrecta. Introduzca un número mayor que 0: ");
                }
            } while (length<=0);
            return length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public int menu(){
        try {
            int option;

            do {
                System.out.print("1 - Generar contraseña\n2 - SALIR\nSeleccione la opción deseada: ");
                option = input.nextInt();
                while (option<1 || option >2){
                    System.out.println("Opción incorrecta, introduzca un valor válido (1-2)");
                    option = input.nextInt();
                }

            } while (option<1 || option >2);
            if (option==2){
                System.out.println("¡Hasta luego!");
            }
            return option;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}



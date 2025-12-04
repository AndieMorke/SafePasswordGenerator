package model;

import java.util.Random;

public class Password {

    Random random = new Random();

    // Atributos
    private char[] characters;
    private char[] specialCharacters;
    private char[] upperCaseCharacters;
    private char[] numbers;
    private char[] userPassword;

    public Password() {
        this.setSpecialCharacters();
        this.setUpperCaseCharacters();
        this.setNumbers();
    }

    // SETTER Y GETTER para los caracteres
    public void setCharacters() {
        this.characters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    }

    public char[] getCharacters() {
        return this.characters;
    }


    // SETTER Y GETTER para los caracteres especiales
    public void setSpecialCharacters() {
        this.specialCharacters = new char[]{'!', '@', '#', '$', '%', '*', '(', ')', '_', '+', '-', '=', '[', ']', '{', '}', '.', ',', '?'};
    }

    public char[] getSpecialCharacters() {
        return this.specialCharacters;
    }


    // SETTER Y GETTER para los caracteres en mayúsculas
    public void setUpperCaseCharacters() {
        this.setCharacters();
        this.upperCaseCharacters = new char[getCharacters().length];
        for (int i = 0; i < characters.length; i++) {
            this.upperCaseCharacters[i] = Character.toUpperCase(this.getCharacters()[i]);
        }
    }

    public char[] getUpperCaseCharacters() {
        return this.upperCaseCharacters;
    }


    // SETTER Y GETTER para los números
    public void setNumbers() {
        this.numbers = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    }

    public char[] getNumbers() {
        return this.numbers;
    }


    // SETTER Y GETTER para la contraseña a generar
    public void setUserPassword(int length) {
        this.userPassword = new char[length];
    }

    public char[] getUserPassword() {
        return this.userPassword;
    }


    public void createUserPassword() {

        boolean hasNumber, hasSpecial, hasUpper;
        hasNumber = false;
        hasSpecial = false;
        hasUpper = false;

        for (int i = 0; i < this.getUserPassword().length; i++) {
            do {
                switch (random.nextInt(4)) {
                    case 0:
                        this.userPassword[i] = this.getCharacters()[random.nextInt(this.getCharacters().length)];
                        break;
                    case 1:
                        this.userPassword[i] = this.getUpperCaseCharacters()[random.nextInt(this.getUpperCaseCharacters().length)];
                        hasUpper = true;
                        break;
                    case 2:
                        this.userPassword[i] = this.getSpecialCharacters()[random.nextInt(this.getSpecialCharacters().length)];
                        hasSpecial = true;
                        break;
                    case 3:
                        this.userPassword[i] = this.getNumbers()[random.nextInt(this.getNumbers().length)];
                        hasNumber = true;
                        break;
                }
            } while ((i > 0) && this.getUserPassword()[i] == this.getUserPassword()[i - 1]);
        }
        if(!hasUpper){
            this.userPassword[random.nextInt(this.getUserPassword().length)] = this.getUpperCaseCharacters()[random.nextInt(this.getUpperCaseCharacters().length)];
        }
        if(!hasSpecial){
            this.userPassword[random.nextInt(this.getUserPassword().length)] = this.getSpecialCharacters()[random.nextInt(this.getSpecialCharacters().length)];
        }
        if(!hasNumber){
            this.userPassword[random.nextInt(this.getUserPassword().length)] = this.getNumbers()[random.nextInt(this.getNumbers().length)];
        }
    }
}





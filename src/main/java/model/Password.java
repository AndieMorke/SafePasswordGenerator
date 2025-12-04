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
        this.characters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }
    public char[] getCharacters() {
        return this.characters;
    }


    // SETTER Y GETTER para los caracteres especiales
    public void setSpecialCharacters() {
        this.specialCharacters = new char[]{'!','@','#','$','%','*','(',')','_','+','-','=','[',']','{','}', '.',',','?'};
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
        this.numbers = new char[]{'1','2','3','4','5','6','7','8','9','0'};
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


    // Crear contraseña
    public void createUserPassword() {


        // Colocar los caracteres de forma aleatoria confirmando que no se repitan de forma consecutiva
        for (int i = 0; i < this.getUserPassword().length; i++) {
            switch (random.nextInt(4)) {
                case 0: // letra minúscula
                    this.userPassword[i] = this.getCharacters()[random.nextInt(this.getCharacters().length)];
                    if (i > 0) {
                        while (this.userPassword[i] == this.userPassword[i - 1]) {
                            this.userPassword[i] = this.getCharacters()[random.nextInt(this.getCharacters().length)];
                        }
                    }
                    break;
                case 1: // especial
                    this.userPassword[i] = this.getSpecialCharacters()[random.nextInt(this.getSpecialCharacters().length)];
                    if (i > 0) {
                        while (this.userPassword[i] == this.userPassword[i - 1]) {
                            this.userPassword[i] = this.getSpecialCharacters()[random.nextInt(this.getSpecialCharacters().length)];
                        }
                    }
                    break;
                case 2: // mayúscula
                    this.userPassword[i] = this.getUpperCaseCharacters()[random.nextInt(this.getUpperCaseCharacters().length)];
                    if (i > 0) {
                        while (this.userPassword[i] == this.userPassword[i - 1]) {
                            this.userPassword[i] = this.getUpperCaseCharacters()[random.nextInt(this.getUpperCaseCharacters().length)];
                        }
                    }
                    break;
                case 3: // número
                    this.userPassword[i] = this.getNumbers()[random.nextInt(this.getNumbers().length)];
                    if (i > 0) {
                        while (this.userPassword[i] == this.userPassword[i - 1]) {
                            this.userPassword[i] = this.getNumbers()[random.nextInt(this.getNumbers().length)];
                        }
                    }
                    break;
            }
        }


    }


    // Comprobar seguridad (Debe contener al menos una mayúscula, un carácter especial y un número)
    public boolean safePassword() {
        boolean upper, special, number;
        upper = false;
        special = false;
        number = false;


        for (int i = 0; i < this.getUserPassword().length; i++) {
            for (int j = 0; j < this.getSpecialCharacters().length; j++) {
                if (this.getUserPassword()[i] == this.getSpecialCharacters()[j]) {
                    special = true;
                    break;
                }
            }
            for (int k = 0; k < this.getUpperCaseCharacters().length; k++) {
                if (this.getUserPassword()[i] == this.getUpperCaseCharacters()[k]) {
                    upper = true;
                    break;
                }
            }
            for (int l = 0; l < this.getNumbers().length; l++) {
                if (this.getUserPassword()[i] == this.getNumbers()[l]) {
                    number = true;
                    break;
                }
            }
            if(special && number && upper){
                break;
            }
        }
        return special && number && upper;
    }

}







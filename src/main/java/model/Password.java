package model;

import java.util.Random;

public class Password {

    /**
     * Atributos
     */
    private char[] lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] numbers = "0123456789".toCharArray();
    private char[] specialCharacters = "!@#$%*()_+-=[]{}.,?".toCharArray();
    private char[] upperCaseCharacters;
    private char[] userPassword;
    private final Random RANDOM;
    private boolean hasLower,hasUpper,hasSpecial,hasNumber;
    private enum CharType {LOWER,UPPER,SPECIAL,NUMBER}

    /**
     * CONSTRUCTOR
     */
    public Password() {
        upperCaseCharacters = new char[lowerCaseCharacters.length];
        for (int i = 0; i < lowerCaseCharacters.length; i++) {
            upperCaseCharacters[i] = Character.toUpperCase(lowerCaseCharacters[i]);
        }
        RANDOM = new Random();
    }

    public char[] getLowerCaseCharacters() {
        return this.lowerCaseCharacters;
    }
    public char[] getNumbers() {
        return this.numbers;
    }
    public char[] getSpecialCharacters() {
        return this.specialCharacters;
    }
    public char[] getUpperCaseCharacters() {
        return this.upperCaseCharacters;
    }

    public boolean hasNumber() {
        return this.hasNumber;
    }
    public void setHasNumber(boolean hasNumber) {
        this.hasNumber = hasNumber;
    }
    public boolean hasSpecial() {
        return this.hasSpecial;
    }
    public void setHasSpecial(boolean hasSpecial) {
        this.hasSpecial = hasSpecial;
    }
    public boolean hasUpper() {
        return this.hasUpper;
    }
    public void setHasUpper(boolean hasUpper) {
        this.hasUpper = hasUpper;
    }
    public boolean hasLower() {
        return this.hasLower;
    }
    public void setHasLower(boolean hasLower) {
        this.hasLower = hasLower;
    }

    public void setUserPassword(int length) {
        this.userPassword = new char[length];
    }
    public char[] getUserPassword() {
        return this.userPassword;
    }

    public char[] getRandomCharacterType(){
        CharType charType = CharType.values()[RANDOM.nextInt(CharType.values().length)];
        return switch (charType) {
            case LOWER -> this.getLowerCaseCharacters();
            case UPPER -> this.getUpperCaseCharacters();
            case SPECIAL -> this.getSpecialCharacters();
            case NUMBER -> this.getNumbers();
        };
    }
    public void setRandomIndexAndRandomCharacter(char[] charArray) {
        int randomIndex;
        char randomChar;
        do {
            randomIndex = this.getRandomIndex();
            randomChar = this.getRandomCharacter(charArray);
        } while ((randomIndex > 0 && this.userPassword[randomIndex - 1] == randomChar)
                || (randomIndex < userPassword.length - 1 && this.userPassword[randomIndex + 1] == randomChar));
        this.userPassword[randomIndex] = randomChar;
    }
    public int getRandomIndex(){
        return RANDOM.nextInt(this.getUserPassword().length);
    }
    public void setRandomCharacter(int index,char[] array){
        this.userPassword[index] = this.getRandomCharacter(array);
    }
    public char getRandomCharacter(char[] array){
        return array[RANDOM.nextInt(array.length)];
    }

    public boolean areConsecutive(int position){
        return ((position > 0) && (this.getUserPassword()[position] == this.getUserPassword()[position - 1]));
    }
    public void fillMissingCharacterTypes(){
        while(!this.hasUpper() || !this.hasLower() || !this.hasSpecial() || !this.hasNumber()){
            if(!this.hasUpper()){
                setRandomIndexAndRandomCharacter(this.getUpperCaseCharacters());
                this.setHasUpper(true);
            }
            if(!this.hasSpecial()){
                this.setRandomIndexAndRandomCharacter(this.getSpecialCharacters());
                this.setHasSpecial(true);
            }
            if(!this.hasNumber()){
                this.setRandomIndexAndRandomCharacter(this.getNumbers());
                this.setHasNumber(true);
            }
            if(!this.hasLower()){
                this.setRandomIndexAndRandomCharacter(this.getLowerCaseCharacters());
                this.setHasLower(true);
            }
        }
    }

    public void createUserPassword() {

        for (int i = 0; i < this.getUserPassword().length; i++) {

            do {
                this.setRandomCharacter(i,this.getRandomCharacterType());
            } while (this.areConsecutive(i));
        }

        this.fillMissingCharacterTypes();
    }
}

package model;

import java.util.Random;

/**
 * Clase para generar contraseñas aleatorias con letras, números y símbolos.
 */
public class Password {

    /** Letras minúsculas disponibles */
    private char[] lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /** Números disponibles */
    private char[] numbers = "0123456789".toCharArray();

    /** Caracteres especiales disponibles */
    private char[] specialCharacters = "!@#$%*()_+-=[]{}.,?".toCharArray();

    /** Letras mayúsculas generadas a partir de las minúsculas */
    private char[] upperCaseCharacters;

    /** Contraseña generada */
    private char[] userPassword;

    /** Generador de números aleatorios */
    private final Random RANDOM;

    /** Banderas que indican la presencia de cada tipo de carácter */
    private boolean hasLower, hasUpper, hasSpecial, hasNumber;

    /** Tipos de caracteres posibles */
    private enum CharType {LOWER, UPPER, SPECIAL, NUMBER}

    /**
     * Constructor que inicializa caracteres en mayúscula y generador aleatorio.
     */
    public Password() {
        upperCaseCharacters = new char[lowerCaseCharacters.length];
        for (int i = 0; i < lowerCaseCharacters.length; i++) {
            upperCaseCharacters[i] = Character.toUpperCase(lowerCaseCharacters[i]);
        }
        RANDOM = new Random();
    }

    /** Getters de arrays de caracteres */
    public char[] getLowerCaseCharacters() { return lowerCaseCharacters; }
    public char[] getNumbers() { return numbers; }
    public char[] getSpecialCharacters() { return specialCharacters; }
    public char[] getUpperCaseCharacters() { return upperCaseCharacters; }

    /** Getters y setters de banderas de tipos de carácter */
    public boolean hasNumber() { return hasNumber; }
    public void setHasNumber(boolean hasNumber) { this.hasNumber = hasNumber; }
    public boolean hasSpecial() { return hasSpecial; }
    public void setHasSpecial(boolean hasSpecial) { this.hasSpecial = hasSpecial; }
    public boolean hasUpper() { return hasUpper; }
    public void setHasUpper(boolean hasUpper) { this.hasUpper = hasUpper; }
    public boolean hasLower() { return hasLower; }
    public void setHasLower(boolean hasLower) { this.hasLower = hasLower; }

    /** Inicializa la contraseña con la longitud especificada */
    public void setUserPassword(int length) { userPassword = new char[length]; }

    /** Devuelve la contraseña generada */
    public char[] getUserPassword() { return userPassword; }

    /** Devuelve un array de caracteres aleatorio según el tipo */
    public char[] getRandomCharacterType() {
        CharType charType = CharType.values()[RANDOM.nextInt(CharType.values().length)];
        return switch (charType) {
            case LOWER -> lowerCaseCharacters;
            case UPPER -> upperCaseCharacters;
            case SPECIAL -> specialCharacters;
            case NUMBER -> numbers;
        };
    }

    /**
     * Inserta un carácter aleatorio en un índice aleatorio evitando repeticiones consecutivas.
     * @param charArray array de caracteres del que seleccionar
     */
    public void setRandomIndexAndRandomCharacter(char[] charArray) {
        int randomIndex;
        char randomChar;
        do {
            randomIndex = getRandomIndex();
            randomChar = getRandomCharacter(charArray);
        } while ((randomIndex > 0 && userPassword[randomIndex - 1] == randomChar)
                || (randomIndex < userPassword.length - 1 && userPassword[randomIndex + 1] == randomChar));
        userPassword[randomIndex] = randomChar;
    }

    /** Devuelve un índice aleatorio de la contraseña */
    public int getRandomIndex() { return RANDOM.nextInt(userPassword.length); }

    /** Coloca un carácter aleatorio en el índice especificado */
    public void setRandomCharacter(int index, char[] array) { userPassword[index] = getRandomCharacter(array); }

    /** Devuelve un carácter aleatorio de un array */
    public char getRandomCharacter(char[] array) { return array[RANDOM.nextInt(array.length)]; }

    /** Comprueba si un carácter es igual al anterior */
    public boolean areConsecutive(int position) {
        return position > 0 && userPassword[position] == userPassword[position - 1];
    }

    /** Rellena la contraseña con los tipos de caracteres que falten */
    public void fillMissingCharacterTypes() {
        while(!hasUpper || !hasLower || !hasSpecial || !hasNumber) {
            if(!hasUpper) applyMissingCharacter(upperCaseCharacters, CharType.UPPER);
            if(!hasLower) applyMissingCharacter(lowerCaseCharacters, CharType.LOWER);
            if(!hasSpecial) applyMissingCharacter(specialCharacters, CharType.SPECIAL);
            if(!hasNumber) applyMissingCharacter(numbers, CharType.NUMBER);
        }
    }

    /**
     * Aplica un carácter aleatorio de un tipo que falta en la contraseña
     * @param charArray array de caracteres del tipo a aplicar
     * @param charType tipo de carácter
     */
    private void applyMissingCharacter(char[] charArray, CharType charType) {
        setRandomIndexAndRandomCharacter(charArray);
        switch(charType) {
            case UPPER -> setHasUpper(true);
            case LOWER -> setHasLower(true);
            case SPECIAL -> setHasSpecial(true);
            case NUMBER -> setHasNumber(true);
        }
    }

    /** Genera la contraseña completa evitando repeticiones consecutivas y asegurando todos los tipos */
    public void createUserPassword() {
        for (int i = 0; i < userPassword.length; i++) {
            do { setRandomCharacter(i, getRandomCharacterType()); }
            while (areConsecutive(i));
        }
        fillMissingCharacterTypes();
    }
}

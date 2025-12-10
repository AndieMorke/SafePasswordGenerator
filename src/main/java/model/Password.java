package model;

import java.security.SecureRandom;

/**
 * Clase para generar contraseñas aleatorias con letras, números y símbolos.
 */
public class Password {

    /**
     * Letras minúsculas disponibles
     */
    private char[] lowerCaseCharacters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * Números disponibles
     */
    private char[] numbers = "0123456789".toCharArray();

    /**
     * Caracteres especiales disponibles
     */
    private char[] specialCharacters = "!@#$%*()_+-=[]{}.,?".toCharArray();

    /**
     * Letras mayúsculas generadas a partir de las minúsculas
     */
    private char[] upperCaseCharacters;

    /**
     * Contraseña generada
     */
    private char[] generatedPassword;

    /**
     * Generador de números aleatorios
     */
    private final SecureRandom RANDOM;

    /**
     * Constructor que inicializa caracteres en mayúscula y generador aleatorio.
     */
    public Password() {
        upperCaseCharacters = new char[lowerCaseCharacters.length];
        for (int i = 0; i < lowerCaseCharacters.length; i++) {
            upperCaseCharacters[i] = Character.toUpperCase(lowerCaseCharacters[i]);
        }
        RANDOM = new SecureRandom();
    }

    /**
     * Inicializa la contraseña con la longitud especificada
     */
    public void setGeneratedPassword(int length) {
        generatedPassword = new char[length];
    }

    /**
     * Devuelve la contraseña generada
     */
    public char[] getGeneratedPassword() {
        return generatedPassword;
    }

    /**
     * Devuelve un array de caracteres aleatorio según el tipo
     */
    public char[] getRandomCharacterType() {
        return switch (RANDOM.nextInt(3)){
            case 0 -> upperCaseCharacters;
            case 1 -> numbers;
            case 2 -> lowerCaseCharacters;
            default -> lowerCaseCharacters;
        };
    }

    /**
     * Devuelve un índice aleatorio de la contraseña
     */
    public int getRandomIndex() {
        return RANDOM.nextInt(generatedPassword.length);
    }

    /**
     * Coloca un carácter aleatorio en el índice especificado
     */
    public void setRandomCharacter(int index, char[] array) {
        generatedPassword[index] = getRandomCharacter(array);
    }

    /**
     * Devuelve un carácter aleatorio de un array
     */
    public char getRandomCharacter(char[] array) {
        return array[RANDOM.nextInt(array.length)];
    }


    public void setRandomChar(char[] arrayType) {
        int position;
        do {
            position = getRandomIndex();
        } while (generatedPassword[position] != '\0');
        setRandomCharacter(position, arrayType);
    }

    public void generatePassword(int length) {
        setGeneratedPassword(length);
        setRandomChar(lowerCaseCharacters);
        setRandomChar(upperCaseCharacters);
        setRandomChar(specialCharacters);
        setRandomChar(numbers);

        for (int i = 0; i < generatedPassword.length; i++) {
            if (generatedPassword[i] == '\0') {
                char randomCharacter;
                do {
                    char[] characterGroup = getRandomCharacterType();
                    randomCharacter = getRandomCharacter(characterGroup);
                } while (i > 0 && generatedPassword[i - 1] == randomCharacter);
                generatedPassword[i] = randomCharacter;
            }

        }

    }
}
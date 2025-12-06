package model;

import java.util.Random;

public class Password {


    // =======================
    // Atributos
    // =======================

    /** Letras minúsculas permitidas en la contraseña. */
    private char[] characters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /** Números permitidos en la contraseña. */
    private char[] numbers = "0123456789".toCharArray();

    /** Caracteres especiales permitidos en la contraseña. */
    private char[] specialCharacters = "!@#$%*()_+-=[]{}.,?".toCharArray();

    /** Letras mayúsculas generadas a partir de 'characters'. */
    private char[] upperCaseCharacters;

    /** Array que contendrá la contraseña generada para el usuario. */
    private char[] userPassword;

    /** Objeto Random utilizado para generar números y caracteres aleatorios. */
    private final Random RANDOM;


    // =======================
    // Constructor
    // =======================

    /**
     * Constructor de la clase Password.
     *
     * Inicializa el array de letras mayúsculas a partir del array de letras minúsculas.
     * También inicializa el objeto RANDOM para la generación aleatoria de caracteres.
     */
    public Password() {
        // Crear array de mayúsculas a partir de 'characters'
        upperCaseCharacters = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            upperCaseCharacters[i] = Character.toUpperCase(characters[i]);
        }

        // Inicializar Random
        RANDOM = new Random();
    }


    // =======================
    // Getters
    // =======================

    /**
     * Devuelve el array de letras minúsculas disponibles.
     * @return array de caracteres minúsculos
     */
    public char[] getCharacters() {
        return this.characters;
    }

    /**
     * Devuelve el array de números disponibles.
     * @return array de caracteres numéricos
     */
    public char[] getNumbers() {
        return this.numbers;
    }

    /**
     * Devuelve el array de caracteres especiales disponibles.
     * @return array de caracteres especiales
     */
    public char[] getSpecialCharacters() {
        return this.specialCharacters;
    }

    /**
     * Devuelve el array de letras mayúsculas disponibles.
     * @return array de caracteres en mayúscula
     */
    public char[] getUpperCaseCharacters() {
        return this.upperCaseCharacters;
    }

    /**
     * Devuelve el array que contiene la contraseña generada.
     * @return array de caracteres de la contraseña
     */
    public char[] getUserPassword() {
        return this.userPassword;
    }

    // =======================
    // Setter
    // =======================

    /**
     * Inicializa el array de la contraseña del usuario con la longitud indicada.
     * Esto prepara el array para generar la contraseña.
     *
     * @param length longitud deseada de la contraseña
     */
    public void setUserPassword(int length) {
        this.userPassword = new char[length];
    }



    // =======================
    // Generación de la contraseña
    // =======================

    /**
     * Genera la contraseña del usuario con la longitud previamente definida en userPassword.
     *
     * La contraseña se construye de la siguiente manera:
     * 1. Recorre cada posición del array userPassword.
     * 2. Selecciona aleatoriamente un tipo de carácter: minúscula, mayúscula, número o especial.
     * 3. Evita que se repitan caracteres consecutivos.
     * 4. Marca qué tipos de caracteres se han añadido mediante booleanos.
     * 5. Una vez completado el array, llama a fillMissingCharacterTypes() para asegurarse
     *    de que al menos haya un carácter de cada tipo en la contraseña.
     *
     * Notas:
     * - No devuelve nada; la contraseña queda almacenada en el array userPassword.
     * - Depende de los métodos auxiliares genRandomChar, getRandomIndex, areConsecutive y fillMissingCharacterTypes.
     */
    public void createUserPassword() {

        boolean hasNumber = false;
        boolean hasSpecial = false;
        boolean hasUpper = false;
        boolean hasLower = false;

        // Añadir caracteres aleatorios evitando repeticiones consecutivas
        for (int i = 0; i < this.getUserPassword().length; i++) {
            do {
                switch (RANDOM.nextInt(4)) {
                    case 0:
                        this.userPassword[i] = this.genRandomChar(this.getCharacters());
                        hasLower = true;
                        break;
                    case 1:
                        this.userPassword[i] = this.genRandomChar(this.getUpperCaseCharacters());
                        hasUpper = true;
                        break;
                    case 2:
                        this.userPassword[i] = this.genRandomChar(this.getSpecialCharacters());
                        hasSpecial = true;
                        break;
                    case 3:
                        this.userPassword[i] = this.genRandomChar(this.getNumbers());
                        hasNumber = true;
                        break;
                }
            } while (this.areConsecutive(i));
        }

        // Completar tipos de caracteres que falten
        this.fillMissingCharacterTypes(hasNumber, hasUpper, hasLower, hasSpecial);
    }


    // =======================
    // Métodos de generación aleatoria
    // =======================

    /**
     * Devuelve un carácter aleatorio tomado de un array de caracteres.
     *
     * @param array array de caracteres del que se elegirá uno aleatorio
     * @return carácter seleccionado aleatoriamente
     */
    public char genRandomChar(char[] array){
        return array[RANDOM.nextInt(array.length)];
    }

    /**
     * Devuelve un índice aleatorio válido dentro del array de la contraseña del usuario.
     * Útil para reemplazar posiciones aleatorias dentro de la contraseña.
     *
     * @return índice aleatorio dentro del array userPassword
     */
    public int getRandomIndex(){
        return RANDOM.nextInt(this.getUserPassword().length);
    }

    // =======================
    // Métodos de validación
    // =======================

    /**
     * Comprueba si el carácter en la posición indicada es igual al anterior.
     * Esto evita que se repitan caracteres consecutivos en la contraseña.
     *
     * @param position índice a comprobar en el array userPassword
     * @return true si el carácter es igual al anterior; false en caso contrario
     */
    public boolean areConsecutive(int position){
        return ((position > 0) && this.getUserPassword()[position] == this.getUserPassword()[position - 1]);
    }

    /**
     * Rellena la contraseña con los tipos de caracteres que falten.
     *
     * Los parámetros indican qué tipos de caracteres ya están presentes en la contraseña.
     * Se pasan desde createUserPassword, pero dentro del método solo se usan localmente
     * para controlar qué falta por añadir. Los cambios no afectan a los booleanos originales.
     *
     * @param number true si ya hay un número en la contraseña
     * @param upper true si ya hay una letra mayúscula en la contraseña
     * @param lower true si ya hay una letra minúscula en la contraseña
     * @param special true si ya hay un carácter especial en la contraseña
     */
    public void fillMissingCharacterTypes(boolean number, boolean upper, boolean lower, boolean special){
        while(!upper || !lower || !special || !number){
            if(!upper){
                this.userPassword[this.getRandomIndex()] = this.genRandomChar(this.getUpperCaseCharacters());
                upper = true;
            }
            if(!special){
                this.userPassword[this.getRandomIndex()] = this.genRandomChar(this.getSpecialCharacters());
                special = true;
            }
            if(!number){
                this.userPassword[this.getRandomIndex()] = this.genRandomChar(this.getNumbers());
                number = true;
            }
            if(!lower){
                this.userPassword[this.getRandomIndex()] = this.genRandomChar(this.getCharacters());
                lower = true;
            }
        }
    }



    }



}







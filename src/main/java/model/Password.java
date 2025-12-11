/**
 * La clase {@code Password} permite generar contraseñas aleatorias seguras
 * utilizando letras minúsculas, mayúsculas, números y caracteres especiales.
 * <p>
 * Utiliza {@link java.security.SecureRandom} para asegurar la aleatoriedad de los caracteres.
 * </p>
 * <p>
 * Ejemplo de uso:
 * <pre>
 * {@code
 * Password passwordGenerator = new Password();
 * passwordGenerator.generatePassword(12);
 * char[] password = passwordGenerator.getGeneratedPassword();
 * }
 * </pre>
 * </p>
 */
package model;

import java.security.SecureRandom;

public class Password {

    /** Letras minúsculas disponibles para la generación de la contraseña. */
    private final char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /** Números disponibles para la generación de la contraseña. */
    private final char[] NUMBER = "0123456789".toCharArray();

    /** Caracteres especiales disponibles para la generación de la contraseña. */
    private final char[] SPECIAL = "!@#$%*()_+-=[]{}.,?".toCharArray();

    /** Letras mayúsculas generadas a partir de las minúsculas. */
    private final char[] UPPERCASE;

    /** Contraseña generada, almacenada como array de caracteres. */
    private char[] generatedPassword;

    /** Generador seguro de números aleatorios. */
    private final SecureRandom RANDOM;

    /**
     * Constructor de {@code Password}.
     * <p>
     * Inicializa el array de letras mayúsculas a partir de las minúsculas
     * y crea una instancia de {@link SecureRandom}.
     * </p>
     */
    public Password() {
        UPPERCASE = new char[LOWERCASE.length];
        for (int i = 0; i < LOWERCASE.length; i++) {
            UPPERCASE[i] = Character.toUpperCase(LOWERCASE[i]);
        }
        RANDOM = new SecureRandom();
    }

    /**
     * Inicializa el array de la contraseña con la longitud especificada.
     *
     * @param length la longitud deseada de la contraseña
     */
    public void setGeneratedPassword(int length) {
        generatedPassword = new char[length];
    }

    /**
     * Obtiene la contraseña generada.
     *
     * @return un array de caracteres representando la contraseña generada
     */
    public char[] getGeneratedPassword() {
        return generatedPassword;
    }

    /**
     * Obtiene un array de caracteres aleatorio de un tipo específico.
     * <p>
     * La selección se hace entre mayúsculas, minúsculas y números.
     * </p>
     *
     * @return un array de caracteres aleatorio según el tipo seleccionado
     */
    public char[] getRandomCharacterType() {
        return switch (RANDOM.nextInt(3)) {
            case 0 -> UPPERCASE;
            case 1 -> NUMBER;
            case 2 -> LOWERCASE;
            default -> SPECIAL;
        };
    }

    /**
     * Obtiene un índice aleatorio dentro de la contraseña generada.
     *
     * @return un índice válido dentro del array de la contraseña
     */
    public int getRandomIndex() {
        return RANDOM.nextInt(generatedPassword.length);
    }

    /**
     * Coloca un carácter aleatorio de un array en la posición indicada.
     *
     * @param index  posición donde se colocará el carácter
     * @param array  array de caracteres del cual se seleccionará uno al azar
     */
    public void setRandomCharacterAtIndex(int index, char[] array) {
        generatedPassword[index] = getRandomCharacter(array);
    }

    /**
     * Obtiene un carácter aleatorio de un array de caracteres dado.
     *
     * @param array array de caracteres del cual se seleccionará uno
     * @return un carácter seleccionado al azar del array
     */
    public char getRandomCharacter(char[] array) {
        return array[RANDOM.nextInt(array.length)];
    }

    /**
     * Coloca un carácter aleatorio de un tipo específico en una posición vacía
     * de la contraseña.
     *
     * @param arrayType tipo de caracteres del cual se seleccionará uno
     */
    public void setRandomCharacter(char[] arrayType) {
        int position;
        do {
            position = getRandomIndex();
        } while (generatedPassword[position] != '\0');
        setRandomCharacterAtIndex(position, arrayType);
    }

    /**
     * Genera una contraseña aleatoria de la longitud especificada.
     * <p>
     * Se asegura de incluir al menos un carácter de cada tipo: minúscula,
     * mayúscula, número y especial. Luego rellena las posiciones restantes
     * con caracteres aleatorios evitando sobrescribir los ya colocados.
     * </p>
     *
     * @param length longitud deseada de la contraseña
     */
    public void generatePassword(int length) {
        setGeneratedPassword(length);

        // Asegura que haya al menos un carácter de cada tipo
        setRandomCharacter(LOWERCASE);
        setRandomCharacter(UPPERCASE);
        setRandomCharacter(SPECIAL);
        setRandomCharacter(NUMBER);

        // Rellena el resto de posiciones vacías
        for (int i = 0; i < generatedPassword.length; i++) {
            if (generatedPassword[i] == '\0') {
                setRandomCharacterAtIndex(i, getRandomCharacterType());
            }
        }
    }
}

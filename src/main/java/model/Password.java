package model;

import java.util.Random;

public class Password {

   Random random = new Random();

   // Atributos
   private String[] characters;
   private String[] specialCharacters;
   private String[] upperCaseCharacters;
   private String[] userPassword;


   // SETTER Y GETTER para los caracteres
   public void setCharacters() {
       this.characters = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
   }
   public String[] getCharacters() {
       return this.characters;
   }


    // SETTER Y GETTER para los caracteres especiales
   public void setSpecialCharacters() {
       this.specialCharacters = new String[] {"|","@","#","·","$","%","&","+","-","/",".",",",";",":"};
   }
   public String[] getSpecialCharacters() {
       return this.specialCharacters;
   }


    // SETTER Y GETTER para los caracteres en mayúsculas
   public void setUpperCaseCharacters() {
       this.upperCaseCharacters = new String[getCharacters().length];
       for (int i = 0; i < characters.length; i++) {
           this.upperCaseCharacters[i] = this.getCharacters()[i].toUpperCase();
       }
   }
   public String[] getUpperCaseCharacters() {
       return this.upperCaseCharacters;
   }


    // SETTER Y GETTER para la contraseña a generar
   public void setUserPassword(int length) {
       this.userPassword = new String[length];
   }
   public String[] getUserPassword() {
       return this.userPassword;
   }


   // Rellenar contraseña
   public void fillUserPassword() {
       // Establecer los caracteres
       this.setCharacters();
       this.setSpecialCharacters();
       this.setUpperCaseCharacters();

        // Colocar los caracteres de forma aleatoria confirmando que no se repitan de forma consecutiva
       for (int i = 0; i < this.getUserPassword().length; i++) {
           switch (random.nextInt(4)){
               case 0:
                   this.userPassword[i] = this.getCharacters()[this.random.nextInt(this.getCharacters().length)];
                   if (i > 0){
                       while(this.userPassword[i].equals(this.userPassword[i-1])){
                           this.userPassword[i] = this.getCharacters()[this.random.nextInt(this.getCharacters().length)];
                       }
                   }
                   break;
               case 1:
                   this.userPassword[i] = this.getSpecialCharacters()[this.random.nextInt(this.getSpecialCharacters().length)];
                   if (i > 0){
                       while(this.userPassword[i].equals(this.userPassword[i-1])){
                           this.userPassword[i] = this.getSpecialCharacters()[this.random.nextInt(this.getSpecialCharacters().length)];
                       }
                   }
                   break;
               case 2:
                   this.userPassword[i] = this.getUpperCaseCharacters()[this.random.nextInt(this.getUpperCaseCharacters().length)];
                   if (i > 0){
                       while(this.userPassword[i].equals(this.userPassword[i-1])){
                           this.userPassword[i] = this.getUpperCaseCharacters()[this.random.nextInt(this.getUpperCaseCharacters().length)];
                       }
                   }
                   break;
               case 3:
                   this.userPassword[i] = Integer.toString(random.nextInt(10));
                   if (i > 0){
                       while(this.userPassword[i].equals(this.userPassword[i-1])){
                           this.userPassword[i] = Integer.toString(random.nextInt(10));
                       }
                   }
                   break;
           }
       }

   }


   // Comprobar si la contraseña es segura (Debe contener al menos una mayúscula, un carácter especial y un número)
   public boolean safePassword(){
       boolean upper,special,number, safe;
       upper = false;
       special = false;
       number = false
       safe = false;


           for (int i = 0; i < this.getUserPassword().length; i++) {
               if (this.getUserPassword()[i].equals(this.getSpecialCharacters()[i])) {
                   special = true;
               }
               else if (this.getUserPassword()[i].equals(this.getUpperCaseCharacters()[i])) {
                   upper = true;
               }
               else if (this.getUserPassword()[i].equals(Integer.toString(random.nextInt(10)))) {
                   number = true;
               }
           }
           return safe = true;
       }

   }









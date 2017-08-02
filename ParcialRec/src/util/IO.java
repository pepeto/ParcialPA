package util;

import java.io.File;
import java.util.Scanner;

public class IO {

    public static String getString() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static String getString(String message) {
        IO.print(message);

        return IO.getString();
    }

    public static char getChar() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextLine()) {
            IO.print("Debe ingresar una letra");

            scanner.next();
        }

        String value = scanner.nextLine();

        while (value.length() != 1) {
            IO.print("Debe ingresar una letra");

            value = scanner.next();
        }

        return value.toCharArray()[0];
    }

    public static char getChar(String message) {
        IO.print(message);

        return IO.getChar();
    }

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            IO.print("Debe ingresar un entero");

            scanner.next();
        }

        return scanner.nextInt();
    }

    public static int getInt(String message) {
        IO.print(message);

        return IO.getInt();
    }

    public static double getDouble() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextDouble()) {
            IO.print("Debe ingresar un doble");

            scanner.next();
        }

        return scanner.nextDouble();
    }

    public static double getDouble(String message) {
        IO.print(message);

        return IO.getDouble();
    }

    public static void print(String value) {
        System.out.println(value);
    }
    
    /*
    public static void printList(File[] f){
    	for(File item : f) 
    		System.out.println(item.getName());
    }
    */
    
    // Corta el path en la ultima barra / eliminando posibles nombres de archovo al final.
   	public static String pathOnly(String path){
   		return path.substring(0, path.lastIndexOf("/")+1);
   		}
    
    public static void printList(Object[] o){
    	for(Object item : o) 
    		System.out.println(item.toString());
    }
}

package application;

import enums.Color;

public class Program {
    public static void main(String[] args) {

        Color myColor = Color.BLUE;
        System.out.println("My color: " + myColor);

        int i = 0;
        for (Color c : Color.values()) {
            i++;
            System.out.printf("Color (%d): %s%n", i, c);
        }
    }
}

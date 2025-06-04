package org.example;

public class Visual {

    public static void getVisual(int playerX, int playerY, int lab[][]) {

        String RESET = "\u001B[0m";
        String RE = "\u25A0";
        String GREEN = "\u001B[38;2;0;255;0m";
        String WHITE = "\u001B[38;2;255;255;255m";
        String RED = "\u001B[38;2;255;0;0m";

        for (int i = 0; i < lab.length ; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if ((i == playerY) && (j == playerX)) {
                    System.out.print(GREEN + RE + RESET);
                } else if (lab[i][j] == 2) {
                    System.out.print(RED + RE + RESET);
                } else {
                    System.out.print(WHITE + RE + RESET);
                }
            }
            System.out.println();
        }
    }
}

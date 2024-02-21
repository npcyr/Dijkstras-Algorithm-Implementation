// Name: Noah Cyr
// Assignment: HW5-Closed Hashing & Dijkstra's Algorithm
// File: DAMain.java

import javax.swing.*;
import java.util.Scanner;

public class DAMain {
    public static void main(String[] args) {

        int[][] graph = {{0, 54, 11, 13, 0, 0, 0, 0, 0, 0},
                {54, 0, 37, 0, 3, 0, 102, 0, 0, 0},
                {11, 37, 0, 10, 36, 19, 0, 0, 0, 0},
                {13, 0, 10, 0, 0, 18, 0, 0, 7, 0},
                {0, 3, 36, 0, 0, 15, 124, 123, 0, 0},
                {0, 0, 19, 18, 15, 0, 0, 138, 8, 0},
                {0, 102, 0, 0, 124, 0, 0, 9, 0, 72},
                {0, 0, 0, 0, 123, 138, 9, 0, 146, 67},
                {0, 0, 0, 7, 0, 8, 0, 146, 0, 213},
                {0, 0, 0, 0, 0, 0, 72, 67, 213, 0}
        };

        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome!\nWith this program we are going to perform Dijkstra's Algorithm on an associated graph!\nType '0' to continue on to the input and computation and type '1' to display an image of the graph before you continue:");
        int x = Integer.parseInt(input.nextLine());
        if (x == 1) {
            var frame = new JFrame();
            var icon = new ImageIcon("GraphForDijkstras.png");
            var label = new JLabel(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            System.out.println("Note: Do not close the image tab until the algorithm is done running.");
        }
        else if (x != 0) {
            System.out.println("Please enter a valid input. Rerun the program to try again.");
            System.exit(0);
        }
        else {
            System.out.print("");
        }
        System.out.println("\nEnter your starting node (as a letter) below:");
        String startNS = input.nextLine();
        int startNI = DijkstrasAlgo.letterToIndex(startNS);
        if (startNI == -1) {
            System.out.println("Please enter a valid node. Rerun the program to try again.");
            System.exit(0);
        }
        System.out.println("\nEnter your ending node (as a letter) below:");
        String endNS = input.nextLine();
        int endNI = DijkstrasAlgo.letterToIndex(endNS);
        if (endNI == -1) {
            System.out.println("Please enter a valid node. Rerun the program to try again.");
            System.exit(0);
        }
        DijkstrasAlgo.dijkstrasAlgo(graph, startNI, endNI);

        input.close();
        System.exit(0);
    }
}

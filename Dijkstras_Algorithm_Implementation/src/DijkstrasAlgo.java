// Name: Noah Cyr
// Assignment: HW5-Closed Hashing & Dijkstra's Algorithm
// File: DijkstrasAlgo.java

import java.util.*;

public class DijkstrasAlgo {

    public static void dijkstrasAlgo (int[][] graph, int startN, int endN) {
        int N = graph.length;
        int[] distance = new int[N];
        Boolean[] inPath = new Boolean[N];
        int[] nodeOrder = new int[N];

        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
            inPath[i] = false;
        }

        distance[startN] = 0;
        nodeOrder[startN] = -1;


        for (int i = 0; i < N - 1; i++) {
            int n = minDistance(distance, inPath, N);
            inPath[n] = true;


            for (int j = 0; j < N; j++) {

                if (!inPath[j] && (graph[n][j] != 0) && (distance[n] != Integer.MAX_VALUE) && (distance[n] + graph[n][j] < distance[j])) {
                    distance[j] = distance[n] + graph[n][j];
                    nodeOrder[j] = n;
                }

            }
        }

        int SToE = distance[endN];
        System.out.println("\nThe shortest path from node " + indexToLetter(startN) + " to node " + indexToLetter(endN) + " is of length " + SToE + ".");

        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(endN);
        ArrayList<String> pathListLet;
        pathListLet = getPath(pathList, nodeOrder, nodeOrder[endN]);

        System.out.println("This shortest path follows the sequence " + pathListLet + ".");
    }

    public static int minDistance(int[] distance, Boolean[] inPath, int N) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int n = 0; n < N; n++) {
            if (!inPath[n] && distance[n] <= min) {
                min = distance[n];
                minIndex = n;
            }
        }
        return minIndex;
    }

    public static ArrayList<String> getPath(ArrayList<Integer> pathI, int[] nodeOrder, int endN) {
        ArrayList<String> pathS = new ArrayList<>();

        if (endN == -1) {
            for (Integer integer : pathI) {
                pathS.add(indexToLetter(integer));
            }
            return pathS;
        }
        else {
            pathI.add(0, endN);
        }
        return getPath(pathI, nodeOrder, nodeOrder[endN]);
    }


    public static int letterToIndex(String let) {
        int index = -1;
        let = let.toUpperCase();
        if (Objects.equals(let, "A")) index = 0;
        if (Objects.equals(let, "J")) index = 1;
        if (Objects.equals(let, "M")) index = 2;
        if (Objects.equals(let, "R")) index = 3;
        if (Objects.equals(let, "K")) index = 4;
        if (Objects.equals(let, "S")) index = 5;
        if (Objects.equals(let, "I")) index = 6;
        if (Objects.equals(let, "N")) index = 7;
        if (Objects.equals(let, "T")) index = 8;
        if (Objects.equals(let, "D")) index = 9;
        return index;
    }

    public static String indexToLetter(int ind) {
        String let = "false";
        if (ind == 0) let = "A";
        if (ind == 1) let = "J";
        if (ind == 2) let = "M";
        if (ind == 3) let = "R";
        if (ind == 4) let = "K";
        if (ind == 5) let = "S";
        if (ind == 6) let = "I";
        if (ind == 7) let = "N";
        if (ind == 8) let = "T";
        if (ind == 9) let = "D";
        return let;
    }
}

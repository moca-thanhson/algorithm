package com.alex.algorithm.Session11_FloydWarshall;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FloydWarshallUtil {

    public static final int NOT_AVAILABLE_DEST = -1;
    private static int INF = Integer.MAX_VALUE;

    private static int path[][];
    private static int dist[][];
    private static int graph[][];

    private static int numOfVertex;

    private static void printPath(int srcNode, int targetNode) {
        final List<Integer> tracePath = new ArrayList<>();
        while (targetNode != srcNode) {
            tracePath.add(targetNode);
            targetNode = path[srcNode][targetNode];
        }
        tracePath.add(srcNode);

        //print
        for (int i = tracePath.size() - 1; i >= 0; i--) {
            System.out.print(tracePath.get(i) + " ");
        }
        System.out.println();

    }

    public static void main(final String[] args) {

    }

    private static void init() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of vertext");
        numOfVertex = Integer.valueOf(scanner.nextInt());

        //init 2D
        graph = new int[numOfVertex][numOfVertex];
        path = new int[numOfVertex][numOfVertex];
        dist = new int[numOfVertex][numOfVertex];

        //init data to graph
        for (int i = 0; i < numOfVertex; i++) {
            for (int j = 0; j < numOfVertex; j++) {
                final int temp = scanner.nextInt();
                if (temp == 0 && i != j) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = temp;
                }
            }
        }

        //init data for dist and path
        for (int i = 0; i < numOfVertex; i++) {
            for (int j = 0; j < numOfVertex; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    path[i][j] = i;
                } else {
                    path[i][j] = NOT_AVAILABLE_DEST;
                }
            }

        }
    }

}

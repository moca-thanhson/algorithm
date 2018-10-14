package com.alex.algorithm.Session5_BFS.onClass;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach/problem
 */

import com.alex.algorithm.Session2_ComplexityAlgorithm.onClass.NumberUtil;

import java.io.*;
import java.util.*;

public class Bai_Bfs_ShortReach {

    private static final int DEF_DISTANCE = 6;
    private static final int NO_ADJENCY = -1;

    private static List<List<Integer>> graph = new ArrayList<>();
    final static Queue<Integer> lstOfVertex = new LinkedList<>();
    final static List<Integer> path = new ArrayList<>();
    final static List<Boolean> visited = new ArrayList<>();

    final static int numOfVertex = 0 ;


    // Complete the bfs function below.
    static int[] bfs(int numOfVertex, int initialVertex) {

        for (int i = 0; i < numOfVertex; i++) {
            visited.add(false);
            path.add(NO_ADJENCY);
        }

        //assign
        visited.set(initialVertex, true);
        lstOfVertex.add(initialVertex);

        //main part
        while (!lstOfVertex.isEmpty()) {
            int backToVertex = lstOfVertex.remove();
            //get all brothers node of backVertex
            for (int i = 0; i < graph.get(backToVertex).size(); i++) {
                final int connectToVertex = graph.get(backToVertex).get(i);
                if (!visited.get(connectToVertex)) {
                    visited.set(connectToVertex, true);
                    path.set(connectToVertex, backToVertex); //store back trace from connectToVertex -> backToVertex
                    //put connectToVertex to queue to traverse later
                    lstOfVertex.add(connectToVertex);
                }
            }

        }

        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 4 2
     * 1 2
     * 1 3
     * 1
     * 0
     */
    public static void main(String[] args) throws IOException {
        //Number of nodes && edges
        String line;
        int startNode;
        while (!(line = scanner.nextLine()).equals("0")) {
            if (NumberUtil.convertByString(line).size() == 2) {
                final List<Integer> pathOfTwoNode = NumberUtil.convertByString(line);
                graph.add(pathOfTwoNode);
            } else {
                startNode = NumberUtil.convertByString(line).get(0);
                System.out.println("Start node to find: " + startNode);
            }
        }

        System.out.println("Graph..");
        graph.forEach(
                g -> System.out.println(g)
        );


        //count jump from f -> s
        // count * 6
        // worse case :  1 -> 2 -> 3 -> 4 -> 5 ... Complexity : O(V(2));

        //improve : using distance[Integer] = List<Integer>

//        bfs(graph.size(), )

    }

}

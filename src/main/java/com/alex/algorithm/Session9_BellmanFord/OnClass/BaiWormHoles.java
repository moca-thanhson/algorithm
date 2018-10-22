package com.alex.algorithm.Session9_BellmanFord.OnClass;

import com.alex.algorithm.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=499
 */
public class BaiWormHoles {

    public static final int NOT_ANY_SRC = -1;
    static int numOfVertices, numOfEdges;
    static int[] dist;
    static List<Hole> graph = new ArrayList<>();
    static int[] targetDistricts;

    public static void main(final String[] args) {

        initData();

        int sourceNode = 0;
        boolean result = bellmanFord(sourceNode);
        if (result == false) {
            System.out.println("possible");
        } else {
            System.out.println("not possible");
        }

    }


    public static boolean bellmanFord(int currentNode) {
        // init distance to itself source node equal 0 instead of Integer.MAX as initial.
        dist[currentNode] = 0;

        //just run NumOfVertex - 1 times
        for (int i = 1; i <= numOfVertices - 1; i++) {
            for (int j = 0; j < numOfEdges; j++) {
                int srcNode = graph.get(j).source;
                int targetNode = graph.get(j).target;
                int weight = graph.get(j).weight;

                /**
                 * It must be not infinitive && cost to destination < current cost of destination
                 * So we update .
                 */
                if (dist[srcNode] != Integer.MAX_VALUE &&
                        (dist[srcNode] + weight < dist[targetNode])) {
                    dist[targetNode] = dist[srcNode] + weight;
                }
            }
        }

        //Check graph exist any negative graph.
        //If we can found at least one more update so it's negative graph.
        for (int i = 0; i < numOfEdges; i++) {
            int srcNode = graph.get(i).source;
            int targetNode = graph.get(i).target;
            int weight = graph.get(i).weight;
            if (dist[srcNode] != Integer.MAX_VALUE && (dist[srcNode] + weight < dist[targetNode])) {
                return false;
            }
        }

        return true;
    }


    private static void initData() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter number of vertices, number of edges:");
        final List<Integer> line = NumberUtil.convertByString(scanner.nextLine());
        numOfVertices = line.get(0);
        numOfEdges = line.get(1);

        //init graph
        System.out.println("Please enter src vertext, dest vertext , weight:");
        for (int i = 0; i < numOfEdges; i++) {
            List<Integer> dataLine = NumberUtil.convertByString(scanner.nextLine());
            int srcVertex = dataLine.get(0);
            int destVertext = dataLine.get(1);
            int weight = dataLine.get(2);
            graph.add(new Hole(srcVertex, destVertext, weight));
        }

        System.out.println("Please enter number of destination district");
        int numOfTargetNodes = scanner.nextInt();
        targetDistricts = new int[numOfTargetNodes];
        for (int i = 0; i < targetDistricts.length; i++) {
            System.out.print("Pls enter target district:");
            targetDistricts[i] = scanner.nextInt();
        }

        //Init for dist and path
        dist = new int[numOfVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //print
        System.out.println("Graph is");
        graph.forEach(
                item -> System.out.println(item.source + " " + item.target + " " + item.weight)
        );

        System.out.println("List target districts");
        for (int i = 0; i < targetDistricts.length; i++) {
            System.out.print(targetDistricts[i] + " ");
        }
    }

    static class Hole {
        public int source;
        public int target;
        public int weight;

        public Hole(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }
}

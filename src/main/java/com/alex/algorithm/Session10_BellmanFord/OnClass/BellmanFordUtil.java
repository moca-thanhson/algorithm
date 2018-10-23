package com.alex.algorithm.Session10_BellmanFord.OnClass;

import com.alex.algorithm.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * It helps to find the path from one vertext -> the rest vertices within weight can be negative or positive values.
 * <p>
 * Complexity O(E.V) <br/>
 * E : number of Edges
 * V : number of Vertices
 */
public class BellmanFordUtil {

    public static final int NOT_ANY_SRC = -1;
    static int numOfVertices, numOfEdges;
    static int[] dist, path;
    static List<Edge> graph = new ArrayList<>();

    public static void main(final String[] args) {
        initData();

        int sourceNode = 0, targetNode = 4;
        boolean result = bellmanFord(sourceNode);
        if (result == false) {
            System.out.println("Graph contains negative weight cycle");
        } else {
            System.out.println(String.format("\n================\nCost from %s --> %s is %s", sourceNode, targetNode,
                    dist[targetNode]));
        }

        //show path
        for (int i = 0; i < path.length; i++) {
            System.out.print(i + "-->" + path[i] + ",");
        }

        System.out.println(String.format("\nPath from %s --> %s is:", sourceNode, targetNode));
        int endNode = targetNode;
        while (endNode != sourceNode) {
            System.out.print(endNode + "-->");
            endNode = path[endNode];
        }
        System.out.println(endNode);

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
                    path[targetNode] = srcNode;
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
            graph.add(new Edge(srcVertex, destVertext, weight));
        }

        //Init for dist and path
        dist = new int[numOfVertices];
        path = new int[numOfEdges];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, NOT_ANY_SRC);

        //print
        System.out.println("Graph is");
        graph.forEach(
                item -> System.out.println(item.source + " " + item.target + " " + item.weight)
        );
        System.out.println("Initial path");
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
    }

    static class Edge {
        public int source;
        public int target;
        public int weight;

        public Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }
}

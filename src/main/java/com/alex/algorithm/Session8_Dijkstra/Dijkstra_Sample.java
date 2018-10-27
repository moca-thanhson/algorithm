package com.alex.algorithm.Session8_Dijkstra;

import com.alex.algorithm.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_Sample {

    private static final int UN_REACH_NODE = -1;
    private static int[] dist;
    private static int[] path;
    private static List<List<Node>> graph = new ArrayList<>();

    private static int numOfVertex;
    private static int numOfEdges;


    private static void dijkstra(int srcNode) {
        final PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Node(srcNode, 0));
        dist[srcNode] = 0; //update value Integer.MAX
        while (!priorityQueue.isEmpty()) {
            final Node topItem = priorityQueue.poll();

            final List<Node> neighbors = graph.get(topItem.id);
            for (int i = 0; i < neighbors.size(); i++) {
                final Node neighbor = neighbors.get(i);
                //update if found shorter path to neighbor node
                if (topItem.dist + neighbor.dist < dist[neighbor.id]) {
                    dist[neighbor.id] = topItem.dist + neighbor.dist;
                    priorityQueue.add(new Node(neighbor.id, dist[neighbor.id])); // put into queue
                    path[neighbor.id] = topItem.id; // update path
                }
            }
        }
    }

    public static void main(final String[] args) {
        int srcNode = 0, targetNode = 4;
        init();
        dijkstra(srcNode);

        //print shortest path
        System.out.println(String.format("Shortest path from %s --> %s is %s", srcNode, targetNode, dist[targetNode]));

        //print path
        System.out.println(String.format("Path from %s to %s is:", srcNode, targetNode));
        printPath(srcNode, targetNode);

    }

    private static void init() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter number of vertex:");
        numOfVertex = Integer.valueOf(scanner.nextLine());
        System.out.print("Please enter number of edges:");
        numOfEdges = Integer.valueOf(scanner.nextLine());

        dist = new int[numOfVertex];
        path = new int[numOfVertex];

        //init graph
        for (int i = 0; i < numOfVertex; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
            path[i] = UN_REACH_NODE;
        }

        //fill data into graph
        System.out.println("Pls enter matrix of edges:");
        for (int i = 0; i < numOfEdges; i++) {
            final List<Integer> eachLineOfMatrix = NumberUtil.convertByString(scanner.nextLine());
            int fromVertext = eachLineOfMatrix.get(0);
            int toVertext = eachLineOfMatrix.get(1);
            int distance = eachLineOfMatrix.get(2);

            //put to graph
            final Node node = new Node(toVertext, distance);
            graph.get(fromVertext).add(node);
        }

        //review data in graph
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(String.format("%s --> %s", i, graph.get(i)));
        }

    }

    private static void printPath(int startNode, int destNode) {
        if (startNode == destNode) {
            System.out.println(startNode);
            return;
        }

        System.out.println(String.format("Path from node %s to %s", startNode, destNode));
        if (path[destNode] == UN_REACH_NODE) {
            System.out.print("No path");
            return;
        }

        final List<Integer> fetchedPath = new ArrayList<>();
        while (true) {
            fetchedPath.add(destNode);
            destNode = path[destNode];
            if (startNode == destNode) {
                fetchedPath.add(destNode);
                break;
            }
        }

        //print required pat
        for (int i = fetchedPath.size() - 1; i > 0; i--) {
            System.out.print(fetchedPath.get(i) + "-->");
        }
        System.out.print(fetchedPath.get(0));

    }

    static class Node implements Comparable<Node> {

        public Integer id;
        public Integer dist;

        public Node(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return this.dist.compareTo(other.dist);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", dist=" + dist +
                    '}';
        }
    }
}

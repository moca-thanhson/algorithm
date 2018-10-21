package com.alex.algorithm.Session5_BFS.onClass;

import java.util.*;

public class BFSUtil {

    private static final int UNAVAILABLE_SRC_NODE = -1;

    private static int numOfVertex;
    private static int numOfEdges;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    private static List<Boolean> visisted = new ArrayList<>();


    public static void main(final String[] args) {

        initData();

        int startNode = 0, destNode = 5;
        bfs(startNode);
        printPath(startNode, destNode);

    }

    private static void bfs(int currNode) {
        final Queue<Integer> queue = new LinkedList<>();
        visisted.set(currNode, true);
        queue.add(currNode);
        while (!queue.isEmpty()) {
            int firstInsertedNode = queue.remove();
            final List<Integer> neighborNodes = graph.get(firstInsertedNode);
            for (int i = 0; i < neighborNodes.size(); i++) {
                int neighbor = neighborNodes.get(i);
                if (!visisted.get(neighbor)) {
                    visisted.set(neighbor, true);
                    path.set(neighbor, firstInsertedNode);
                    queue.add(neighbor);
                }
            }

        }
    }

    private static void printPath(int startNode, int destNode) {
        if (startNode == destNode) {
            System.out.print(startNode);
            return;
        }

        System.out.println(String.format("Path from node %s to %s", startNode, destNode));
        if (path.get(destNode) == UNAVAILABLE_SRC_NODE) {
            System.out.print("No path");
            return;
        }

        final List<Integer> fetchedPath = new ArrayList<>();
        while (true) {
            fetchedPath.add(destNode);
            destNode = path.get(destNode);
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

    private static void initData() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter number of vertex:");
        numOfVertex = scanner.nextInt();
        System.out.print("Please enter number of edges:");
        numOfEdges = scanner.nextInt();

        //init graph
        for (int i = 0; i < numOfVertex; i++) {
            graph.add(new ArrayList<>());
        }

        //fill graph data
        System.out.println("Please enter list of srcNode , targetNode");
        for (int i = 0; i < numOfEdges; i++) {
            int srcNode = scanner.nextInt();
            int targetNode = scanner.nextInt();
            //because un-bidirectional graph
            graph.get(srcNode).add(targetNode);
            graph.get(targetNode).add(srcNode);
        }

        //init visisted and path
        for (int i = 0; i < numOfVertex; i++) {
            visisted.add(false);
            path.add(UNAVAILABLE_SRC_NODE);
        }

        //print after init
        System.out.println("\n=========Graph after fill data========\n");
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(String.format("%s --> %s\n", i, graph.get(i)));
        }
    }

}

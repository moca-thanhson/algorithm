package com.alex.algorithm.Session6_DFS.onClass;

import com.alex.algorithm.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Input Data in test_data file
 * Output : 0-->3-->5
 */
public class DfsUtil {

    private static final int NOT_ANY_SRC = -1;

    private static List<List<Integer>> graph = new ArrayList<>();
    private static int numOfVertex;
    private static int numOfEdges;
    private static List<Integer> path = new ArrayList<>();
    private static List<Boolean> visisted = new ArrayList<>();


    private static void dfs(int src) {
        final Stack<Integer> stack = new Stack<>();
        visisted.set(src, true);
        stack.add(src);

        while (!stack.isEmpty()) {
            final int peekItem = stack.peek();
            stack.pop();
            final List<Integer> childNodes = graph.get(peekItem);
            for (int i = 0; i < childNodes.size(); i++) {
                final int childNode = childNodes.get(i);
                if (!visisted.get(childNode)) {
                    visisted.set(childNode, true);
                    stack.add(childNode);
                    path.set(childNode, peekItem);
                }
            }
        }
    }

    public static void main(final String[] args) {
        init();

        int srcNode = 0, targetNode = 5;
        dfs(srcNode);

        printPath(srcNode, targetNode);
    }

    private static void init() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of vertext:");
        numOfVertex = Integer.valueOf(scanner.nextLine());
        System.out.print("Please enter the number of edge:");
        numOfEdges = Integer.valueOf(scanner.nextLine());

        //init graph
        for (int i = 0; i < numOfVertex; i++) {
            graph.add(new ArrayList<>());
        }

        //fill edges
        System.out.println("Pls enter list of srcNode, targetNode:");
        for (int i = 0; i < numOfEdges; i++) {
            final List<Integer> line = NumberUtil.convertByString(scanner.nextLine());
            final int srcNode = line.get(0);
            final int targetNode = line.get(1);
            graph.get(srcNode).add(targetNode);
            graph.get(targetNode).add(srcNode);
        }

        //init visisted && path
        for (int i = 0; i < numOfVertex; i++) {
            visisted.add(false);
            path.add(NOT_ANY_SRC);
        }

        //review data after filling
        System.out.println("Graph is");
        for (int i = 0; i < numOfVertex; i++) {
            System.out.println(i + "-->" + graph.get(i));
        }
    }


    private static void printPath(int srcNode, int targetNode) {
        if (targetNode == srcNode) {
            System.out.print(srcNode);
            return;
        }

        if (path.get(targetNode) == NOT_ANY_SRC) {
            System.out.print("No Path");
            return;
        }

        final List<Integer> tracePath = new ArrayList<>();
        while (true) {
            tracePath.add(targetNode);
            targetNode = path.get(targetNode);
            if (srcNode == targetNode) {
                tracePath.add(targetNode);
                break;
            }
        }

        //output trace path nodes
        System.out.println(String.format("Path from %s --> %s is:", srcNode, targetNode));
        for (int i = tracePath.size() - 1; i > 0; i--) {
            System.out.print(tracePath.get(i) + "-->");
        }
        System.out.println(tracePath.get(0));

    }


}

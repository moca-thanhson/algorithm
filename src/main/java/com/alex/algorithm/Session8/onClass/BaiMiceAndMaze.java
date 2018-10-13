package com.alex.algorithm.Session8.onClass;

import com.alex.algorithm.NumberUtil;
import com.alex.algorithm.Session8.DijkstraUtil;
import com.alex.algorithm.Session8.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaiMiceAndMaze {

    private static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int numberOfGate = Integer.valueOf(scanner.nextLine());
        final int exitGate = Integer.valueOf(scanner.nextLine());
        final int timeToLeave = Integer.valueOf(scanner.nextLine());

        final int numberOfGraph = Integer.valueOf(scanner.nextLine());
        //read data list of adjencies nodes into graph
        for (int i = 0; i < numberOfGraph; i++) {
            graph.add(new ArrayList<>());

            final List<Integer> eachLine = NumberUtil.convertByString(scanner.nextLine());
            final int firstNodeId = eachLine.get(0);
            final int secondNodeId = eachLine.get(1);
            final int distance = eachLine.get(2);

            graph.get(firstNodeId).add(new Node(secondNodeId, distance));
            graph.get(secondNodeId).add(new Node(firstNodeId, distance));
        }

        //check each gate to exitGate
        final DijkstraUtil util = new DijkstraUtil(graph);
        int totalGateCanExit = 0;
        for (int gate = 1; gate <= numberOfGate; gate++) {
            util.dijkstra(gate);
            final int costToLeave = util.getDist()[exitGate];
            if (costToLeave <= timeToLeave) {
                System.out.println(String.format("Can leave from %s -> %s by cost %s", gate, exitGate, costToLeave));
                totalGateCanExit++;
            } else {
                System.out.println(String.format("Can NOT leave from %s -> %s by cost %s", gate, exitGate,
                        costToLeave));
            }
        }

        System.out.println("Total gate can be exit in time is " + totalGateCanExit);


    }
}

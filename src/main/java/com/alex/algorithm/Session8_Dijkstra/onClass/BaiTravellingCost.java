package com.alex.algorithm.Session8_Dijkstra.onClass;

import com.alex.algorithm.NumberUtil;
import com.alex.algorithm.Session8_Dijkstra.DijkstraUtil;
import com.alex.algorithm.Session8_Dijkstra.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaiTravellingCost {

    private static List<List<Node>> graph = new ArrayList<>();

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        long numOfRowAndColum = scanner.nextLong();
        for (int i = 0; i < numOfRowAndColum; i++) {
            graph.add(new ArrayList<>());

            final List<Integer> lstOfAdjency = NumberUtil.convertByString(scanner.nextLine());
            int firstNode = lstOfAdjency.get(0);
            int secondNode = lstOfAdjency.get(1);
            int dist = lstOfAdjency.get(2);

            //because 2 way so we need initial u -> v and v -> u with same distance.
            graph.get(firstNode).add(new Node(secondNode, dist));
            graph.get(secondNode).add(new Node(firstNode, dist));
        }

        int startNode = Integer.valueOf(scanner.nextLine());
        int numOfNodeNeedToGo = Integer.valueOf(scanner.nextLine());

        DijkstraUtil util = new DijkstraUtil(graph);
        util.dijkstra(startNode);

        //write the output
        for (int i = 0; i < numOfNodeNeedToGo; i++) {
            int nodeNeedToGo = Integer.valueOf(scanner.nextLine());
            int costToNode = util.getDist()[nodeNeedToGo];
            if (costToNode < Integer.MAX_VALUE) {
                System.out.println(costToNode);
            } else {
                System.out.println("NO PATH");
            }
        }
    }
}

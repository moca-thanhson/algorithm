package com.alex.algorithm.Session8_Dijkstra;

import com.alex.algorithm.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DijkstraMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfNode = Integer.valueOf(scanner.nextLine());
        int startNode = 0, destNode = 2;

        final List<List<Node>> graph = new ArrayList<>();
        //init graph
        for (int i = 0; i < numOfNode; i++) {
            graph.add(new ArrayList<>());

            final List<Integer> lineNumOfMatrix = NumberUtil.convertByString(scanner.nextLine());
            //add data
            for (int j = 0; j < numOfNode; j++) {
                graph.get(i).add(new Node(j, lineNumOfMatrix.get(j)));
            }
        }
        //end of init graph

        DijkstraUtil util = new DijkstraUtil(graph);
        util.dijkstra(startNode);

        System.out.println("Cost from " + startNode + "->" + destNode + " is : " + util.getDist()[destNode]);

    }
}

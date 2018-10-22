package com.alex.algorithm.Session9_BellmanFord.OnClass;

import com.alex.algorithm.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaiExtendedTraffice {

    private static final int EXPONENT_CAL_DISTRICT_WEIGHT = 3;
    private static final int MIN_COST = 3;

    static int numOfVertices, numOfEdges;
    static int[] dist;
    static int[] targetDistricts;
    static List<DistrictCost> graph = new ArrayList<>();

    public static void main(String[] args) {
        initData();

        int sourceNode = 1;
        boolean result = bellmanFord(sourceNode);
        if (result == false) {
            System.out.println("This exist a negative inner graph");
        } else {
            for (int i = 0; i < targetDistricts.length; i++) {
                int targetDistrict = targetDistricts[i];
                String cost = dist[targetDistrict] > MIN_COST ? String.valueOf(dist[targetDistrict]) : "?";
                System.out.println(String.format("Cost from district 1 --> %s is %s", targetDistrict, cost));
            }
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
        System.out.print("Please enter number of districts:");
        numOfVertices = scanner.nextInt();

        System.out.print("Please enter busies of districts:");
        final List<Integer> costAllDistricts = NumberUtil.convertByString(scanner.nextLine());

        System.out.print("Please enter number of district path:");
        numOfEdges = scanner.nextInt();

        //init graph
        System.out.println("Please enter src district, dest district, weight:");
        for (int i = 0; i < numOfVertices; i++) {
            List<Integer> dataLine = NumberUtil.convertByString(scanner.nextLine());
            int srcVertex = dataLine.get(0);
            int destVertext = dataLine.get(1);

            final int costOfSrcDistrict = costAllDistricts.get(srcVertex);
            final int costOfDestDistrict = costAllDistricts.get(destVertext);
            int weight = Integer.valueOf(Double.toString(Math.pow((costOfDestDistrict - costOfSrcDistrict),
                    EXPONENT_CAL_DISTRICT_WEIGHT)));
            graph.add(new DistrictCost(srcVertex, destVertext, weight));
        }

        System.out.println("Please enter number of target districts which need to come");
        int numOfTargetDistricts = scanner.nextInt();
        targetDistricts = new int[numOfTargetDistricts];
        for (int i = 0; i < numOfTargetDistricts; i++) {
            System.out.println("Please enter target district");
            targetDistricts[i] = scanner.nextInt();
        }

        //Init for dist
        dist = new int[numOfVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //print
        System.out.println("Graph is");
        graph.forEach(
                item -> System.out.println(item.source + " " + item.target + " " + item.weight)
        );
    }

    static class DistrictCost {
        public int source;
        public int target;
        public int weight;

        public DistrictCost(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }
}

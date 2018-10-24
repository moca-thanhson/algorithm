package com.alex.algorithm.Session8_Dijkstra.btvn;

import com.alex.algorithm.NumberUtil;

import java.util.*;

public class BaiSendingEmail {




    public static void main(final String[] args)  {
        final Scanner scanner = new Scanner(System.in);
        int totalTestCases = Integer.valueOf(scanner.nextLine());
        for(int i = 0 ;i<totalTestCases; i++) {
            final List<Integer> lineInput = NumberUtil.convertByString(scanner.nextLine());

            int numOfVertex = lineInput.get(0);
            int numOfEdges = lineInput.get(1);
            int srcNode = lineInput.get(2);
            int targetNode = lineInput.get(3);

            //init
            int[]  dist = new int[numOfVertex];
            final List<List<Pair>> graph = new ArrayList<>();
            for(int j = 0 ;j<numOfVertex; j++) {
                graph.add(new ArrayList<>());
                dist[j] = Integer.MAX_VALUE;
            }




        }
    }

    private static void dijkstra(int srcNode, List<List<Pair>> graph, int[] dist) {
        final PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.firstNode - o2.firstNode;
            }
        });

        //reset Integer.Max value
        dist[srcNode] = 0;
        queue.add(new Pair(0, srcNode));
        while(!queue.isEmpty()) {
            Pair peekItem = queue.peek();
            int secondNode = peekItem.secondNode;
            queue.remove();

            final List<Pair> neighbors = graph.get(secondNode);
            for(Pair neighbor : neighbors) {
                int secondServer = neighbor.secondNode;
                int firstServer = neighbor.firstNode;
                if(dist[secondServer] > dist[secondNode] + )
            }
        }


    }

    static class Pair {
        public int firstNode, secondNode;

        public Pair(int firstNode, int secondNode) {
            this.firstNode = firstNode;
            this.secondNode = secondNode;
        }
    }

}

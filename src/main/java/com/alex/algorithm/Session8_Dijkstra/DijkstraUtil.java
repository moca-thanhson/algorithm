package com.alex.algorithm.Session8_Dijkstra;

import java.util.List;
import java.util.PriorityQueue;

public class DijkstraUtil {

    private int[] dist; //store cost from node -> other node
    private int[] path;  //store path for back tracking
    private static List<List<Node>> graph; // store matrix path (nodeId , cost)

    public DijkstraUtil(List<List<Node>> graph) {
        this.graph = graph;

        int n = graph.size();
        this.dist = new int[n];
        this.path = new int[n];
        //initial data
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }
    }

    public void dijkstra(int nodeId) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        //init queue
        priorityQueue.add(new Node(nodeId, 0)); // add first Node(nodeId,0);
        dist[nodeId] = 0;

        //loop priority queue
        while (!priorityQueue.isEmpty()) {
            Node top = priorityQueue.poll();
            int idOfNode = top.getId();
            int distOfNode = top.getDist();

            final List<Node> lstOfNeighbors = graph.get(nodeId);
            for (int i = 0; i < lstOfNeighbors.size(); i++) {
                Node neighborNode = lstOfNeighbors.get(i);
                if ((distOfNode + neighborNode.getDist()) < dist[neighborNode.getId()]) {
                    dist[neighborNode.getId()] = distOfNode + neighborNode.getDist();
                    //put to queue
                    priorityQueue.add(new Node(neighborNode.getId(), neighborNode.getDist()));
                    //store path to trace back
                    path[neighborNode.getId()] = idOfNode;
                }
            }
        }
    }

    public int[] getDist() {
        return dist;
    }

    public int[] getPath() {
        return path;
    }

    public static List<List<Node>> getGraph() {
        return graph;
    }

}

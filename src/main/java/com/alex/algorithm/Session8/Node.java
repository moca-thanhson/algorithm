package com.alex.algorithm.Session8;

public class Node implements Comparable<Node> {
    private int id;
    private Integer dist;

    public Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist.compareTo(o.dist);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDist() {
        return dist;
    }

    public void setDist(Integer dist) {
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", dist=" + dist +
                '}';
    }
}

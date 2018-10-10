package com.alex.algorithm.Session6.onClass;

import com.alex.algorithm.NumberUtil;

import java.util.*;

public class Bai_Bishu_AndHistGirlFriend {

    private static Map<Point, List<Point>> graph = new HashMap<>();
    private static List<Integer> lstGirlPositions = new ArrayList<>();
    private static Point startPoint = Point.DEF_EMPTY;
    private static Point endPoint = Point.DEF_EMPTY;

    public static void dfs(Point startPoint) {
        //init stack
        final Stack<Point> stack = new Stack<>();
        stack.add(startPoint);

        //loop stack
        while (!stack.isEmpty()) {
            final Point lastPoint = stack.peek();
            stack.pop(); //delete last point in stack

//            for (int i = 0; i < graph.get(lastPoint).size(); i++) {
//                final Point childPoint = graph.get(lastPoint).get(i);
//                if(lstGirlPositions.contains(childPoint.getPosition())) {
//
//                }
//                else (!childPoint.isVisited()) {
//                    childPoint.setVisited(true);
//                    childPoint.setFatherPoint(lastPoint);
//
//                    stack.add(childPoint); //add to stack
//                }
//            }
        }

    }

    private static void printPath(Point startPoint, Point endPoint) {
        if (endPoint == startPoint) {
            System.out.println(startPoint.getPosition());
            return;
        }

        if (endPoint.getFatherPoint().equals(Point.DEF_EMPTY)) {
            System.out.println("Not found");
            return;
        }

        Point currentPoint = endPoint;
        System.out.print("\t " + endPoint.getPosition());
        while (currentPoint.getFatherPoint() != startPoint) {
            currentPoint = currentPoint.getFatherPoint();
            System.out.print("\t " + currentPoint.getPosition());
        }
        System.out.print("\t " + startPoint.getPosition());
    }


    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfVertex = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numOfVertex - 1; i++) {
            final List<Integer> edgeFromNode2Node = NumberUtil.convertByString(scanner.nextLine());
            Point.addChildNodes(graph, Point.convertToPoints(edgeFromNode2Node));
        }

        int numOfGirl = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numOfGirl; i++) {
            int posHasGirl = Integer.valueOf(scanner.nextLine());
            lstGirlPositions.add(posHasGirl);
        }

        //Find the girl with minimum distance
        final Point bishuPoint = new Point(1, false);
        dfs(bishuPoint);

        //Print the path
        printPath(bishuPoint, bishuPoint);

    }

    static class Point {

        static Point DEF_EMPTY = new Point(0, false);

        private int position;
        private boolean visited;
        private Point fatherPoint = DEF_EMPTY;
        private boolean hasGirl;

        public Point(int position, boolean visited) {
            this.position = position;
            this.visited = visited;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public Point getFatherPoint() {
            return fatherPoint;
        }

        public void setFatherPoint(Point fatherPoint) {
            this.fatherPoint = fatherPoint;
        }

        public boolean isHasGirl() {
            return hasGirl;
        }

        public void setHasGirl(boolean hasGirl) {
            this.hasGirl = hasGirl;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "position=" + position +
                    ", visited=" + visited +
                    ", fatherPoint=" + fatherPoint +
                    '}';
        }

        public static List<Point> convertToPoints(final List<Integer> numbers) {
            final List<Point> points = new ArrayList<>();
            numbers.forEach(
                    number -> {
                        final Point point = new Point(number, false);
                        points.add(point);
                    }
            );
            return points;
        }

        public static void addChildNodes(final Map<Point, List<Point>> map, final List<Point> lstPoints) {
            final Point parentNode = lstPoints.get(0);
            final List<Point> childNodes = new ArrayList<>();
            childNodes.add(lstPoints.get(1));
            if (map.containsKey(parentNode)) {
                map.get(parentNode).addAll(childNodes);
            } else {
                map.put(parentNode, childNodes);
            }
        }
    }

}

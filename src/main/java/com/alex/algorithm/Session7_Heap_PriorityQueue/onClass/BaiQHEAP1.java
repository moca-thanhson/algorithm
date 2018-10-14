package com.alex.algorithm.Session7_Heap_PriorityQueue.onClass;

import com.alex.algorithm.NumberUtil;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class BaiQHEAP1 {

    private static final int INSERT_QUERY = 1;
    private static final int DELETE_QUERY = 2; //delete the minimal number
    private static final int PRINT_QUERY = 3;  //print the minimal number

    private static PriorityQueue<Integer> queue = new PriorityQueue<>();
    private static PriorityQueue<Integer> removeQueue = new PriorityQueue<>();

    /**
     * <pre>
     *  Add temporary into remove queue first , in case the delete number is not the head item .
     *  This solution will help to reduce the complexity of algorithm.
     *  Because we need to get the first(s) item first, later we just can delete the item. Then we have to add the
     *  first(s) items again.
     * </pre>
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numOfQueries = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numOfQueries; i++) {
            final List<Integer> query = NumberUtil.convertByString(scanner.nextLine());
            final int queryType = query.get(0);
            if (PRINT_QUERY == queryType) {
                while (!removeQueue.isEmpty()) {
                    int headFromQueue = queue.peek();
                    int headFromRemove = removeQueue.peek();
                    if (headFromQueue == headFromRemove) {
                        queue.remove();
                        removeQueue.remove();
                    } else {
                        break;
                    }
                }
                System.out.println(queue.peek()); //print the minimal number

            } else if (INSERT_QUERY == queryType) {
                queue.add(query.get(1));
            } else if (DELETE_QUERY == queryType) {
                //add temporary into remove queue first , in case the delete number is not the head item .
                // This solution will help to reduce the complexity of algorithm because we need to get the first(s)
                //item first, later we just can delete the item. Then we have to add the first(s) items again.
                removeQueue.add(query.get(1)); //mark the item will be deleted when it come.
            }

        }
    }
}

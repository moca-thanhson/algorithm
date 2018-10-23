package com.alex.algorithm.Session09_MidTerm;

import com.alex.algorithm.NumberUtil;

import java.util.*;

public class PrintQueue {

    private static final int MINUTE_FOR_A_JOB = 1;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Queue<Job> queue = new LinkedList<>();
    private static final PriorityQueue<Integer> sortedQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public static void main(final String[] args) {
        System.out.print("Please enter number of test case:");
        final int numOfTestCases = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < numOfTestCases; i++) {
            printJobInQueue();
        }
    }

    /**
     * Sample Input
     * 3
     * 1 0
     * 5
     * 4 2
     * 1 2 3 4
     * 6 0
     * 1 1 9 1 1 1
     * Sample Output
     * 1
     * 2
     * 5
     */
    private static void printJobInQueue() {
        System.out.print("Please enter number of jobs:");
        final List<Integer> jobLines = NumberUtil.convertByString(scanner.nextLine());
        final int numOfJobs = jobLines.get(0);
        final int indexOfJobs = jobLines.get(1);
        System.out.print("Please enter list of jobs:");
        final List<Integer> jobs = NumberUtil.convertByString(scanner.nextLine());

        //put into sorted queue
        sortedQueue.addAll(jobs);
        Integer maxPriorityJob = sortedQueue.peek();

        //put into queue
        jobs.forEach(
                job -> queue.add(new Job(job, false))
        );

        int index = 0;
        while (true) {
            final Job peekJob = queue.peek();
            if (index == indexOfJobs) {
                peekJob.isPrintedJob = true;
            }

            index++;
            if (peekJob.isPrintedJob && peekJob.priority == maxPriorityJob) {
                System.out.print(index * MINUTE_FOR_A_JOB);
                break; //exit
            } else if (!peekJob.isPrintedJob) {
                //update max priority queue
                queue.remove();
                maxPriorityJob = sortedQueue.remove();
            } else {
                queue.remove();
                queue.add(peekJob); //move back to end queue
            }

        }
    }

    static class Job {
        private int priority;
        private boolean isPrintedJob;

        public Job(int priority, boolean isPrintedJob) {
            this.priority = priority;
            this.isPrintedJob = isPrintedJob;
        }
    }
}

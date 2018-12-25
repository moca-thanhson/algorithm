package com.alex.algorithm.Session18_FinalExam;

import com.alex.algorithm.NumberUtil;
import javafx.collections.transformation.SortedList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaiMHU_ImportantThing {

  private static final int REQUIRED_DISTINCT_TASK_SEQUENCE = 3;

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final Integer numberOfTask = Integer.valueOf(scanner.nextLine());

    final List<Integer> lstOfTask = NumberUtil.convertByString(scanner.nextLine());

    final PriorityQueue<Task> priorityTasks = new PriorityQueue<>();
    for (int position = 0; position < lstOfTask.size(); position++) {
      final int priority = Integer.valueOf(lstOfTask.get(position));
      priorityTasks.add(new Task(position + 1, priority));
    }

    int count = 1;
    final List<List<Task>> distinctTasks = new ArrayList<>();
    final Task prevTask = priorityTasks.remove();

    //init
    initDistinctTask(distinctTasks, prevTask);

    while (!priorityTasks.isEmpty()) {
      final Task currentTask = priorityTasks.remove();
      if (currentTask.equals(prevTask)) {
        count++;
      }
    }

    //check if sastify requirement about number of distinct task sequence
    if (count >= REQUIRED_DISTINCT_TASK_SEQUENCE) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  private static void initDistinctTask(final List<List<Task>> distinctTasks, final Task prevTask) {
    final List<Task> distinc1 = new ArrayList<>();
    distinc1.add(prevTask);
    final List<Task> distinc2 = new ArrayList<>();
    distinc2.add(prevTask);
    final List<Task> distinc3 = new ArrayList<>();
    distinc3.add(prevTask);

    // add into list of distinct tasks
    distinctTasks.add(distinc1);
    distinctTasks.add(distinc2);
    distinctTasks.add(distinc3);
  }

  static class Task implements Comparable<Task> {
    private Integer priority;
    private Integer position;

    public Task(int position, int priority) {
      this.position = position;
      this.priority = priority;
    }

    @Override
    public int compareTo(Task task) {
      return this.priority.compareTo(task.priority);
    }
  }
}

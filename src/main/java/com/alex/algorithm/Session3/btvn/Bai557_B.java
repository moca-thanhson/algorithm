package com.alex.algorithm.Session3.btvn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  Input:
 *  first line : number of boys, number of girls
 *  Second line : Capabicities of tea cups in mililiters
 *
 *  Output :
 *  Sum of mililiters of tea boys & girls can drink but can not exceed first line & second lines.
 *
 *  Call x as mililiters girl can drink . We have n cup , total w mililiters.
 *  Girls can drink :     x * n
 *  Boys can drink :  2 * x * n
 *  Total = 3 * x * n
 *  If( total > w) => return w.
 *  else return total ( = 3 * x * n).
 */
public class Bai557_B {

    Stack<Integer> a = new Stack<>();
    Queue<Integer> b = new LinkedList<>();
}

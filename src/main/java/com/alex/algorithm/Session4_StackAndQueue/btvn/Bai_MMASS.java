package com.alex.algorithm.Session4_StackAndQueue.btvn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.spoj.com/problems/MMASS/
 */
public class Bai_MMASS {

    public static void main(String[] args) {

        int[] atomValues = new int[100];
        atomValues[(int) 'C'] = 12;
        atomValues[(int) 'H'] = 1;
        atomValues[(int) 'O'] = 16;

        final Scanner scanner = new Scanner(System.in);

        while (true) {

            final List<Stack<Integer>> lstAllSubAtomValues = new ArrayList<>();
            //init stack
            for (int i = 0; i < 100; i++) {
                lstAllSubAtomValues.add(new Stack<>());
            }

            //read formula
            String fomula = scanner.nextLine();
            if ("0".equals(fomula)) {
                break; //exit
            }

            //calculate result
            int subFormulaIndex = 0;
            for (int i = 0; i < fomula.length(); i++) {
                char currentChar = fomula.charAt(i);
                if (currentChar == '(') {
                    subFormulaIndex += 1;
                } else if (currentChar == ')') { //calculate sub values of atom in () : C + H + 0 e.g
                    int subAtomValues = 0;
                    while (!lstAllSubAtomValues.get(subFormulaIndex).isEmpty()) {
                        subAtomValues += lstAllSubAtomValues.get(subFormulaIndex).peek();
                        lstAllSubAtomValues.get(subFormulaIndex).pop();
                    }

                    //update index
                    subFormulaIndex -= 1; //move back
                    lstAllSubAtomValues.get(subFormulaIndex).push(subAtomValues);

                } else if (currentChar >= (int) 'A' && currentChar <= (int) 'Z') {
                    int valueOfAtom = atomValues[(int) currentChar];
                    lstAllSubAtomValues.get(subFormulaIndex).push(valueOfAtom);
                } // incase we found Atom
                else { //if is number indice . For example (CHO)3 so this is case of '3'.
                    // we calculate sum of sub atom before when we saw ')'. So we just need to get it and * with
                    // number '3'.
                    int calculatedSubAtom = lstAllSubAtomValues.get(subFormulaIndex).peek();
                    lstAllSubAtomValues.get(subFormulaIndex).pop(); //delete sub atoms
                    int sumAfterMultiplied = calculatedSubAtom * (int) currentChar;
                    //put sum after * number into stack again
                    lstAllSubAtomValues.get(subFormulaIndex).push(sumAfterMultiplied);
                }


            }
        }
    }

}

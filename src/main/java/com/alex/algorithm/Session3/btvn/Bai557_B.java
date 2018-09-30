package com.alex.algorithm.Session3.btvn;

import com.alex.algorithm.Session2.onClass.NumberUtil;

import java.util.*;

/**
 * Input:
 * first line : number of boys, number of girls
 * Second line : Capabicities of tea cups in mililiters
 * <p>
 * Output :
 * Sum of mililiters of tea boys & girls can drink but can not exceed first line & second lines.
 * <p>
 * Call x as mililiters girl can drink . We have n cup , total w mililiters.
 * Girls can drink :     x * n
 * Boys can drink :  2 * x * n
 * Total = 3 * x * n
 * If( total > w) => return w.
 * else return total ( = 3 * x * n).
 */
public class Bai557_B {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Integer> cupsAndWater = NumberUtil.convertByString(scanner.nextLine());
        final List<Integer> cupsForFriends = NumberUtil.convertByString(scanner.nextLine());

        final int numofCups = cupsAndWater.get(0);
        final int maxLitres = cupsAndWater.get(1);
        int sizeCupForGirl = cupsForFriends.get(0);
        int sizeCupForBoy = cupsForFriends.get(cupsForFriends.size() - 1);

        //To get maximum litres of water so sizeCupForBoyMust > sizeCupForGirl because litres boy drink = 2 * litres girl drink.
        if (sizeCupForGirl > sizeCupForBoy) {
            int temp = sizeCupForBoy;
            sizeCupForBoy = sizeCupForGirl;
            sizeCupForGirl = temp;
        }

        // x is littres for girl .
        // (numOFCups * sizeCupForGirl * x) + (numOfCups * sizeCupForBoy * 2x)
        // = numOfCups * ( x*Size4Girl + 2x*size4Boy) <= maxLitres
        // ( x*Size4Girl + 2x*size4Boy) <= (maxLitres / numOfCups)

        int littresForBothGirlAndBoy = (maxLitres / numofCups);
        if (sizeCupForBoy == sizeCupForGirl) {
            littresForBothGirlAndBoy = littresForBothGirlAndBoy / (3 * sizeCupForBoy);
        } else { //sizeCupBoy > sizeCupGirl
            x* 2 + 2x * 4 <= (18 / 3) = 6
                x * a1 + 2x * a2 <= 6
        }


    }

}

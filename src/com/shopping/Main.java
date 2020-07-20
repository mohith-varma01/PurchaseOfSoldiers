package com.shopping;

import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IndexOutOfBoundsException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of soldiers present");
        int soldiers = scanner.nextInt();

        if(soldiers < 0)
        {
            System.out.println("Invalid Input");
            System.exit(0);
        }


        ArrayList<Soldier> soldierList = new ArrayList<>();        //array list which stores objects of the class Soldier is made

        System.out.println("Enter each soldier's strength from 1 to 10:");
        for(int str = 0; str < soldiers; str++)
        {
            Soldier s1 =  new Soldier();
            s1.setStrength(scanner.nextInt());

            if(s1.getStrength() < 1 || s1.getStrength() > 10)
            {
                System.out.println("Invalid Input");
                System.exit(0);
            }

            soldierList.add(s1);
        }

        int leastCost = 0;
        System.out.println("Enter each soldier's cost:");
        for(int cst = 0; cst < soldiers; cst++)
        {
            int reference = scanner.nextInt();
            soldierList.get(cst).setCost(reference);

            if (reference < 0)
            {
                System.out.println("Invalid Input");
                System.exit(0);
            }

            if (cst == 0)
            {
                leastCost = reference;
            }
            else
            {
                leastCost = Math.min(leastCost, reference);
            }
        }

        System.out.println("Enter the total amount present with Shriya:");
        int totalAmount = scanner.nextInt();

        ArrayList<Integer> soldierStrenghtList = new ArrayList<>();

        MaximumStrenghtAndCost m1 = new MaximumStrenghtAndCost();
        while(totalAmount >= leastCost && soldierList.size() != 0 && totalAmount >= m1.getAmount(soldierList))
        {
            //MaximumStrenghtAndCost m1 = new MaximumStrenghtAndCost();

            soldierStrenghtList.add(m1.getMaxStrenght(soldierList));
            totalAmount -= m1.getAmount(soldierList);
            soldierList.remove(m1.getPosition(soldierList));
        }

        /*for(int y = 0; y < soldierStrenghtList.size() - 1; y++)                  //to avoid repeatition of same number while displaying
        {
            if(soldierStrenghtList.get(y) == soldierStrenghtList.get(y + 1))
            {
                soldierStrenghtList.remove(y);
                y--;
            }
        }*/

        System.out.println("The soldiers with the following strengths should be bought");
        for(int k = 0; k < soldierStrenghtList.size(); k++)
        {
            System.out.print(soldierStrenghtList.get(k) + " ");
            if(k == soldierStrenghtList.size() - 1)
            {
                System.out.println();
            }
        }
        System.out.println("Amount left with Shriya at the end of the purchase is " + totalAmount);
    }
}

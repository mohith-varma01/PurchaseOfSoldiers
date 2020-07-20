package com.shopping;

import java.util.ArrayList;

public class MaximumStrenghtAndCost
{
    int getMaxStrenght(ArrayList<Soldier> sList)
    {
        int maxStrength = 0;

        for(int i = 0; i < sList.size(); i++)
        {
            maxStrength = Math.max(maxStrength, sList.get(i).getStrength());
        }

        return maxStrength;
    }

    int getPosition(ArrayList<Soldier> sList)
    {
        int maxStrength = 0;
        int pos = 0;

        for(int i = 0; i < sList.size(); i++)
        {
            if (sList.get(i).getStrength() > maxStrength)
            {
                maxStrength = sList.get(i).getStrength();
                pos = i;
            }
        }

        return pos;
    }

    int getAmount(ArrayList<Soldier> soldierArrayList)
    {
        int maxStrength = 0;
        int pos = 0;

        for(int i = 0; i < soldierArrayList.size(); i++)
        {
            if(soldierArrayList.get(i).getStrength() > maxStrength)
            {
                maxStrength = soldierArrayList.get(i).getStrength();
                pos = i;
            }
        }

        return soldierArrayList.get(pos).getCost();
    }
}

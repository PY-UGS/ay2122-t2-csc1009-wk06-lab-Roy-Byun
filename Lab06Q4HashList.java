package Week_6;

import com.sun.jdi.Value;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class Lab06Q4HashList {
    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    private static final int UPPER_BOUND = 10000;
    private static final int LOWER_BOUND = 1000;

    private static final Random random = new Random();

    public static void main(String[] args)
    {
        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();

        list.put(0,1);
        list.put(1,3);
        list.put(2,5);
        list.put(3,7);
        list.put(4,9);
        list.put(5,11);

        System.out.println("----------------------------------");
        System.out.println("Question 1");
        System.out.println("----------------------------------");
        System.out.println("Before order of list: " + list);
        addAndSort(list, 6);
        System.out.println("After order of list: " + list);
        System.out.println("----------------------------------");

        System.out.println("Question 2");
        System.out.println("----------------------------------");
        System.out.println("Before swapping of list: " + list);
        swapValues(list, 1, 6);
        System.out.println("After swapping of list: " + list);
        System.out.println("----------------------------------");

        System.out.println("Question 3");
        System.out.println("----------------------------------");

        HashMap<Integer, Integer> list2 = new HashMap<Integer, Integer>();
        Random rand = new Random();
        for (int i=0;i<500;i++){

            int number = (rand.nextInt(8999))+1000;
            list2.put(i,number);
        }
        System.out.println("Hashmap generated :"+ list2);

//        HashMap<Integer, Integer> randomList = new HashMap<>();
//        while (randomList.size() < 500) {
//            randomList.put(getRandomValue(LOWER_BOUND, UPPER_BOUND), getRandomValue(LOWER_BOUND, UPPER_BOUND));
//        }

        int idxValue = findValue(list2, getRandomValue(LOWER_BOUND, UPPER_BOUND));
        System.out.println("Index of value is " + idxValue);

    }

    public static void addAndSort(HashMap <Integer, Integer> list, int value)
    {
        if((int)list.get(list.size()-1)<value){
            list.put(list.size(),value);
        }
        else {
            int ind = 0;
            while ((int) list.get(ind) < value) {
                ind++;
            }
            int key=(int)list.size();
            for(int x=ind+1;x<list.size();x++){
                list.put(key,list.get(key-1));
                key-=1;
            }
            list.put(ind,value);
        }
    }
    public static void swapValues(HashMap<Integer, Integer> map, int ind1, int ind2)
    {
        int tp=0;
        tp=(int)map.get(ind1);
        map.put(ind1,(int)map.get(ind2));
        map.put(ind2,tp);

    }

    public static int findValue(HashMap<Integer, Integer> list, int searchVal)
    {
        for (Map.Entry<Integer, Integer> i: list.entrySet())
        {
            if (i.getValue() == searchVal)
            {
                return i.getKey();
            }

        }
        return -1;
    }

    public static int getRandomValue(int lowerBound, int upperBound)
    {
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }
}

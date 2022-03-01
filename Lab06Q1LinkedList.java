package Week_6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class Lab06Q1LinkedList {

    private static final int UPPER_BOUND = 10000;
    private static final int LOWER_BOUND = 1000;

    private static final Random random = new Random();

    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);

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

        LinkedList<Integer> randomList = new LinkedList<>();
        while (randomList.size() < 500) {
            randomList.add(getRandomValue(LOWER_BOUND, UPPER_BOUND));
        }

        int idxValue = findValue(randomList, getRandomValue(LOWER_BOUND, UPPER_BOUND));
        System.out.println("Index of value is " + idxValue);
    }

    public static void addAndSort(LinkedList<Integer> list, int value) {

        Iterator<Integer> iterator = list.iterator();
        int idx = 0;
        int prevInt = 0;
        int currInt = 0;

        while (iterator.hasNext())
        {
            currInt = iterator.next();

            if (prevInt < value && currInt >= value)
            {
                idx = list.indexOf(prevInt) + 1;
                break;
            }
            prevInt = currInt;
        }

        if (value > currInt)
        {
            idx = list.indexOf(currInt) + 1;
        }
        list.add(idx, value);
    }

    public static void swapValues(LinkedList<Integer> list, int idxOne, int idxTwo)
    {
        int elementOne = list.get(idxOne);
        int elementTwo = list.get(idxTwo);

        list.set(idxOne, elementTwo);
        list.set(idxTwo, elementOne);
    }
    public static int findValue(LinkedList<Integer> list, int searchVal)
    {
        for (int i: list)
        {
            if (i == searchVal)
            {
                return list.indexOf(searchVal);
            }
        }
        return -1;
    }

    public static int getRandomValue(int lowerBound, int upperBound)
    {
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }
}

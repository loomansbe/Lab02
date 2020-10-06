/* Copyright 2020 Victor Krieg, All Rights Reserved */
/*
 Class FixedPointList:
 This class contains a list of FixedPointNumbers and accepts 6 different
 inputted commands to manipulate the FixedPointNumbers in the list.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FixedPointList
{
    private static final int INITIAL_Q = 12;

    private List<FixedPointNumber> FixedPointNumbers; // List of FixedPointNumbers
    private Scanner in;                               // Input Object
    private int currentQ;                             // Holds current q value for the list

    // Constructor: public FixedPointList()
    //    // Default constructor initializes objects and sets currentQ = 12.
    public FixedPointList()
    {
        FixedPointNumbers = new ArrayList<FixedPointNumber>();
        in = new Scanner(System.in);
        currentQ = INITIAL_Q;
    }

    // Method: public void run();
    // Handles input of commands. Accepts 6 different character inputs and calls a
    // specific method based off which command was inputted. Loops until 'X' inputted.
    public void run()                                              
    {
        String input = in.next();

        while (!("X".equals(input) || "x".equals(input)))
        {
            if("A".equals(input) || "a".equals(input))
            {
                commandA();
            }
            else if("D".equals(input) || "d".equals(input))
            {
                commandD();
            }
            else if("P".equals(input) || "p".equals(input))
            {
                commandP();
            }
            else if("Q".equals(input) || "q".equals(input))
            {
                commandQ();
            }
            else if ("S".equals(input) || "s".equals(input))
            {
                commandS();
            }
            else
            {
                System.out.print(input + " is not a valid command!\n");
                input = in.nextLine();
            }

            input = in.next();
        }

        System.out.print("Normal termination of program1.");
    }

    // Method: public void add(FixedPointNumber p);
    // Adds new FixedPointNumber to the list.
    public void add(FixedPointNumber p)
    {
        FixedPointNumbers.add(p);
    }

    // Method: public boolean delete(FixedPointNumber p);
    // Traverses the list to find the first instance of the specified FixedPointNumber.
    // If found, removes from the list and returns true.
    public boolean delete(FixedPointNumber p)
    {
        boolean wasDeleted = false;

        for (FixedPointNumber fpn : FixedPointNumbers)
        {
            if (fpn.equals(p))
            {
                FixedPointNumbers.remove(fpn);
                wasDeleted = true;
                break;
            }
        }

        return wasDeleted;
    }

    // Method: public String toString();
    // Returns a String containing the toString info for all FixedPointNumbers in the list.
    public String toString()
    {
        StringBuilder output = new StringBuilder("All fixed-point numbers in the list are:\n");

        for (FixedPointNumber fpn : FixedPointNumbers)
        {
            output.append(fpn.toString()).append('\n');
        }

        return output.toString();
    }

    // Method: public FixedPointNumber sum(int q);
    // Returns sum of all FixedPointNumbers in the list. All FixedPointNumbers must be converted
    // to currentQ to ensure correct sum. Returns FixedPointNumber equal to the sum.
    public FixedPointNumber sum (int q)
    {
        FixedPointNumber p = new FixedPointNumber(0, q);
        boolean first = true;

        for (FixedPointNumber fpn : FixedPointNumbers)
        {
            if (first)
            {
                p = fpn.toQVal(q);
                first = false;
            }
            else
            {
                p = p.plus(fpn, q);
            }
        }

        return p;
    }

    // Method: private void commandA();
    // Method runs when 'A' is inputted. Controls adding new FixedPointNumber to list.
    private void commandA()
    {
        FixedPointNumber p = new FixedPointNumber(in.nextDouble(), currentQ);
        add(p);
        System.out.print(p.toString() + " was added to the list.\n");
    }

    // Method: private void commandD();
    // Method runs when 'D' is inputted. Controls deleting a specified FixedPointNumber from the list.
    private void commandD()
    {
        FixedPointNumber p = new FixedPointNumber(in.nextDouble(), currentQ);
        boolean wasDeleted = delete(p);

        if (wasDeleted)
        {
            System.out.print(p.toString() + " was deleted from the list.\n");
        }
        else
        {
            System.out.print("No value equal to " + p.toString() + " in the list.\n");
        }
    }

    // Method: private void commandP();
    // Method runs when 'P' is inputted. Controls outputting all FixedPointNumbers in list.
    private void commandP()
    {
        System.out.print(toString());
    }

    // Method: private void commandQ();
    // Method runs when 'Q' is inputted. Controls changing currentQ value to inputted integer.
    private void commandQ()
    {
        currentQ = in.nextInt();
        System.out.print("Current q_value was changed to " + currentQ + ".\n");
    }

    // Method: private void commandS();
    // Method runs when 'S' is inputted. Controls finding the sum of all FixedPointNumbers in list.
    private void commandS()
    {
        System.out.print("The sum is " + sum(currentQ).toString() + ".\n");
    }
}
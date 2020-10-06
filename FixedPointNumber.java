/* Copyright 2020 Victor Krieg, All Rights Reserved */
/*
    Class: FixedPointNumber
    Stores all data pertaining to a double stored as a fixed point integer. The class is able to convert
    the integer back to a double, change the numbers q value, and sum it with another FixedPointNumber.
 */
public class FixedPointNumber
{
    private int intVal;  // Stores integer value of the fixed point number.
    private int qVal;    // Stores current q value.

    // Constructor: public FixedPointNumber(double x, int q)
    // Takes a double and integer to create a new fixed point number.
    public FixedPointNumber(double x, int q)
    {
        intVal = (int)(x * Math.pow(2, q));
        qVal = q;
    }

    // Constructor: private FixedPointNumber(double x, int q)
    // Takes 2 integers to create a new fixed point number.
    private FixedPointNumber(int x, int q)
    {
        intVal = x;
        qVal = q;
    }

    // Method: private int getIntVal()
    // Returns value of intVal.
    private int getIntVal()
    {
        return intVal;
    }

    // Method: private int getQVal()
    // Returns value of qVal.
    private int getQVal()
    {
        return qVal;
    }

    // Method: public double toDouble()
    // Returns the double value of the fixed point number.
    public double toDouble()
    {
        return intVal / Math.pow(2,qVal);
    }

    // Method: public FixedPointNumber toQVal(int q)
    // Returns a new instance of this FixedPointNumber converted to a new q value.
    public FixedPointNumber toQVal(int q)
    {
        int newVal;
        if (0 <= q - qVal)
        {
             newVal = intVal << q - qVal;
        }
        else
        {
            newVal = intVal >> qVal - q;
        }
        System.out.println(newVal);
        return new FixedPointNumber(newVal , q);
    }

    // Method: public String toString()
    // Returns a 1 line String of all info pertaining to the fixed point number.
    public String toString()
    {
        return String.format("%d, %d: %.6f", intVal, qVal, toDouble());
    }

    // Method: public boolean equals(FixedPointNumber p)
    // Compares sent FixedPointNumber to this one. Returns true if intVals and qVals are equal.
    public boolean equals(FixedPointNumber p)
    {
        return (p.getIntVal() == intVal) && (p.getQVal() == qVal);
    }

    // Method: public FixedPointNumber plus(FixedPointNumber p, int resultQ)
    // Returns a new FixedPointNumber that is equal to the sum of this and the sent number.
    // Converts the FixedPointNumbers to have the same q value.
    public FixedPointNumber plus(FixedPointNumber p, int resultQ)
    {
        FixedPointNumber p1 = p.toQVal(resultQ);
        return new FixedPointNumber(p1.getIntVal() + getIntVal(), resultQ);
    }
}
using System;
using System.Collections.Generic;
using System.Text;
using System.Transactions;

namespace Lab2Example
{
    public class Example
    {
        private double currentValue;

        public Example()
        {
            currentValue = 0;
        }

        public Example(double currentValue)
        {
            this.currentValue = currentValue;
        }

        public Example add(double adder)
        {
            currentValue += adder;
            return this;
        }

        public Example subtract(double subtracter)
        {
            currentValue -= subtracter;
            return this;
        }

        public Example multiply(double multiplier)
        {
            currentValue *= multiplier;
            return this;
        }

        public Example divide(double divider)
        {
            if (divider == 0)
                Console.Write("Divide by 0, operation not completed: ");
            else
                currentValue /= divider;
            return this;
        }

        public double getCurrentValue()
        {
            return this.currentValue;
        }
    }
}
//loomansbe testing commit

using System;

namespace Lab2Example
{
    class Program
    {
        static void Main(string[] args)
        {
            Example example = new Example(20.0);

            Console.WriteLine(example.add(20.0).getCurrentValue());

            Console.WriteLine(example.subtract(5.0).getCurrentValue());

            Console.WriteLine(example.multiply(2.0).getCurrentValue());

            Console.WriteLine(example.divide(7.0).getCurrentValue());

            Console.WriteLine(example.divide(0.0).getCurrentValue());
        }
    }
}

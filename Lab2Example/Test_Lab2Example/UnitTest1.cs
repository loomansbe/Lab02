using Microsoft.VisualStudio.TestTools.UnitTesting;
using Lab2Example;

namespace Test_Lab2Example
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestConstructor()
        {
            Example ex = new Example(20.0);

            Assert.AreEqual(ex.getCurrentValue(), 20.0);
        }

        [TestMethod]
        public void TestAdd()
        {
            Example ex = new Example(20.0);

            ex.add(15.0);

            Assert.AreEqual(ex.getCurrentValue(), 35.0);
        }

        [TestMethod]
        public void TestSubtract()
        {
            Example ex = new Example(20.0);

            ex.subtract(10.0);

            Assert.AreEqual(ex.getCurrentValue(), 10.0);
        }

        [TestMethod]
        public void TestMultiply()
        {
            Example ex = new Example(20.0);

            ex.multiply(4.0);

            Assert.AreEqual(ex.getCurrentValue(), 80.0);
        }

        [TestMethod]
        public void TestDivide()
        {
            Example ex = new Example(20.0);

            ex.divide(10.0);

            Assert.AreEqual(ex.getCurrentValue(), 2.0);
        }

        [TestMethod]
        public void TestDivideByZero()
        {
            Example ex = new Example(20.0);

            ex.divide(0.0);

            Assert.AreEqual(ex.getCurrentValue(), 20.0);
        }
    }
}

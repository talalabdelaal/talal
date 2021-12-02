/*
calculates discriminant then sends the answer to DisOutput
 */
package abdelaalsteam;

/**
 *
 * @author Talal
 */
public class DisPage
{

    private double a, b, c, result;
//pseudo constructor method

    public DisPage()
    {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.result = 0;
    }

    //constructor method
    public DisPage(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.result = result;
    }

    //setter methods
    public void setA()
    {
        this.a = a;
    }

    public void setB()
    {
        this.b = b;
    }

    public void setC()
    {
        this.c = c;
    }

    public void setResult()
    {
        this.result = (this.b * this.b) - 4 * (this.a) * (this.c);
    }

    //getter methods
    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getC()
    {
        return c;
    }

    public double resultCalc()
    {
        return result = (b * b) - 4 * (a) * (c);
    }

    public String getResult()
    {
        if (result > 0)
        {
            return "there are 2 Solutions";
        }
        else if (result == 0)
        {
            return "there is 1 Solution";
        }
        else if (result < 0)
        {
            return "there are No Real Solutions";
        }
        return null;
    }

    //toString method
    public String toString()
    {
        return "The discriminant calculated using the coefficients " + getA() + ", " + getB() + ", and " + getC() + " all equal to " + resultCalc() + " meaning that " + getResult();
    }

    public static void main(String[] args)
    {
        DisPage ansari = new DisPage(8, 5, 4);
        System.out.println(ansari);
    }
}

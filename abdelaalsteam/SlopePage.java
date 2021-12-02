/*
Calculates slope using 2 different points then sends result to SlopeOutput
 */
package abdelaalsteam;

public class SlopePage
{

    private double x1, x2, y1, y2, result;
//pseudo constructor method

    public SlopePage()
    {

        this.x1 = 0;
        this.x2 = 0;
        this.y1 = 0;
        this.y2 = 0;
        this.result = 0;
    }

    //constructor method
    public SlopePage(double x1, double x2, double y1, double y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    //setter methods
    public void setX1()
    {
        this.x1 = x1;
    }

    public void setX2()
    {
        this.x2 = x2;
    }

    public void setY1()
    {
        this.y1 = y1;
    }

    public void setY2()
    {
        this.y2 = y2;
    }

    public void setResult()
    {
        this.result = (this.y1 - this.y2) / (this.x1 - this.x2);
    }

    //getter methods
    public double getX1()
    {
        return x1;
    }

    public double getX2()
    {
        return x2;
    }

    public double getY1()
    {
        return y1;
    }

    public double getY2()
    {
        return y2;
    }

    public double resultCalc()
    {
        return result = (y1 - y2) / (x1 - x2);
    }

    public double getResult()
    {
        return result;
    }

    //toString method
    public String toString()
    {
        return "The slope using the Ys " + getY1() + " and " + getY2() + " as well as the Xs " + getX1() + " and " + getX2() + " is " + resultCalc();
    }
//main method

    public static void main(String[] args)
    {
        SlopePage ansari = new SlopePage(8, 5, 4, 6);
        System.out.println(ansari);
    }
}

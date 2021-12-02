/*
Calculates the corresponding Y then sends the answer to SpecificPointOutput
 */
package abdelaalsteam;

public class NewXPage
{

    private double newX, slope, oldX, oldY, result;
//pseudo constructor method

    public NewXPage()
    {
        this.newX = 0;
        this.slope = 0;
        this.oldX = 0;
        this.oldY = 0;
        this.result = 0;
    }

    //constructor method
    public NewXPage(double newX, double slope, double oldX, double oldY)
    {
        this.newX = newX;
        this.slope = slope;
        this.oldX = oldX;
        this.oldY = oldY;
        this.result = result;
    }

    //setter methods
    public void setNewX()
    {
        this.newX = newX;
    }

    public void setSlope()
    {
        this.slope = slope;
    }

    public void setOldX()
    {
        this.oldX = oldX;
    }

    public void setOldY()
    {
        this.oldY = oldY;
    }

    public void setResult()
    {
        this.result = (this.slope * (this.newX - this.oldX)) + this.oldY;
        this.result = this.result * 1000;
        this.result = (int) this.result;
        this.result = ((double) this.result) / 1000;
    }

    //getter methods
    public double getNewX()
    {
        return newX;
    }

    public double getSlope()
    {
        return slope;
    }

    public double getOldX()
    {
        return oldX;
    }

    public double getOldY()
    {
        return oldY;
    }

    public double getResult()
    {
        return (slope * (newX - oldX)) + oldY;
    }

    //toString method
    public String toString()
    {
        return "The Y is " + getResult() + " and the point on the graph is (" + getNewX() + ", " + getResult() + ").";
    }
//main method

    public static void main(String[] args)
    {
        NewXPage ansari = new NewXPage(4, 3, 6, 5);
        System.out.println(ansari);
    }
}

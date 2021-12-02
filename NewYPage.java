/*
Calculates the corresponding X then sends the answer to SpecificPointOutput
 */
package abdelaalsteam;

public class NewYPage
{

    private double newY, slope, oldX, oldY, result;
//pseudo constructor method

    public NewYPage()
    {
        this.newY = 0;
        this.slope = 0;
        this.oldX = 0;
        this.oldY = 0;
        this.result = 0;
    }

    //constructor method
    public NewYPage(double newY, double slope, double oldX, double oldY)
    {
        this.newY = newY;
        this.slope = slope;
        this.oldX = oldX;
        this.oldY = oldY;
        this.result = result;
    }

    //setter methods
    public void setNewX()
    {
        this.newY = newY;
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
        this.result = ((this.newY - this.oldY) / this.slope) + this.oldX;
        this.result = this.result * 1000;
        this.result = (int) this.result;
        this.result = ((double) this.result) / 1000;
    }

    //getter methods
    public double getNewX()
    {
        return newY;
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
        return ((newY - oldY) / slope) + oldX;
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

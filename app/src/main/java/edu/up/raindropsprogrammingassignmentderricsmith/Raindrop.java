package edu.up.raindropsprogrammingassignmentderricsmith;
/*
@Author Derric Smith
@Date 2/18/25
NOTE: I worked alongside Alex and Carter for some of this project, so we came up with a few ideas together
 */
import android.graphics.Color;

public class Raindrop
{

    private int x;
    private int y;
    private int color;

    public Raindrop(int x, int y, int color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getColor()
    {
        return color;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    // This uses a math formula (Thanks Alex and Carter) that gets a very close estimate of when the main raindrop is considered "overlapping" with another one
    public boolean overlaps(Raindrop drop)
    {
        int distance = (int) Math.sqrt(Math.pow(this.x - drop.getX(), 2) + Math.pow(this.y - drop.getY(), 2));
        return distance < 60;
    }

    // Changes the main raindrop to red once it absorbs other raindrops (This may be updated later)
    public void absorb(Raindrop drop)
    {
        this.color = Color.RED;
    }
}
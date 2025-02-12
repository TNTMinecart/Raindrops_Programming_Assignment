package edu.up.raindropsprogrammingassignmentderricsmith;

import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class Raindrop {

    protected int x;

    protected int y;

    protected int size = 30;

    protected Random rng = new Random();

    protected Paint raindropPaint;


    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
    protected void randomPaint()
    {
        int newColor = Color.rgb(rng.nextInt(0,256), rng.nextInt(0,256), rng.nextInt(0, 256));
        raindropPaint = new Paint();
        raindropPaint.setColor(newColor);
    }

    /*
@author Derric Smith
@Date 2/10/25
 */
    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM) // I had to use this line a few times for some reason, don't fully understand why
    public Raindrop()
    {
        x = rng.nextInt(0,790)+10;
        y = rng.nextInt(0, 790)+10;
        randomPaint();
    }

    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
    public Raindrop(int _x, int _y)
    {
        x = _x;
        y = _y;
        randomPaint();
    }

    public void draw(Canvas canvas)
    {
        canvas.drawOval(x, y, x+30, y+30, raindropPaint);
    }
}

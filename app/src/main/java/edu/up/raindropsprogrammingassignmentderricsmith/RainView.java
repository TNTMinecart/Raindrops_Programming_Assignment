package edu.up.raindropsprogrammingassignmentderricsmith;

import android.os.Build;
import android.util.AttributeSet;
import android.content.Context;
import android.view.SurfaceView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.RequiresApi;

import java.util.Random;

/*
@author Derric Smith
@Date 2/10/25
 */

public class RainView extends SurfaceView
    {


    protected Random rng2 = new Random();


    public RainView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        for(int i = 0; i < rng2.nextInt(6,11); i++)
        {
            Raindrop newDrop = new Raindrop();
            newDrop.draw(canvas);
        }
    }
}

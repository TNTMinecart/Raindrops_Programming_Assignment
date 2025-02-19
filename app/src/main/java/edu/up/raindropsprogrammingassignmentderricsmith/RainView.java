package edu.up.raindropsprogrammingassignmentderricsmith;
/*
@Author Derric Smith
@Date 2/18/25
NOTE: I worked alongside Alex and Carter for some of this project, so we came up with a few ideas together
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.content.Context;
import android.view.SurfaceView;
import android.view.MotionEvent;
import androidx.annotation.RequiresApi; // This had to be imported for the api thing
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RainView extends SurfaceView
{

    private List<Raindrop> raindrops = new ArrayList<>();
    private Raindrop mainRaindrop;
    private Random rng = new Random();

    public RainView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false); // I actually hate this line, I will put this comment every time I have to use this from now on.
    }

    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM) // Had to use this to fix an error

    // Creates the random raindrops when you first start the app
    // NOTE: Alex helped me with this part
    public void initializeRaindrops() {
        for (int i = 0; i < rng.nextInt(6, 11); i++)
        {
            int x = rng.nextInt(0, 800);
            int y = rng.nextInt(0, 800);
            int color = Color.rgb(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            raindrops.add(new Raindrop(x, y, color));
        }

        // Select the main raindrop randomly (Lame, I know)
        int mainRaindropIndex = rng.nextInt(raindrops.size());
        mainRaindrop = raindrops.get(mainRaindropIndex);
    }

    public Raindrop getMainRaindrop()
    {
        return mainRaindrop;
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        // I used this for troubleshooting, I don't think I still need it but I will keep it just in case
        if (mainRaindrop == null)
        {
            return;
        }

        Paint paint = new Paint();

        for (Raindrop drop : raindrops)
        {
            paint.setColor(drop.getColor());
            canvas.drawCircle(drop.getX(), drop.getY(), 30, paint);
        }

        // This is the main raindrop
        paint.setColor(mainRaindrop.getColor());
        canvas.drawCircle(mainRaindrop.getX(), mainRaindrop.getY(), 30, paint);
    }

    public void changeMainRaindropPosition(int x, int y)
    {
        mainRaindrop.setX(Math.min(800, Math.max(0, x)));
        mainRaindrop.setY(Math.min(800, Math.max(0, y)));

        for (Raindrop drop : raindrops)
        {
            if (mainRaindrop != drop && mainRaindrop.overlaps(drop))
            {
                raindrops.remove(drop);
                mainRaindrop.absorb(drop);
                break;
            }
        }

        invalidate(); // Used for troubleshooting, may remove later
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
        {
            int x = (int) event.getX();
            int y = (int) event.getY();

            changeMainRaindropPosition(x, y);

            return true;
        }
        return super.onTouchEvent(event);
    }
}


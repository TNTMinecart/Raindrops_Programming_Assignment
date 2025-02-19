package edu.up.raindropsprogrammingassignmentderricsmith;
/*
@Author Derric Smith
@Date 2/18/25
NOTE: I worked alongside Alex and Carter for some of this project, so we came up with a few ideas together
 */

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private TextView textViewUp;
    private TextView textViewDown;
    private TextView textViewLeft;
    private TextView textViewRight;
    private SeekBar horizontalSeekbar;
    private SeekBar verticalSeekbar;
    public RainView rainView;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM) // I had to add this in several places, idk why
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize the rainView and the raindrops
        rainView = findViewById(R.id.rainView);
        rainView.initializeRaindrops();

        // Initialize the seekbars and all the text for them
        textViewUp = findViewById(R.id.textView);
        textViewDown = findViewById(R.id.textView2);
        textViewLeft = findViewById(R.id.textView3);
        textViewRight = findViewById(R.id.textView4);
        verticalSeekbar = findViewById(R.id.seekBar);
        horizontalSeekbar = findViewById(R.id.seekBar2);

        // max values for the 2 seekbars
        verticalSeekbar.setMax(800);
        horizontalSeekbar.setMax(800);

        // Set up the controller
        new RainController(rainView, verticalSeekbar, horizontalSeekbar);

        // Set up the change listeners for the seekbars (Detects when they are changed)

        horizontalSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                rainView.changeMainRaindropPosition(progress, rainView.getMainRaindrop().getY());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        }); // Why does it error out without the closing parenthesis and semicolon here?

        verticalSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                rainView.changeMainRaindropPosition(rainView.getMainRaindrop().getX(), progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        }); // Same with this one.
    }
}

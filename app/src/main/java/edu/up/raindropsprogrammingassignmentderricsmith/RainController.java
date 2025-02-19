package edu.up.raindropsprogrammingassignmentderricsmith;
/*
@Author Derric Smith
@Date 2/18/25
NOTE: I worked alongside Alex and Carter for some of this project, so we came up with a few ideas together
 */
import android.widget.SeekBar;

public class RainController
{

    private RainView rainView;
    private SeekBar verticalSeekBar;
    private SeekBar horizontalSeekBar;

    public RainController(RainView _rainView, SeekBar _verticalSeekBar, SeekBar _horizontalSeekBar)
    {
        this.rainView = _rainView;
        this.verticalSeekBar = _verticalSeekBar;
        this.horizontalSeekBar = _horizontalSeekBar;

        // This sets the starting point of the 2 seekbars to where the "main raindrop" starts (Might change this later)
        verticalSeekBar.setProgress(rainView.getMainRaindrop().getY());
        horizontalSeekBar.setProgress(rainView.getMainRaindrop().getX());

        setupSeekBars();
    }
    // Sets up both seekbars
    private void setupSeekBars()
    {
        verticalSeekBar.setMax(800);
        verticalSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
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
        });

        horizontalSeekBar.setMax(800);
        horizontalSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
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
        });
    }
}

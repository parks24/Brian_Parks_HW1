package up.edu.brian_parks_hw1;

import android.widget.SeekBar;

/**
 * This class handles events within the app, such as a seekbar changing position.
 * It implements the SeekBar.OnSeekBarChangeListener interface to respond to seekbar changes.
 *
 * @author Brian Parks
 */
public class rainController implements SeekBar.OnSeekBarChangeListener {
    // Reference to the RainView object
    private final RainView rainView;

    /**
     * Constructor that initializes the controller with the given RainView.
     *
     * @param rainView The RainView object to be controlled
     */
    public rainController(RainView rainView) {
        this.rainView = rainView;
    }

    /**
     * Called when the progress level of the seekbar is changed.
     * Updates the position of the main raindrop based on the seekbar progress.
     *
     * @param seekBar The seekbar whose progress has changed
     * @param progress The current progress level of the seekbar
     * @param fromUser True if the progress change was initiated by the user
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.seekBarX) {
            this.rainView.getMain().x = progress;
        } else if (seekBar.getId() == R.id.seekBarY) {
            this.rainView.getMain().y = seekBar.getMax() - progress;
        }
        this.rainView.invalidate();
    }

    /**
     * Called when the user starts tracking the seekbar.
     *
     * @param seekBar The seekbar that is being tracked
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No action needed here
    }

    /**
     * Called when the user stops tracking the seekbar.
     *
     * @param seekBar The seekbar that was being tracked
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // No action needed here
    }
}

package up.edu.brian_parks_hw1;

/**
 * @author Brian Parks
 *
 * This class is the class that handles events within the app such as a seekbar changing position
 *
 *
 *
 */

import android.widget.SeekBar;

public class rainController implements SeekBar.OnSeekBarChangeListener{
    private final RainView rainView;
    public rainController(RainView rainView){
        this.rainView = rainView;
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.seekBarX){
            this.rainView.getMain().x = progress;
        } else if (seekBar.getId() == R.id.seekBarY) {
            this.rainView.getMain().y = seekBar.getMax()-progress;
        }
        this.rainView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

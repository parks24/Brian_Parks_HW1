package up.edu.brian_parks_hw1;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * MainActivity handles the main interface of the app, including initialization
 * and event handling for seekbars.
 *
 * @author Brian Parks
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting. This is where most initialization
     * should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down, then this Bundle contains the data it
     *                           most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable EdgeToEdge display
        EdgeToEdge.enable(this);

        // Set the screen orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Set the content view to the activity_main layout
        setContentView(R.layout.activity_main);

        // Apply window insets for the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the RainView and rainController
        RainView rainView = findViewById(R.id.rainview);
        rainController rController = new rainController(rainView);

        // Set up the Y-axis seekbar
        SeekBar seekBarY = findViewById(R.id.seekBarY);
        seekBarY.setOnSeekBarChangeListener(rController);
        seekBarY.setProgress(rainView.getMain().y);

        // Set up the X-axis seekbar
        SeekBar seekBarX = findViewById(R.id.seekBarX);
        seekBarX.setOnSeekBarChangeListener(rController);
        seekBarX.setProgress(rainView.getMain().x);

    }
}

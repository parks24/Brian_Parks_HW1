package up.edu.brian_parks_hw1;

/**
 * @author Brian Parks
 *
 * This class handles the creation of the app
 *
 */

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RainView rainView = findViewById(R.id.rainview);
        rainController rController = new rainController(rainView);

        SeekBar seekBarY = findViewById(R.id.seekBarY);
        seekBarY.setOnSeekBarChangeListener(rController);
        seekBarY.setProgress(rainView.getMain().y);

        SeekBar seekBarX = findViewById(R.id.seekBarX);
        seekBarX.setOnSeekBarChangeListener(rController);
        seekBarX.setProgress(rainView.getMain().x);

    }
}
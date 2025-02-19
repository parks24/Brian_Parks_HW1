package up.edu.brian_parks_hw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents the view where rain drops are drawn.
 * It extends SurfaceView and handles the creation and drawing of raindrops.
 *
 * @author Brian Parks
 */
public class RainView extends SurfaceView {

    // List of raindrops to be drawn
    private ArrayList<rainDrop> drops = new ArrayList<>();

    // Index of the main drop in the list
    private final int MAIN = 0;

    // Random number generator for creating raindrops
    protected Random gen = new Random();

    /**
     * Constructor that initializes the view and creates initial raindrops.
     *
     * @param context The context object to be passed to the SurfaceView constructor
     * @param attrs The AttributeSet object to be passed to the SurfaceView constructor
     */
    public RainView(Context context, AttributeSet attrs) {
        // initial setup
        super(context, attrs);
        setWillNotDraw(false);

        // Draw initial drops
        for (int i = 0; i < (gen.nextInt(6) + 6); ++i) {
            drops.add(new rainDrop());
        }

        // Set background color
        setBackgroundColor(Color.WHITE);
    } // constructor

    /**
     * Merges a given raindrop into the main raindrop.
     *
     * @param drop The raindrop to be merged
     */
    public void mergeDrop(rainDrop drop) {
        int index = drops.indexOf(drop);
        drops.get(MAIN).mix(drops.get(index));
        drops.remove(index);
    }

    /**
     * Returns the main raindrop.
     *
     * @return The main raindrop
     */
    public rainDrop getMain() {
        return drops.get(MAIN);
    }

    /**
     * Draws the raindrops onto the given canvas.
     *
     * @param canvas The canvas object on which to draw the view
     */
    @Override
    public void onDraw(Canvas canvas) {
        for (int i = 1; i < drops.size(); i++) {
            int mainY = drops.get(MAIN).y;
            int mainX = drops.get(MAIN).x;
            int targetX = drops.get(i).x;
            int targetY = drops.get(i).y;

            int dist = (int) Math.sqrt(Math.pow(targetX - mainX, 2) + Math.pow(targetY - mainY, 2));
            if (dist <= (drops.get(MAIN).SIZE + drops.get(i).SIZE)) {
                mergeDrop(drops.get(i));
                i = 1;
            } else {
                drops.get(i).draw(canvas);
            }
        }
        drops.get(MAIN).draw(canvas);
    } // onDraw

} // class RainView

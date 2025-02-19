package up.edu.brian_parks_hw1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/**
 * This class handles the raindrops by setting their positions, colors, and drawing them.
 *
 * @author Brian Parks
 */
public class rainDrop {
    // Position coordinates of the raindrop
    protected int x;
    protected int y;

    // Size of the raindrop
    protected final int SIZE = 30;

    // Paint object to set the color of the raindrop
    private Paint myPaint;

    // Random number generator for creating random positions and colors
    protected Random gen = new Random();

    /**
     * Sets a random paint color for the raindrop.
     */
    private void setRandomPaint() {
        int color = Color.rgb(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
        myPaint = new Paint();
        myPaint.setColor(color);
    } // setRandomPaint

    /**
     * Default constructor that sets an initial random position and color for the raindrop.
     */
    public rainDrop() {
        x = gen.nextInt(800);
        y = gen.nextInt(800);
        setRandomPaint();
    } // constructor

    /**
     * Mixes the color of this raindrop with another raindrop's color.
     *
     * @param toMix The raindrop to be mixed with this raindrop
     */
    public void mix(rainDrop toMix) {
        // Pull both colors
        int mainColor = myPaint.getColor();
        int otherColor = toMix.myPaint.getColor();

        // Separate into RGB values
        int mainB = Color.blue(mainColor);
        int mainR = Color.red(mainColor);
        int mainG = Color.green(mainColor);
        int otherB = Color.blue(otherColor);
        int otherR = Color.red(otherColor);
        int otherG = Color.green(otherColor);

        // Average colors
        int newR = (mainR + otherR) / 2;
        int newG = (mainG + otherG) / 2;
        int newB = (mainB + otherB) / 2;

        // Set paint to the new color
        int newColor = Color.rgb(newR, newG, newB);
        myPaint.setColor(newColor);
    }

    /**
     * Draws the raindrop on the specified canvas object.
     *
     * @param canvas The canvas object on which to draw the raindrop
     */
    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, SIZE, myPaint);
    } // draw

} // class rainDrop

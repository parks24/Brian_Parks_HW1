package up.edu.brian_parks_hw1;

/**
 * @author Brian Parks
 *
 * This class is the class that handles the rain drops
 *
 * setRandomPaint()
 *      sets a paint color for the rain drop
 *
 * RainDrop()
 *      default constructor sets an initial random position and color for the rain drop
 *
 * draw(Canvas)
 *      param: the canvas object you want the drop to be drawn on
 *
 *      draws the drop on the specified canvas object
 *
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

public class rainDrop {
    protected int x;
    protected int y;
    protected int size = 30;
    private Paint myPaint;
    protected Random gen = new Random();

    private void setRandomPaint() {
        int color = Color.rgb(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
        myPaint = new Paint();
        myPaint.setColor(color);
    }//setRandomPaint

    public rainDrop() {
        x = gen.nextInt(800);
        y = gen.nextInt(800);
        setRandomPaint();
    }//constructor

    public void mix (rainDrop toMix){
        // pull both colors
        int mainColor = myPaint.getColor();
        int otherColor = toMix.myPaint.getColor();

        // separate into RGB values
        int mainB = Color.blue(mainColor);
        int mainR = Color.red(mainColor);
        int mainG= Color.green(mainColor);
        int otherB = Color.blue(otherColor);
        int otherR = Color.red(otherColor);
        int otherG= Color.green(otherColor);

        // average colors
        int newR = (mainR+otherR)/2;
        int newG = (mainG+otherG)/2;
        int newB = (mainB+otherB)/2;

        // set paint to the new color
        int newColor = Color.rgb(newR, newG, newB);
        myPaint.setColor(newColor);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, size, myPaint);
    }//draw
}//class RainDrop

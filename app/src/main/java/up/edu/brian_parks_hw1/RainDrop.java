/// @author Brian_Parks

package up.edu.brian_parks_hw1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

public class RainDrop {
    protected int x;
    protected int y;
    protected int rad = 30;
    protected Paint myPaint; // how the spot is drawn
    protected Random rando = new Random();

    protected void setRandomPaint() {
        int color = Color.rgb(rando.nextInt(256), rando.nextInt(256), rando.nextInt(256));
        myPaint = new Paint();
        myPaint.setColor(color);
    }//setRandomPaint

    public RainDrop() {
        x = rando.nextInt(800);
        y = rando.nextInt(800);
        setRandomPaint();
    }//constructor

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, rad, myPaint);
    }//draw
}//class RainDrop

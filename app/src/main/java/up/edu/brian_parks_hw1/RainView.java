/// @author Brian_Parks

package up.edu.brian_parks_hw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Random;

public class RainView extends SurfaceView{
    private ArrayList<RainDrop> drops = new ArrayList<>();

    protected Random rando = new Random();

    Paint rainPaint = new Paint();

    public RainView(Context context, AttributeSet attrs) {
        // initial setup
        super(context, attrs);
        setWillNotDraw(false);

        //draw initial drops
        for(int i = 0; i < (rando.nextInt(6)+6); ++i) {
            drops.add(new RainDrop());
        }

        // set background
        setBackgroundColor(Color.WHITE);
    }//constructor

    @Override
    public void onDraw(Canvas canvas) {

        for(RainDrop drop : drops) {
            drop.draw(canvas);
        }

    }//onDraw

}//class RainView

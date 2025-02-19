package up.edu.brian_parks_hw1;

/**
 * @author Brian Parks
 *
 * This classs is the view that the rain drops are drawn in
 *
 * RainView(Context, AttributeSet)
 *      param 1: context object to be passed to the surfaceview constructor
 *      param 2: attributeset object to be passed to the surfaceview constructor
 *
 *      creates the initial rain drops and sets up the view
 *
 * onDraw(Canvas)
 *      param: the canvas object you want the view to be drawn on
 *
 *      draws the rain drops on the onto the view's canvas
 *
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Random;

public class RainView extends SurfaceView{
    private ArrayList<rainDrop> drops = new ArrayList<>();

    private final int MAIN = 0;
    protected Random gen = new Random();

    public RainView(Context context, AttributeSet attrs) {
        // initial setup
        super(context, attrs);
        setWillNotDraw(false);

        //draw initial drops
        for(int i = 0; i < (gen.nextInt(6)+6); ++i) {
            drops.add(new rainDrop());
        }

        // set background
        setBackgroundColor(Color.WHITE);
    }//constructor

    public void mergeDrop(rainDrop drop) {
        int index = drops.indexOf(drop);
        drops.get(MAIN).mix(drops.get(index));
        drops.remove(index);
    }

    public rainDrop getMain(){
        return drops.get(MAIN);
    }

    @Override
    public void onDraw(Canvas canvas) {

        for (int i = 1; i < drops.size();i++) {

            int mainY = drops.get(MAIN).y;
            int mainX = drops.get(MAIN).x;
            int targetX = drops.get(i).x;
            int targetY = drops.get(i).y;

            int dist = (int) Math.sqrt(Math.pow(targetX - mainX, 2) + Math.pow(targetY - mainY, 2));
            if (dist <= (drops.get(MAIN).size + drops.get(i).size)){
                mergeDrop(drops.get(i));
                i = 1;
            }else{
                drops.get(i).draw(canvas);
            }
        }
        drops.get(MAIN).draw(canvas);

    }//onDraw

}//class RainView

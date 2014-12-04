package com.example.vlarios.greenhouseproject;

import 	android.view.View;
import 	android.content.Context;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Color;

/**
 * Created by vlarios on 12/1/2014.
 */
public class DrawArea extends View{
    Paint paint = new Paint();

    public DrawArea(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {

        int lowX = 20;
        int lowY = 130;
        int hiX = 350;
        int hiY = 350;
        int numDivX = 11;
        int sizeDivX = (hiX - lowX) / numDivX;
        int numDivY = 11;
        int sizeDivY = (hiY- lowY) / numDivY;

        int[] pointsArray = {4,6,8,10,9,7,5,3,1,3};

        //draw rectangle
        Rect rect = new Rect(lowX, lowY, hiX, hiY);

        // fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawRect(rect, paint);

        // border
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);

        //draw X scale
        for (int i = 1; i < numDivX; i++) {
            canvas.drawLine(lowX + (sizeDivX * i), hiY - 10, lowX + (sizeDivX * i), hiY + 10, paint);
            canvas.drawText("24h", lowX + (sizeDivX * i)-6, hiY + 25, paint);
            canvas.drawText("00m", lowX + (sizeDivX * i)-6, hiY + 45, paint);
            canvas.drawText("00s", lowX + (sizeDivX * i)-6, hiY + 65, paint);
        }

        //draw Y scale
        for (int i = 1; i < numDivY; i++) {
            canvas.drawLine(lowX-10, hiY - (sizeDivY * i), lowX+10, hiY - (sizeDivY * i), paint);
            canvas.drawText("9", lowX-17, hiY - (sizeDivY * i), paint);
        }

        //draw points and lines
        int xIni;
        int xFinal;
        int yIni;
        int yFinal;
        for (int i = 1; i < numDivX; i++) {
            canvas.drawRect(lowX + (sizeDivX * i), (hiY - (sizeDivY * pointsArray[i-1]))-4,(lowX + (sizeDivX * i))+4, hiY - (sizeDivY * pointsArray[i-1]), paint);
            if (i < numDivX-1) {
                xIni = lowX + (sizeDivX * i);
                xFinal = lowX + (sizeDivX * (i+1));
                yIni = hiY - (sizeDivY * pointsArray[i-1]);
                yFinal = hiY - (sizeDivY * pointsArray[i]);
                canvas.drawLine(xIni,yIni,xFinal,yFinal,paint);
            }

        }

    }
}

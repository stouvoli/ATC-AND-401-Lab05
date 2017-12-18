package com.numeris_ci.customviewindrawer;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class AndroidATCView extends View{
    //Circle and text colors
    private int squareCol, labelCol;
    //Label text
    private String squareText;
    //paint for drawing custom view
    private Paint squarePaint;

    public AndroidATCView(Context context, AttributeSet attrs) {
        super(context, attrs);
        squarePaint = new Paint();
        //Get the attributes specified in attrs.xml
        //using names you include
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AndroidATCView, 0, 0);
        try{
            //get the text and colors specified using
            //the names in attrs.xml
            squareText = a.getString(R.styleable.AndroidATCView_squareLabel);
            squareCol = a.getInteger(R.styleable.AndroidATCView_squareColor, 0);
            labelCol = a.getInteger(R.styleable.AndroidATCView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    public int getSquareColor() {
        return squareCol;
    }

    public void setSquareColor(int newColor) {
        //update the instance variable
        squareCol = newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public int getLabelColor() {
        return labelCol;
    }

    public void setLabelColor(int newColor) {
        //update the instance variable
        labelCol = newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public String getLabelText() {
        return squareText;
    }

    public void setLabelText(String newLabel) {
        //update the instance variable
        squareText = newLabel;
        //redraw the view
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //set drawing properties
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setAntiAlias(true);

        //set the paint color using the circle coler specified
        squarePaint.setColor(squareCol);

        //draw the square using the properties defined
        canvas.drawRect(0,0,this.getMeasuredWidth(),this.getMeasuredHeight(), squarePaint);

        //set the text color using the color specified
        squarePaint.setColor(labelCol);

        //set text properties
        squarePaint.setTextAlign(Paint.Align.CENTER);
        squarePaint.setTextSize(50);

        //draw the text using the string attribute and chosen properties
        canvas.drawText(squareText, this.getMeasuredWidth()/2,this.getMeasuredHeight()/2, squarePaint);
    }
}

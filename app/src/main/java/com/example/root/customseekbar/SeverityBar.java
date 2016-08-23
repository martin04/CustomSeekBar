package com.example.root.customseekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by root on 23.8.16.
 */
public class SeverityBar extends SeekBar {
    private Paint selected, unselected;
    private int halfSize = 15;
    private RectF position;

    public SeverityBar(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public SeverityBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public SeverityBar(Context context) {
        super(context);
        selected = new Paint(Paint.ANTI_ALIAS_FLAG);
        selected.setColor(ContextCompat.getColor(context, android.R.color.holo_green_dark));
        selected.setStyle(Paint.Style.FILL);
        unselected = new Paint(Paint.ANTI_ALIAS_FLAG);
        unselected.setColor(ContextCompat.getColor(context, android.R.color.holo_orange_dark));
        selected.setStyle(Paint.Style.FILL);
        position = new RectF();
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        float margin = (canvas.getWidth() - (paddingLeft + getPaddingRight())) / 4;
        float halfHeight = (canvas.getHeight() + paddingTop) * .5f;
        for (int i = 0; i < 5; i++) {
            position.set(
                    paddingLeft + (i * margin) - halfSize,
                    halfHeight - halfSize,
                    paddingLeft + (i * margin) + halfSize,
                    halfHeight + halfSize);
            canvas.drawOval(position, (i < getProgress()) ? selected : unselected);
        }
    }

    public int getDotsSize() {
        return halfSize * 2;
    }

    public void setDotsSize(int dotsSize) {
        this.halfSize = dotsSize / 2;
    }
}

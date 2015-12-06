package com.example.airnavigate.Views.Widgets;


import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.example.airnavigate.R;

/**
 * indeterminate circular progress widget
 */
public class CircularProgress extends ProgressBar {
    public CircularProgress(Context context) {
        super(context);
        init();
    }

    public CircularProgress(Context context, AttributeSet attrs) {
        super(context, attrs);init();
    }

    public CircularProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        if (!isInEditMode()) {
            int color = getResources().getColor(R.color.green_deep);
            Drawable indeterminateDrawable = getIndeterminateDrawable();
            Drawable progressDrawable = getProgressDrawable();

            if (indeterminateDrawable != null)
                indeterminateDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            if (progressDrawable != null)
                progressDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void setLoading(boolean isLoading) {
        setVisibility(isLoading ? VISIBLE : GONE);
    }

}

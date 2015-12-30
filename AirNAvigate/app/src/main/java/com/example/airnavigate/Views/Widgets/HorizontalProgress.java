package com.example.airnavigate.Views.Widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.airnavigate.R;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * Indeterminate horizontal progress widget
 */
public class HorizontalProgress extends FrameLayout {


    @Bind(R.id.text)
    TextView progressDescription;

    @Bind(R.id.progressWidget)
    ProgressBar bar;

    public HorizontalProgress(Context context) {
        super(context);
        init(null);
    }

    public HorizontalProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public HorizontalProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View.inflate(getContext(), R.layout.widget_progressbar_horizontal, this);
        ButterKnife.bind(this);
        if (attrs != null) {
            int[] vv = {R.attr.progressText};
            TypedArray a = getContext().obtainStyledAttributes(attrs, vv);
            String text = a.getString(0);
            if (text != null) {
                progressDescription.setText(text);
            }
            a.recycle();
        }
        if (!isInEditMode()) {
            int color = getResources().getColor(R.color.green_deep);
            Drawable indeterminateDrawable = bar.getIndeterminateDrawable();
            Drawable progressDrawable = bar.getProgressDrawable();

            if (indeterminateDrawable != null)
                indeterminateDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
            if (progressDrawable != null)
                progressDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }

    }

    public void setLoading(boolean isLoading) {
        if (isLoading) {
            setAlpha(1);
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
            /*int time = getResources().getInteger(android.R.integer.config_mediumAnimTime);
            int delay = getResources().getInteger(android.R.integer.config_shortAnimTime);

            animate().alpha(0).setStartDelay(delay).setDuration(time).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    setVisibility(GONE);
                }
            });*/
        }

    }

}

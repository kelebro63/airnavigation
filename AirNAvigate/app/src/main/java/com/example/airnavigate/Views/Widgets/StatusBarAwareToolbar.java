package com.example.airnavigate.Views.Widgets;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * This toolbar includes a paddingTop == status bar size, so that status bar may be assigned a transparent color
 */
public class StatusBarAwareToolbar extends Toolbar {
    public StatusBarAwareToolbar(Context context) {
        super(context);
        init();
    }

    public StatusBarAwareToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StatusBarAwareToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statusBarHeight = getStatusBarHeight();
            setPadding(0, 0, 0, 0); //statusBarHeight
        }
    }

    // A method to find height of the status bar
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}

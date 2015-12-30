package com.example.airnavigate.Utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Kelebro63 on 30.12.2015.
 */
public class Utils {

    public static int dpToPx(Context context, float dp) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()
        );
    }

}

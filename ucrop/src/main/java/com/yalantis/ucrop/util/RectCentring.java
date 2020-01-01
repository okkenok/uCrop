package com.yalantis.ucrop.util;

import android.graphics.RectF;
import android.util.Log;

public class RectCentring {

    public static RectF centeringRect(float time, RectF fromRect, RectF initialRect, float duration) {
        RectF destRect = new RectF();
        destRect.left = initialRect.left;
        destRect.right = initialRect.right;
        if (fromRect.width() >= fromRect.height()) {
            destRect.left = initialRect.left;
            destRect.top = initialRect.centerY() - fromRect.height() * initialRect.width() / fromRect.width() * 0.5f;
            destRect.right = initialRect.right;
            destRect.bottom = initialRect.centerY() + fromRect.height() * initialRect.width() / fromRect.width() * 0.5f;
        } else {
            destRect.left = initialRect.centerX() - fromRect.width() * initialRect.height() / fromRect.height() * 0.5f;
            destRect.top = initialRect.top;
            destRect.left = initialRect.centerX() + fromRect.width() * initialRect.height() / fromRect.height() * 0.5f;
            destRect.bottom = initialRect.bottom;
        }
        Log.d("hg", "left = " + (fromRect.left + (destRect.left - fromRect.left) / duration * time)
                + " top = " + (fromRect.top + (destRect.top - fromRect.top) / duration * time)
                + " right = " + (fromRect.right + (destRect.right - fromRect.right) / duration * time)
                + " bottom = " + (fromRect.bottom + (destRect.bottom - fromRect.bottom) / duration * time));
        return new RectF(fromRect.left + (destRect.left - fromRect.left) / duration * time,
                fromRect.top + (destRect.top - fromRect.top) / duration * time,
                fromRect.right + (destRect.right - fromRect.right) / duration * time,
                fromRect.bottom + (destRect.bottom - fromRect.bottom) / duration * time);
    }
}

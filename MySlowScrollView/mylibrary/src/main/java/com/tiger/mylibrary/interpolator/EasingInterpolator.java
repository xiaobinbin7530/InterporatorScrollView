package com.tiger.mylibrary.interpolator;

import android.support.annotation.NonNull;
import android.view.animation.Interpolator;

public class EasingInterpolator implements Interpolator {

    private final Ease ease;

    public EasingInterpolator(@NonNull Ease ease) {
        this.ease = ease;
    }

    @Override
    public float getInterpolation(float input) {
        return EasingProvider.get(this.ease, input);
    }

    public Ease getEase() {
        return ease;
    }
}

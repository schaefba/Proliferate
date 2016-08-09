package com.cschaefbauer.magic_counter;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by Chris Schaefbauer on 8/5/16.
 */
public class LifeCountRangeInputFilter implements InputFilter {

    private Integer min, max;

    public LifeCountRangeInputFilter(Integer min, Integer max) {

        this.min = min;
        this.max = max;
    }


    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        Integer input = Integer.parseInt(dest.toString()+source.toString());
        if((input <= max) && (input >= min))  {
            return null;
        }

        return "";
    }
}

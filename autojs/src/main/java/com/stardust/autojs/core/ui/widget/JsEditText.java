package com.stardust.autojs.core.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Stardust on 2017/5/15.
 */
@SuppressLint("AppCompatCustomView")
public class JsEditText extends EditText {
    public JsEditText(Context context) {
        super(context);
    }

    public JsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public JsEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public JsEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public String text() {
        return getText().toString();
    }

    public void text(CharSequence text) {
        setText(text);
    }

}

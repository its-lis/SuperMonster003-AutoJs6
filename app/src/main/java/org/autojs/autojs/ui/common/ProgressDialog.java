package org.autojs.autojs.ui.common;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import org.autojs.autojs6.R;

/**
 * Created by Stardust on 2017/7/31.
 */
public class ProgressDialog {

    private final MaterialDialog mDialog;

    public ProgressDialog(Context context) {
        this(context, R.string.text_in_progress);
    }

    public ProgressDialog(Context context, int resId) {
        mDialog = new MaterialDialog.Builder(context)
                .progress(true, 0)
                .cancelable(false)
                .content(resId)
                .show();
    }

    public void dismiss() {
        mDialog.dismiss();
    }

}

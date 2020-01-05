package com.ndz.displayhelper.progress;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Vrindak on 12/12/19.
 */
public class ProgressManager {
    private Context mContext;
    private int maxLimit;
    private String mTitle;
    private String mMessage;
    private int style;
    private ProgressDialog progressDialog;
    private int mTheme;

    public ProgressManager(Builder builder) {
        mContext = builder.mContext;
        maxLimit = builder.maxLimit;
        mTitle = builder.mTitle;
        mMessage = builder.mMessage;
        style = builder.style;
        mTheme = builder.mTheme;

    }


    public void showProgress() {
        if (mTheme != 0) {
            switch (mTheme) {
                case 1:
                    progressDialog = new ProgressDialog(mContext, ProgressDialog.THEME_HOLO_DARK);
                    break;
                case 2:
                    progressDialog = new ProgressDialog(mContext, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
            }

        } else {
            progressDialog = new ProgressDialog(mContext);
        }
        progressDialog.setMax(maxLimit);
        progressDialog.setMessage(mMessage);
        progressDialog.setTitle(mTitle);
        progressDialog.setProgressStyle(style);
        progressDialog.show();
    }

    public void setProgress(int mProgress) {
        progressDialog.setProgress(mProgress);
    }

    public void dismissProgress() {
        progressDialog.dismiss();
    }


    public static class Builder {
        private Context mContext;
        private int maxLimit = 100;
        private String mTitle;
        private String mMessage;
        private int style;
        private int mTheme;

        public Builder setmTheme(int mTheme) {
            this.mTheme = mTheme;
            return this;
        }

        public Builder setmContext(Context mContext) {
            this.mContext = mContext;
            return this;
        }

        public Builder setMaxLimit(int maxLimit) {
            this.maxLimit = maxLimit;
            return this;
        }

        public Builder setmTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }

        public Builder setmMessage(String mMessage) {
            this.mMessage = mMessage;
            return this;
        }

        public Builder setStyle(int style) {
            this.style = style;
            return this;
        }

        public ProgressManager build() {
            ProgressManager mInstance = new ProgressManager(this);
            return mInstance;
        }
    }
}

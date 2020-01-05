package com.ndz.displayhelper.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ndz.displayhelper.R;

import static android.widget.Toast.makeText;


/**
 * Created by Vrindak on 11/12/19.
 */
public class ToastManager {

    private Context mcontext;
    private String message;
    private int duration;
    private int gravity;
    private int color;
    private int drawable;


    private ToastManager(Builder mBuilder) {
        mcontext = mBuilder.mcontext;
        message = mBuilder.message;
        duration = mBuilder.duration;
        gravity = mBuilder.gravity;
        color = mBuilder.color;
        drawable = mBuilder.drawable;

    }


    public void showToast() {


        if (color == 0 && drawable == 0) {
            Toast mToast = makeText(mcontext, message, duration);
            mToast.setGravity(gravity, 0, 0);
            mToast.show();

        } else if (color != 0 && drawable != 0) {
            Toast mToast = new Toast(mcontext);
            mToast.setGravity(gravity, 0, 0);
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mView = inflater.inflate(R.layout.item_toast_layout, null);
            ImageView imageView = (ImageView) mView.findViewById(R.id.iv_toast);
            imageView.setBackgroundResource(drawable);
            TextView mTextview = mView.findViewById(R.id.tv_toast_message);
            mTextview.setText(message);
            mToast.setGravity(gravity, 0, 0);
            mToast.setDuration(duration);
            mView.setBackgroundColor(color);
            mToast.setView(mView);
            mToast.show();
        } else if (color != 0 && drawable == 0) {
            Toast mToast = makeText(mcontext, message, duration);
            mToast.setGravity(gravity, 0, 0);
            View mView = mToast.getView();
            mView.setBackgroundColor(color);
            mToast.show();
        } else if (drawable != 0 && color == 0) {
            Toast mToast = new Toast(mcontext);
            mToast.setGravity(gravity, 0, 0);
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View mView = inflater.inflate(R.layout.item_toast_layout, null);
            ImageView imageView = (ImageView) mView.findViewById(R.id.iv_toast);
            imageView.setBackgroundResource(drawable);
            TextView mTextview = mView.findViewById(R.id.tv_toast_message);
            mTextview.setText(message);
            mToast.setGravity(gravity, 0, 0);
            mToast.setDuration(duration);
            mToast.setView(mView);
            mToast.show();
        }


    }

    public static class Builder {
        private Context mcontext;
        private String message;
        private int duration = Toast.LENGTH_SHORT;
        private int gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        private int color;
        private int drawable;

        public Builder setcontext(Context mcontext) {
            this.mcontext = mcontext;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }

        public Builder setDrawable(int drawable) {
            this.drawable = drawable;
            return this;
        }

        public ToastManager build() {
            ToastManager mInstance = new ToastManager(this);
            return mInstance;

        }

    }

}

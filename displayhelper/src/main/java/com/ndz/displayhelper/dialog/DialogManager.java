package com.ndz.displayhelper.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Vrindak on 12/12/19.
 */
public class DialogManager {
    private String message;
    private String title;
    private String positivebutton;
    private String negativeButton;
    private String neutralButon;
    private Context mContext;
    private AlertDialog alertDialog;
    //    DialogListener mListener;
    private DialogListenerClick mPositiveListener;
    private DialogListenerClick mNegativeListener;
    private DialogListenerClick mNeturalListener;

    private DialogManager(Builder builder) {
        message = builder.message;
        title = builder.title;
        positivebutton = builder.positivebutton;
        mContext = builder.mContext;
        neutralButon = builder.neutralButton;
        negativeButton = builder.negativeButton;
        mPositiveListener = builder.mPositiveListener;

    }

    public void showDialog() {
        alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        if (positivebutton != null) {

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, positivebutton, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mPositiveListener.onButtonClick();
                }
            });

        }
        if (negativeButton != null) {


            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeButton, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mNegativeListener.onButtonClick();
                }
            });

        }
        if (neutralButon != null) {

            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, neutralButon, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mNeturalListener.onButtonClick();
                }
            });


        }
        alertDialog.show();

    }

    public void dismissDialog() {
        alertDialog.dismiss();
    }


    public interface DialogListenerClick {
        void onButtonClick();


    }

    public static class Builder {

        DialogListenerClick mPositiveListener;
        DialogListenerClick mNegativeListener;
        DialogListenerClick mNeturalListener;
        private String message;
        private String title;
        private Context mContext;
        private String positivebutton;
        private String negativeButton;
        private String neutralButton;

        public Builder setNegativeButton(String negativeButton, DialogManager.DialogListenerClick mNegativeListener) {
            this.negativeButton = negativeButton;
            this.mNegativeListener = mNegativeListener;
            return this;
        }

        public Builder setNeutralButton(String neutralButton, DialogManager.DialogListenerClick mNeturalListener) {
            this.neutralButton = neutralButton;
            this.mNeturalListener = mNeturalListener;
            return this;
        }

        public Builder setContext(Context mcontext) {
            this.mContext = mcontext;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPositivebutton(String positivebutton, DialogManager.DialogListenerClick mPositiveListener) {
            this.positivebutton = positivebutton;
            this.mPositiveListener = mPositiveListener;
            return this;
        }


        public DialogManager build() {
            DialogManager mInstance = new DialogManager(this);
            return mInstance;
        }

    }


}

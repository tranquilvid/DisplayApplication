package com.ndz.displayhelper.dialog;


import androidx.fragment.app.FragmentManager;

import static com.ndz.displayhelper.dialog.MaterialDialog.getInstance;

/**
 * Created by Vrindak on 18/12/19.
 */
public class MaterialDialogManager {
    private int ivBackground;
    private int imageIcon;
    private String title;
    private String datas;
    private String buttonText;
    private int buttoncolor;
    private int layoutBackground;

    public MaterialDialogManager(Builder builder) {
        this.ivBackground = builder.ivBackground;
        this.imageIcon = builder.imageIcon;
        this.title = builder.title;
        this.datas = builder.datas;
        this.buttonText = builder.buttonText;
        this.buttoncolor = builder.buttoncolor;
        this.layoutBackground = builder.layoutBackground;
    }

    public void showDialog(FragmentManager mFragmentManager) {

        MaterialDialog mdialog = getInstance(ivBackground, imageIcon, title, datas, buttonText, buttoncolor, layoutBackground);

        mdialog.show(mFragmentManager, "DialogFragment");

    }

    public interface MaterialDialogListenerClick {
        void onButtonClick();


    }


    public static class Builder {
        private int ivBackground;
        private int imageIcon;
        private String title;
        private String datas;
        private String buttonText;
        private int buttoncolor;
        private int layoutBackground;
        MaterialDialogListenerClick mButtonclickListener;

        public Builder setmButtonclickListener(MaterialDialogListenerClick mButtonclickListener) {
            this.mButtonclickListener = mButtonclickListener;
            return this;
        }

        public Builder setIvBackground(int ivBackground) {

            this.ivBackground = ivBackground;
            return this;
        }

        public Builder setImageIcon(int imageIcon) {
            this.imageIcon = imageIcon;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDatas(String datas) {

            this.datas = datas;
            return this;
        }

        public Builder setButtonText(String buttonText) {

            this.buttonText = buttonText;
            return this;
        }

        public Builder setButtoncolor(int buttoncolor) {

            this.buttoncolor = buttoncolor;
            return this;
        }

        public Builder setLayoutBackground(int layoutBackground) {
            this.layoutBackground = layoutBackground;
            return this;
        }

        public MaterialDialogManager build() {
            MaterialDialogManager mInstance = new MaterialDialogManager(this);
            return mInstance;

        }
    }


}

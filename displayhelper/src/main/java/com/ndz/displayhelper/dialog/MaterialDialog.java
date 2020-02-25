package com.ndz.displayhelper.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.ndz.displayhelper.R;

import java.util.Objects;

import static com.ndz.displayhelper.ConstantValues.BUTTON_COLOR;
import static com.ndz.displayhelper.ConstantValues.BUTTON_TEXT;
import static com.ndz.displayhelper.ConstantValues.DIALOG_DATA;
import static com.ndz.displayhelper.ConstantValues.DIALOG_TITLE;
import static com.ndz.displayhelper.ConstantValues.IMAGE_BACKGROUND;
import static com.ndz.displayhelper.ConstantValues.IMAGE_ICON;
import static com.ndz.displayhelper.ConstantValues.LAYOUT_BACKGROUND;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialDialog extends DialogFragment {
    private int mCirclebg;
    private int mImageicon;
    private int mButtonColor;
    private int mlayoutcolor;
    private String mTitlevalue;
    private String mDatavalue;
    private String mbtntext;
    private MaterialDialogManager.MaterialDialogListenerClick mListenerClick;



    static MaterialDialog getInstance(int ivBackground, int imageIcon, String title, String datas, String buttonText, int buttoncolor, int layoutBackground, MaterialDialogManager.MaterialDialogListenerClick mListener) {
        MaterialDialog  materialDialog = new MaterialDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(IMAGE_BACKGROUND, ivBackground);
        bundle.putInt(IMAGE_ICON, imageIcon);
        bundle.putString(DIALOG_TITLE, title);
        bundle.putString(DIALOG_DATA, datas);
        bundle.putString(BUTTON_TEXT, buttonText);
        bundle.putInt(BUTTON_COLOR, buttoncolor);
        bundle.putInt(LAYOUT_BACKGROUND, layoutBackground);
        materialDialog.mListenerClick=mListener;
        materialDialog.setArguments(bundle);

        return materialDialog;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onResume() {
        super.onResume();

        try {
            WindowManager.LayoutParams mLayoutParams = Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).getAttributes();
            mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            mLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            Objects.requireNonNull(getDialog().getWindow()).setAttributes(mLayoutParams);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog mDialog = super.onCreateDialog(savedInstanceState);
        if (mDialog.getWindow() != null) {
            mDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }


        return mDialog;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Bundle b = getArguments();
        if (b != null) {
            if (b.getInt(IMAGE_BACKGROUND) != 0) {
                mCirclebg = b.getInt(IMAGE_BACKGROUND);
            }
            if (b.getInt(IMAGE_ICON) != 0) {
                mImageicon = b.getInt(IMAGE_ICON);

            }
            if (b.getInt(BUTTON_COLOR) != 0) {
                mButtonColor = b.getInt(BUTTON_COLOR);

            }
            if (b.getInt(LAYOUT_BACKGROUND) != 0) {
                mlayoutcolor = b.getInt(LAYOUT_BACKGROUND);

            }
            if (b.getString(DIALOG_TITLE) != null) {
                mTitlevalue = b.getString(DIALOG_TITLE);
            }
            if (b.getString(DIALOG_DATA) != null) {
                mDatavalue = b.getString(DIALOG_DATA);
            }
            if (b.getString(BUTTON_TEXT) != null) {
                mbtntext = b.getString(BUTTON_TEXT);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_material_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout mLinearLayout;
        ImageView mImage;
        TextView mTitle;
        TextView mData;
        Button mOkButton;
        View mview;
        mLinearLayout = view.findViewById(R.id.ll_circle_image);
        mImage = view.findViewById(R.id.iv_circle_inside);
        mTitle = view.findViewById(R.id.tv_title_dialog);
        mData = view.findViewById(R.id.tv_message_dialog);
        mOkButton = view.findViewById(R.id.bt_dialog);
        mview = view.findViewById(R.id.view_customdialog);

        if (mCirclebg != 0) {
            GradientDrawable sd = (GradientDrawable) mLinearLayout.getBackground();
            sd.setColor((mCirclebg));
        }
        if (mImageicon != 0) {
            mImage.setImageResource(mImageicon);

        }
        if (mTitlevalue != null && !mTitlevalue.isEmpty()) {
            mTitle.setText(mTitlevalue);
        }
        if (mDatavalue != null && !mDatavalue.isEmpty()) {
            mData.setText(mDatavalue);
        }
        if (mButtonColor != 0) {
            mOkButton.setBackgroundColor(mButtonColor);
        }
        if (mlayoutcolor != 0) {
            mview.setBackgroundColor(mlayoutcolor);

        }
        if (mbtntext != null) {
            mOkButton.setText(mbtntext);

            mOkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   mListenerClick.onButtonClick();
                }
            });
        }


    }


}

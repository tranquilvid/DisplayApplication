package com.ndz.displayapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.ndz.displayhelper.dialog.DialogManager;
import com.ndz.displayhelper.dialog.MaterialDialogManager;
import com.ndz.displayhelper.toast.ToastManager;


public class SampleActivity extends AppCompatActivity {
    LinearLayout mLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onToastClick(View view) {
        ToastManager mbuilder = new ToastManager.Builder().setcontext(this).setColor(Color.parseColor("#09900D")).setMessage("hello user").setDuration(1).setDrawable(R.drawable.iconfinder_star_227558).setGravity((Gravity.TOP|Gravity.FILL_HORIZONTAL)).setOffsetx(0).setOffsety(getSupportActionBar().getHeight()).build();
        mbuilder.showToast();
    }

    public void onDialogClick(View view) {
        DialogManager mdialogbuilder = new DialogManager.Builder().setContext(SampleActivity.this).setTitle("Alert").setPositivebutton("Yes", new DialogManager.DialogListenerClick() {
            @Override
            public void onButtonClick() {
                ToastManager mbuilder = new ToastManager.Builder().setcontext(SampleActivity.this).setMessage("Positive Button Click").setDuration(1).build();
                mbuilder.showToast();
            }
        }).setNegativeButton("cancel", new DialogManager.DialogListenerClick() {
            @Override
            public void onButtonClick() {

            }
        }).setMessage("My Alert Dialog").build();
        mdialogbuilder.showDialog();
    }

    public void onMaterialdialogClick(View view) {
        FragmentManager mFragmentManager=getSupportFragmentManager();
        MaterialDialogManager mDialogManager=new MaterialDialogManager.Builder().setButtoncolor(Color.parseColor("#bb6dc7")).setButtonText("YES").setTitle("Success").setDatas("Material Dialog successfully shown").setIvBackground(Color.parseColor("#bb6dc7")).setmButtonclickListener(new MaterialDialogManager.MaterialDialogListenerClick() {
            @Override
            public void onButtonClick() {
               Toast.makeText(SampleActivity.this,"Ok Click",Toast.LENGTH_SHORT).show();

            }
        }).build();
        mDialogManager.showDialog(mFragmentManager);

    }

    public void onProgressClick(View view) {
       Intent i=new Intent(SampleActivity.this,SampleProgressDialog.class);
       startActivity(i);

    }
}

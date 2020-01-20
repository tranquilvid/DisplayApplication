package com.ndz.displayapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ndz.displayhelper.dialog.DialogManager;
import com.ndz.displayhelper.dialog.MaterialDialog;
import com.ndz.displayhelper.dialog.MaterialDialogManager;
import com.ndz.displayhelper.progress.ProgressManager;
import com.ndz.displayhelper.toast.ToastManager;


public class SampleActivity extends AppCompatActivity {
    LinearLayout mLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /*  mLayout=findViewById(R.id.layout_login);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               *//* ProgressManager mManager = new ProgressManager.Builder().setmContext(this).setMaxLimit(100).setmMessage("Loading....").setmTitle("Api Call").setStyle(1).setmTheme(0).build();
                mManager.showProgress();
               *//*
            }
        });*/

    }

    public void onToastClick(View view) {
        ToastManager mbuilder = new ToastManager.Builder().setcontext(this).setMessage("hello user").setDuration(1).setDrawable(R.drawable.iconfinder_star_227558).setGravity((Gravity.FILL_HORIZONTAL)).build();
        mbuilder.showToast();
    }

    public void onDialogClick(View view) {
        DialogManager mdialogbuilder = new DialogManager.Builder().setContext(SampleActivity.this).setTitle("Alert").setPositivebutton("Yes", new DialogManager.DialogListenerClick() {
            @Override
            public void onButtonClick() {
                ToastManager mbuilder = new ToastManager.Builder().setcontext(SampleActivity.this).setMessage("Positive Button Click").setDuration(1).build();
                mbuilder.showToast();
            }
        }).setMessage("My Alert Dialog").build();
        mdialogbuilder.showDialog();
    }

    public void onMaterialdialogClick(View view) {
        FragmentManager mFragmentManager=getSupportFragmentManager();
        MaterialDialogManager mDialogManager=new MaterialDialogManager.Builder().setButtoncolor(Color.parseColor("#bb6dc7")).setButtonText("YES").setTitle("Success").setDatas("Material Dialog successfully shown").setIvBackground(Color.parseColor("#bb6dc7")).build();
        mDialogManager.showDialog(mFragmentManager);

    }

    public void onProgressClick(View view) {
        ProgressManager mManager;
        mManager = new ProgressManager.Builder().setmContext(this).setMaxLimit(100).setmMessage("Loading....").setmTitle("Api Call").setStyle(1).build();
        mManager.showProgress();

    }
}

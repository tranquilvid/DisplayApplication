package com.ndz.displayapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.ndz.displayhelper.dialog.DialogManager;
import com.ndz.displayhelper.dialog.MaterialDialog;
import com.ndz.displayhelper.dialog.MaterialDialogManager;
import com.ndz.displayhelper.progress.ProgressManager;
import com.ndz.displayhelper.toast.ToastManager;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* ToastManager mbuilder = new ToastManager.Builder().setcontext(this).setMessage("hello").setDuration(1).setDrawable(R.drawable.iconfinder_star_227558).setGravity((Gravity.CENTER_HORIZONTAL)).build();
        mbuilder.showToast();
        DialogManager mdialogbuilder = new DialogManager.Builder().setContext(this).setTitle("Alert").setPositivebutton("Yes", new DialogManager.DialogListenerClick() {
            @Override
            public void onButtonClick() {
                Toast.makeText(getApplicationContext(),"Positive",Toast.LENGTH_LONG).show();
            }
        }).setMessage("My Alert Dialog").build();
        mdialogbuilder.showDialog();*/
        ProgressManager mManager = new ProgressManager.Builder().setmContext(this).setMaxLimit(100).setmMessage("Loading....").setmTitle("Api Call").setStyle(1).setmTheme(0).build();
        mManager.showProgress();
        FragmentManager mFragmentManager=getSupportFragmentManager();
        MaterialDialogManager mDialogManager=new MaterialDialogManager.Builder().setButtoncolor(Color.parseColor("#bb6dc7")).setButtonText("YES").setTitle("Success").setIvBackground(Color.parseColor("#bb6dc7")).build();
        mDialogManager.showDialog(mFragmentManager);

    }
}

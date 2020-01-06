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


public class MainActivity extends AppCompatActivity {
    LinearLayout mLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastManager mbuilder = new ToastManager.Builder().setcontext(this).setMessage("hello user").setDuration(1).setDrawable(R.drawable.iconfinder_star_227558).setGravity((Gravity.FILL_HORIZONTAL)).build();
        mbuilder.showToast();


        mLayout=findViewById(R.id.layout_login);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogManager mdialogbuilder = new DialogManager.Builder().setContext(MainActivity.this).setTitle("Alert").setPositivebutton("Yes", new DialogManager.DialogListenerClick() {
                    @Override
                    public void onButtonClick() {
                        Toast.makeText(getApplicationContext(),"Positive",Toast.LENGTH_LONG).show();
                    }
                }).setMessage("My Alert Dialog").build();
                mdialogbuilder.showDialog();
               /* ProgressManager mManager = new ProgressManager.Builder().setmContext(this).setMaxLimit(100).setmMessage("Loading....").setmTitle("Api Call").setStyle(1).setmTheme(0).build();
                mManager.showProgress();
                FragmentManager mFragmentManager=getSupportFragmentManager();
                MaterialDialogManager mDialogManager=new MaterialDialogManager.Builder().setButtoncolor(Color.parseColor("#bb6dc7")).setButtonText("YES").setTitle("Success").setIvBackground(Color.parseColor("#bb6dc7")).build();
                mDialogManager.showDialog(mFragmentManager);*/
            }
        });

    }
}

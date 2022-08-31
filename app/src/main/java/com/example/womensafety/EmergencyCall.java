package com.example.womensafety;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import static android.Manifest.permission.CALL_PHONE;

public class EmergencyCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_helpline);

        Button b1,b2,b3;
        b1=findViewById(R.id.button8);
        b2=findViewById(R.id.button9);
        b3=findViewById(R.id.button10);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.purple_500));
        }

        b1.setOnClickListener(view -> call("102"));

        b2.setOnClickListener(view -> call("1091"));

        b3.setOnClickListener(view -> call("100"));

    }
    private void call(String number) {
        Intent i= new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:"+number));
        if(ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE )== PackageManager.PERMISSION_GRANTED){
            startActivity(i);
        }
        else{
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            {
                requestPermissions(new String[]{CALL_PHONE},1);
            }

        }
    }
}


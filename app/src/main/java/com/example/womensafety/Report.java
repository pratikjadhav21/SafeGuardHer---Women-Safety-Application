package com.example.womensafety;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Report extends AppCompatActivity {
    TextView txt_message;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.purple_500));
        }

        TextView txt_Message = (TextView) findViewById(R.id.articleLink);
        txt_Message.setText("You can read here the full article along with picture demonstrations https://www.healthline.com/health/womens-health/self-defense-tips-escape#protection-alternatives/");
        Linkify.addLinks(txt_Message, Linkify.WEB_URLS);
    }
}
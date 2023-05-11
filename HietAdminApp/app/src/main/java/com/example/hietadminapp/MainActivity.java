package com.example.hietadminapp;



import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.hietadminapp.faculty.UpdateFaculty;
import com.example.hietadminapp.notice.DeleteNoticeActivity;
import com.example.hietadminapp.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView card1,addGalleryImage,addEbook,faculty,deleteNotice,logoutBtn;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        card1 = (CardView) findViewById(R.id.c1);
        addGalleryImage = (CardView) findViewById(R.id.addGalleryImage);
        addEbook = (CardView) findViewById(R.id.addEbook);
        faculty = (CardView) findViewById(R.id.faculty);
        deleteNotice = (CardView) findViewById(R.id.deleteNotice);
        logoutBtn = (CardView) findViewById(R.id.logoutBtn);

        card1.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){

            case R.id.c1:
                i = new Intent(MainActivity.this,UploadNotice.class);
                startActivity(i);
                break;
            case R.id.addGalleryImage:
                i = new Intent(MainActivity.this,UploadImage.class);
                startActivity(i);
                break;
            case R.id.addEbook:
                i = new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(i);
                break;
            case R.id.faculty:
                i = new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(i);
                break;
            case R.id.deleteNotice:
                i = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(i);
                break;

            case R.id.logoutBtn:
                finishAffinity();

                i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
                break;



        }


    }
}



package com.haocent.android.doubanmovie.ui.celebrity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.haocent.android.doubanmovie.R;

/**
 * 影人条目
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieCelebrityActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MovieCelebrityActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_celebrity);

        initView();
    }

    private void initView() {
        setTitle("影人条目");

        Button btnCelebrityInfo = findViewById(R.id.btn_celebrity_info);
        Button btnCelebrityPhoto = findViewById(R.id.btn_celebrity_photo);
        Button btnCelebrityWork = findViewById(R.id.btn_celebrity_work);

        btnCelebrityInfo.setOnClickListener(this);
        btnCelebrityPhoto.setOnClickListener(this);
        btnCelebrityWork.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_celebrity_info:
                Intent intentCelebrityInfo = new Intent(this, MovieCelebrityInfoActivity.class);
                startActivity(intentCelebrityInfo);
                break;
            case R.id.btn_celebrity_photo:
                Intent intentCelebrityPhoto = new Intent(this, MovieCelebrityPhotoActivity.class);
                startActivity(intentCelebrityPhoto);
                break;
            case R.id.btn_celebrity_work:
                Intent intentCelebrityWork = new Intent(this, MovieCelebrityWorkActivity.class);
                startActivity(intentCelebrityWork);
                break;
            default:
                break;
        }
    }
}

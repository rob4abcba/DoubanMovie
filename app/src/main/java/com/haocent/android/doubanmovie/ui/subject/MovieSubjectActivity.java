package com.haocent.android.doubanmovie.ui.subject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.haocent.android.doubanmovie.R;

/**
 * 电影条目
 *
 * Created by Tnno Wu on 2018/01/30.
 */

public class MovieSubjectActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MovieSubjectActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_subject);

        initView();
    }

    private void initView() {
        setTitle("电影条目");

        Button btnSubjectInfo = findViewById(R.id.btn_subject_info);
        Button btnSubjectPhoto = findViewById(R.id.btn_subject_photo);
        Button btnSubjectReview = findViewById(R.id.btn_subject_review);
        Button btnSubjectComment = findViewById(R.id.btn_subject_comment);

        btnSubjectInfo.setOnClickListener(this);
        btnSubjectPhoto.setOnClickListener(this);
        btnSubjectReview.setOnClickListener(this);
        btnSubjectComment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_subject_info:
                Intent intentSubjectInfo = new Intent(this, MovieSubjectInfoActivity.class);
                startActivity(intentSubjectInfo);
                break;
            case R.id.btn_subject_photo:
                Intent intentSubjectPhoto = new Intent(this, MovieSubjectPhotosActivity.class);
                startActivity(intentSubjectPhoto);
                break;
            case R.id.btn_subject_review:
                Intent intentSubjectReview = new Intent(this, MovieSubjectReviewsActivity.class);
                startActivity(intentSubjectReview);
                break;
            case R.id.btn_subject_comment:
                Intent intentSubjectComment = new Intent(this, MovieSubjectCommentsActivity.class);
                startActivity(intentSubjectComment);
                break;
            default:
                break;
        }
    }
}

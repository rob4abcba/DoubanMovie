package com.haocent.android.doubanmovie.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.haocent.android.doubanmovie.R;

/**
 * 搜索
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieSearchActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MovieSearchActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);

        initView();
    }

    private void initView() {
        setTitle("搜索");

        Button btnMovieSearchQ = findViewById(R.id.btn_search_q);

        btnMovieSearchQ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search_q:
                Intent intentSearchQ = new Intent(this,MovieSearchQActivity.class);
                startActivity(intentSearchQ);
                break;
            default:
                break;
        }
    }
}

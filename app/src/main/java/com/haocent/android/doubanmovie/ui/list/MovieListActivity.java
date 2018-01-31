package com.haocent.android.doubanmovie.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.haocent.android.doubanmovie.R;

/**
 * 榜单
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieListActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MovieListActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        initView();
    }

    private void initView() {
        setTitle("榜单");

        Button btnListInTheaters = findViewById(R.id.btn_list_in_theaters);
        Button btnListComingSoon = findViewById(R.id.btn_list_coming_soon);

        btnListInTheaters.setOnClickListener(this);
        btnListComingSoon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_list_in_theaters:
                Intent intentInTheaters = new Intent(this, MovieListInTheatersActivity.class);
                startActivity(intentInTheaters);
                break;
            case R.id.btn_list_coming_soon:
                Intent intentComingSoon = new Intent(this, MovieListComingSoonActivity.class);
                startActivity(intentComingSoon);
            default:
                break;
        }
    }
}

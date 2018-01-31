package com.haocent.android.doubanmovie.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}

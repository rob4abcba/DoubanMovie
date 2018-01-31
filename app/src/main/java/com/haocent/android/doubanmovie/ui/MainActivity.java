package com.haocent.android.doubanmovie.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.ui.celebrity.MovieCelebrityActivity;
import com.haocent.android.doubanmovie.ui.search.MovieSearchActivity;
import com.haocent.android.doubanmovie.ui.subject.MovieSubjectActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button btnMovieSubject = findViewById(R.id.btn_movie_subject);
        Button btnMovieCelebrity = findViewById(R.id.btn_movie_celebrity);
        Button btnMovieSearch = findViewById(R.id.btn_movie_search);

        btnMovieSubject.setOnClickListener(this);
        btnMovieCelebrity.setOnClickListener(this);
        btnMovieSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_movie_subject:
                Intent intentMovieSubject = new Intent(this, MovieSubjectActivity.class);
                startActivity(intentMovieSubject);
                break;
            case R.id.btn_movie_celebrity:
                Intent intentMovieCelebrity = new Intent(this, MovieCelebrityActivity.class);
                startActivity(intentMovieCelebrity);
                break;
            case R.id.btn_movie_search:
                Intent intentMovieSearch = new Intent(this, MovieSearchActivity.class);
                startActivity(intentMovieSearch);
            default:
                break;
        }
    }
}

package com.haocent.android.doubanmovie.ui.celebrity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieCelebrityWorksBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 影人作品
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieCelebrityWorkActivity extends AppCompatActivity {

    private static final String TAG = MovieCelebrityWorkActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_celebrity_content);

        initService();

        initView();

        // 影人作品
        initMovieCelebrityWorksData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("影人作品");
    }

    /**
     * 影人作品
     */
    private void initMovieCelebrityWorksData() {
        Observable<MovieCelebrityWorksBean> observable = mService.getMovieCelebrityWorks(
                Constant.CELEBRITY_ID,
                Constant.API_KEY
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieCelebrityWorksBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");

                    }

                    @Override
                    public void onNext(MovieCelebrityWorksBean movieCelebrityWorksBean) {
                        Log.d(TAG, "onNext: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}

package com.haocent.android.doubanmovie.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieSearchByQueryBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 根据字段搜索
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieSearchQActivity extends AppCompatActivity {

    private static final String TAG = MovieSearchQActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search_content);

        initService();

        initView();

        // 根据字段搜索
        initMovieSearchByQueryData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("根据字段搜索");
    }

    /**
     * 根据字段搜索
     */
    private void initMovieSearchByQueryData() {
        Observable<MovieSearchByQueryBean> observable = mService.getMovieSearchByQuery(
                "周杰伦",
                Constant.API_KEY,
                0,
                10
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieSearchByQueryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieSearchByQueryBean movieSearchByQueryBean) {
                        Log.d(TAG, "onNext: ");

                        // TODO:
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

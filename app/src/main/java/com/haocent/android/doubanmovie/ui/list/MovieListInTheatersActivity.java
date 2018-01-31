package com.haocent.android.doubanmovie.ui.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieInTheatersBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 正在热映
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieListInTheatersActivity extends AppCompatActivity {

    private static final String TAG = MovieListInTheatersActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initService();

        initView();

        // 正在热映
        initMovieInTheatersData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("正在热映");
    }

    /**
     * 正在热映
     */
    private void initMovieInTheatersData() {
        Observable<MovieInTheatersBean> observable = mService.getMovieInTheaters(Constant.API_KEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieInTheatersBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieInTheatersBean movieInTheatersBean) {
                        Log.d(TAG, "onNext: ");

                        // 评分
                        String ratingAverage = String.valueOf(movieInTheatersBean.getSubjects().get(0).getRating().getAverage());
                        Log.d(TAG, "评分: " + ratingAverage);

                        // 影片类型
                        String genres = movieInTheatersBean.getSubjects().get(0).getGenres().toString();
                        String genre = genres.substring(1, genres.length() - 1);
                        Log.d(TAG, "影片类型: " + genre);

                        // 影片标题
                        String title = movieInTheatersBean.getSubjects().get(0).getTitle();
                        Log.d(TAG, "影片标题: " + title);

                        // 主演
                        String castAvatar = movieInTheatersBean.getSubjects().get(0).getCasts().get(0).getAvatars().getMedium();
                        String castNameEn = movieInTheatersBean.getSubjects().get(0).getCasts().get(0).getName_en();
                        String castName = movieInTheatersBean.getSubjects().get(0).getCasts().get(0).getName();
                        String castId = movieInTheatersBean.getSubjects().get(0).getCasts().get(0).getId();
                        Log.d(TAG, "主演头像: " + castAvatar);
                        Log.d(TAG, "主演英文名: " + castNameEn);
                        Log.d(TAG, "主演中文名: " + castName);
                        Log.d(TAG, "主演 ID: " + castId);

                        // 片长
                        String durations = movieInTheatersBean.getSubjects().get(0).getDurations().toString();
                        String duration = durations.substring(1, durations.length() - 1);
                        Log.d(TAG, "片长: " + duration);

                        // 大陆上映日期
                        String mainlandPubdate = movieInTheatersBean.getSubjects().get(0).getMainland_pubdate();
                        Log.d(TAG, "大陆上映日期: " + mainlandPubdate);

                        // 原名
                        String originalTitle = movieInTheatersBean.getSubjects().get(0).getOriginal_title();
                        Log.d(TAG, "原名: " + originalTitle);

                        // 导演
                        String directorAvatar = movieInTheatersBean.getSubjects().get(0).getDirectors().get(0).getAvatars().getMedium();
                        String directorNameEn = movieInTheatersBean.getSubjects().get(0).getDirectors().get(0).getName_en();
                        String directorName = movieInTheatersBean.getSubjects().get(0).getDirectors().get(0).getName();
                        String directorId = movieInTheatersBean.getSubjects().get(0).getDirectors().get(0).getId();
                        Log.d(TAG, "导演头像: " + directorAvatar);
                        Log.d(TAG, "导演英文名: " + directorNameEn);
                        Log.d(TAG, "导演中文名: " + directorName);
                        Log.d(TAG, "导演 ID: " + directorId);

                        // 上映日期
                        String pubdates = movieInTheatersBean.getSubjects().get(0).getPubdates().toString();
                        String pubdate = pubdates.substring(1, pubdates.length() - 1);
                        Log.d(TAG, "上映日期: " + pubdate);

                        // 年代
                        String year = movieInTheatersBean.getSubjects().get(0).getYear();
                        Log.d(TAG, "年代: " + year);

                        // 影片海报
                        String image = movieInTheatersBean.getSubjects().get(0).getImages().getMedium();
                        Log.d(TAG, "影片海报: " + image);

                        // 影片 ID
                        String id = movieInTheatersBean.getSubjects().get(0).getId();
                        Log.d(TAG, "影片 ID: " + id);
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

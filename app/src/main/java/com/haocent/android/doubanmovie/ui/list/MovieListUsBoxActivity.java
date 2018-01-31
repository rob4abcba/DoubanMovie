package com.haocent.android.doubanmovie.ui.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieUsBoxBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 北美票房榜
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieListUsBoxActivity extends AppCompatActivity {


    private static final String TAG = MovieListUsBoxActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list_content);

        initService();

        initView();

        // 北美票房榜
        initMovieUsBoxData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("北美票房榜");
    }

    /**
     * 北美票房榜
     */
    private void initMovieUsBoxData() {
        Observable<MovieUsBoxBean> observable = mService.getMovieUsBox(Constant.API_KEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieUsBoxBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieUsBoxBean movieUsBoxBean) {
                        Log.d(TAG, "onNext: ");

                        // 日期
                        String date = movieUsBoxBean.getDate();
                        Log.d(TAG, "日期: " + date);

                        // 排行
                        String rank = String.valueOf(movieUsBoxBean.getSubjects().get(0).getRank());
                        Log.d(TAG, "排行: " + rank);

                        // 评分
                        String ratingAverage = String.valueOf(movieUsBoxBean.getSubjects().get(0).getSubject().getRating().getAverage());
                        Log.d(TAG, "评分: " + ratingAverage);

                        // 影片类型
                        String genres = movieUsBoxBean.getSubjects().get(0).getSubject().getGenres().toString();
                        String genre = genres.substring(1, genres.length() - 1);
                        Log.d(TAG, "影片类型: " + genre);

                        // 影片标题
                        String title = movieUsBoxBean.getSubjects().get(0).getSubject().getTitle();
                        Log.d(TAG, "影片标题: " + title);

                        // 主演
                        String castAvatar = movieUsBoxBean.getSubjects().get(0).getSubject().getCasts().get(0).getAvatars().getMedium();
                        String castNameEn = movieUsBoxBean.getSubjects().get(0).getSubject().getCasts().get(0).getName_en();
                        String castName = movieUsBoxBean.getSubjects().get(0).getSubject().getCasts().get(0).getName();
                        String castId = movieUsBoxBean.getSubjects().get(0).getSubject().getCasts().get(0).getId();
                        Log.d(TAG, "主演头像: " + castAvatar);
                        Log.d(TAG, "主演英文名: " + castNameEn);
                        Log.d(TAG, "主演中文名: " + castName);
                        Log.d(TAG, "主演 ID: " + castId);

                        // 片长
                        String durations = movieUsBoxBean.getSubjects().get(0).getSubject().getDurations().toString();
                        String duration = durations.substring(1, durations.length() - 1);
                        Log.d(TAG, "片长: " + duration);

                        // 大陆上映日期
                        String mainlandPubdate = movieUsBoxBean.getSubjects().get(0).getSubject().getMainland_pubdate();
                        Log.d(TAG, "大陆上映日期: " + mainlandPubdate);

                        // 原名
                        String originalTitle = movieUsBoxBean.getSubjects().get(0).getSubject().getOriginal_title();
                        Log.d(TAG, "原名: " + originalTitle);

                        // 导演
                        String directorAvatar = movieUsBoxBean.getSubjects().get(0).getSubject().getDirectors().get(0).getAvatars().getMedium();
                        String directorNameEn = movieUsBoxBean.getSubjects().get(0).getSubject().getDirectors().get(0).getName_en();
                        String directorName = movieUsBoxBean.getSubjects().get(0).getSubject().getDirectors().get(0).getName();
                        String directorId = movieUsBoxBean.getSubjects().get(0).getSubject().getDirectors().get(0).getId();
                        Log.d(TAG, "导演头像: " + directorAvatar);
                        Log.d(TAG, "导演英文名: " + directorNameEn);
                        Log.d(TAG, "导演中文名: " + directorName);
                        Log.d(TAG, "导演 ID: " + directorId);

                        // 上映日期
                        String pubdates = movieUsBoxBean.getSubjects().get(0).getSubject().getPubdates().toString();
                        String pubdate = pubdates.substring(1, pubdates.length() - 1);
                        Log.d(TAG, "上映日期: " + pubdate);

                        // 年代
                        String year = movieUsBoxBean.getSubjects().get(0).getSubject().getYear();
                        Log.d(TAG, "年代: " + year);

                        // 影片海报
                        String image = movieUsBoxBean.getSubjects().get(0).getSubject().getImages().getMedium();
                        Log.d(TAG, "影片海报: " + image);

                        // 影片 ID
                        String id = movieUsBoxBean.getSubjects().get(0).getSubject().getId();
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

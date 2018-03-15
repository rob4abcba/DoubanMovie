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

                        // 评分
                        String ratingAverage = String.valueOf(movieSearchByQueryBean.getSubjects().get(0).getRating().getAverage());
                        Log.d(TAG, "评分: " + ratingAverage);

                        // 影片类型
                        String genres = movieSearchByQueryBean.getSubjects().get(0).getGenres().toString();
                        String genre = genres.substring(1, genres.length() - 1);
                        Log.d(TAG, "影片类型: " + genre);

                        // 影片标题
                        String title = movieSearchByQueryBean.getSubjects().get(0).getTitle();
                        Log.d(TAG, "影片标题: " + title);

                        // 主演
                        String castAvatar = movieSearchByQueryBean.getSubjects().get(0).getCasts().get(0).getAvatars().getMedium();
                        String castNameEn = movieSearchByQueryBean.getSubjects().get(0).getCasts().get(0).getName_en();
                        String castName = movieSearchByQueryBean.getSubjects().get(0).getCasts().get(0).getName();
                        String castId = movieSearchByQueryBean.getSubjects().get(0).getCasts().get(0).getId();
                        Log.d(TAG, "主演头像: " + castAvatar);
                        Log.d(TAG, "主演英文名: " + castNameEn);
                        Log.d(TAG, "主演中文名: " + castName);
                        Log.d(TAG, "主演 ID: " + castId);

                        // 片长
                        String durations = movieSearchByQueryBean.getSubjects().get(0).getDurations().toString();
                        String duration = durations.substring(1, durations.length() - 1);
                        Log.d(TAG, "片长: " + duration);

                        // 大陆上映日期
                        String mainlandPubdate = movieSearchByQueryBean.getSubjects().get(0).getMainland_pubdate();
                        Log.d(TAG, "大陆上映日期: " + mainlandPubdate);

                        // 原名
                        String originalTitle = movieSearchByQueryBean.getSubjects().get(0).getOriginal_title();
                        Log.d(TAG, "原名: " + originalTitle);

                        // 类型
                        String subtype = movieSearchByQueryBean.getSubjects().get(0).getSubtype();
                        Log.d(TAG, "类型: " + subtype);

                        // 导演
                        String directorNameEn = movieSearchByQueryBean.getSubjects().get(0).getDirectors().get(0).getName_en();
                        String directorName = movieSearchByQueryBean.getSubjects().get(0).getDirectors().get(0).getName();
                        Log.d(TAG, "导演英文名: " + directorNameEn);
                        Log.d(TAG, "导演中文名: " + directorName);

                        // 上映日期
                        String pubdates = movieSearchByQueryBean.getSubjects().get(0).getPubdates().toString();
                        String pubdate = pubdates.substring(1, pubdates.length() - 1);
                        Log.d(TAG, "上映日期: " + pubdate);

                        // 年代
                        String year = movieSearchByQueryBean.getSubjects().get(0).getYear();
                        Log.d(TAG, "年代: " + year);

                        // 影片海报
                        String image = movieSearchByQueryBean.getSubjects().get(0).getImages().getMedium();
                        Log.d(TAG, "影片海报: " + image);

                        // 影片 ID
                        String id = movieSearchByQueryBean.getSubjects().get(0).getId();
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

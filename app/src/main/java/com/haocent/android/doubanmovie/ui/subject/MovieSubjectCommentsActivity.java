package com.haocent.android.doubanmovie.ui.subject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieSubjectCommentsBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 电影条目短评
 *
 * Created by Tnno Wu on 2018/1/30.
 */

public class MovieSubjectCommentsActivity extends AppCompatActivity {

    private static final String TAG = MovieSubjectCommentsActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_subject_content);

        initService();

        initView();

        // 电影条目短评
        initMovieSubjectCommentsData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("电影条目短评");
    }

    /**
     * 电影条目短评
     */
    private void initMovieSubjectCommentsData() {
        Observable<MovieSubjectCommentsBean> observable = mService.getMovieSubjectComments(
                Constant.MOVIE_ID,
                Constant.API_KEY
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieSubjectCommentsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieSubjectCommentsBean movieSubjectCommentsBean) {
                        Log.d(TAG, "onNext: ");

                        // 用户评论
                        String ratingValue = String.valueOf(movieSubjectCommentsBean.getComments().get(0).getRating().getValue());
                        String ratingAuthorName = movieSubjectCommentsBean.getComments().get(0).getAuthor().getName();
                        String ratingContent = movieSubjectCommentsBean.getComments().get(0).getContent();
                        Log.d(TAG, "评分: " + ratingValue);
                        Log.d(TAG, "用户名: " + ratingAuthorName);
                        Log.d(TAG, "评论内容: " + ratingContent);

                        // 影片评分
                        String average = String.valueOf(movieSubjectCommentsBean.getSubject().getRating().getAverage());
                        Log.d(TAG, "影片评分: " + average);

                        // 影片类型
                        String genres = movieSubjectCommentsBean.getSubject().getGenres().toString();
                        String genre = genres.substring(1, genres.length() - 1);
                        Log.d(TAG, "影片类型: " + genre);

                        // 影片标题
                        String title = movieSubjectCommentsBean.getSubject().getTitle();
                        Log.d(TAG, "影片标题: " + title);

                        // 主演
                        String castAvatar = movieSubjectCommentsBean.getSubject().getCasts().get(0).getAvatars().getMedium();
                        String castNameEn = movieSubjectCommentsBean.getSubject().getCasts().get(0).getName_en();
                        String castName = movieSubjectCommentsBean.getSubject().getCasts().get(0).getName();
                        String castId = movieSubjectCommentsBean.getSubject().getCasts().get(0).getId();
                        Log.d(TAG, "主演头像: " + castAvatar);
                        Log.d(TAG, "主演英文名: " + castNameEn);
                        Log.d(TAG, "主演中文名: " + castName);
                        Log.d(TAG, "主演 ID: " + castId);

                        // 片长
                        String durations = movieSubjectCommentsBean.getSubject().getDurations().toString();
                        String duration = durations.substring(1, durations.length() - 1);
                        Log.d(TAG, "片长: " + duration);

                        // 大陆上映日期
                        String mainlandPubdate = movieSubjectCommentsBean.getSubject().getMainland_pubdate();
                        Log.d(TAG, "大陆上映日期: " + mainlandPubdate);

                        // 原名
                        String originalTitle = movieSubjectCommentsBean.getSubject().getOriginal_title();
                        Log.d(TAG, "原名: " + originalTitle);

                        // 导演
                        String directorAvatar = movieSubjectCommentsBean.getSubject().getDirectors().get(0).getAvatars().getMedium();
                        String directorNameEn = movieSubjectCommentsBean.getSubject().getDirectors().get(0).getName_en();
                        String directorName = movieSubjectCommentsBean.getSubject().getDirectors().get(0).getName();
                        String directorId = movieSubjectCommentsBean.getSubject().getDirectors().get(0).getId();
                        Log.d(TAG, "导演头像: " + directorAvatar);
                        Log.d(TAG, "导演英文名: " + directorNameEn);
                        Log.d(TAG, "导演中文名: " + directorName);
                        Log.d(TAG, "导演 ID: " + directorId);

                        // 上映日期
                        String pubdates = movieSubjectCommentsBean.getSubject().getPubdates().toString();
                        String pubdate = pubdates.substring(1, pubdates.length() - 1);
                        Log.d(TAG, "上映日期: " + pubdate);

                        // 年代
                        String year = movieSubjectCommentsBean.getSubject().getYear();
                        Log.d(TAG, "年代: " + year);

                        // 影片海报
                        String image = movieSubjectCommentsBean.getSubject().getImages().getMedium();
                        Log.d(TAG, "影片海报: " + image);

                        // 影片 ID
                        String id = movieSubjectCommentsBean.getSubject().getId();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

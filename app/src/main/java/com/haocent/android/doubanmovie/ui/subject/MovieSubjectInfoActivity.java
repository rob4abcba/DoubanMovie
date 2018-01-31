package com.haocent.android.doubanmovie.ui.subject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieSubjectInfoBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 电影条目信息
 *
 * Created by Tnno Wu on 2018/01/30.
 */

public class MovieSubjectInfoActivity extends AppCompatActivity {

    private static final String TAG = MovieSubjectInfoActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_subject_content);

        initService();

        initView();

        initMovieSubjectInfoData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("电影条目信息");
    }

    /**
     * 电影条目信息
     */
    private void initMovieSubjectInfoData() {
        Observable<MovieSubjectInfoBean> observable = mService.getMovieSubjectInfo(
                Constant.MOVIE_ID,
                Constant.API_KEY
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieSubjectInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieSubjectInfoBean movieSubjectInfoBean) {
                        Log.d(TAG, "onNext: ");

                        // 评分
                        String average = String.valueOf(movieSubjectInfoBean.getRating().getAverage());
                        Log.d(TAG, "评分: " + average);

                        // 原名
                        String originalTitle = movieSubjectInfoBean.getOriginal_title();
                        Log.d(TAG, "原名: " + originalTitle);

                        // 电影海报
                        String image = movieSubjectInfoBean.getImages().getMedium();
                        Log.d(TAG, "电影海报: " + image);

                        // 年代
                        String year = movieSubjectInfoBean.getYear();
                        Log.d(TAG, "年代: " + year);

                        // 短评
                        String commentValue = String.valueOf(movieSubjectInfoBean.getPopular_comments().get(0).getRating().getValue());    // 短评评分
                        String commentAuthorName = movieSubjectInfoBean.getPopular_comments().get(0).getAuthor().getName();                // 短评用户名
                        String commentContent = movieSubjectInfoBean.getPopular_comments().get(0).getContent();                            // 短评内容
                        Log.d(TAG, "短评评分: " + commentValue);
                        Log.d(TAG, "短评用户名: " + commentAuthorName);
                        Log.d(TAG, "短评内容: " + commentContent);

                        // 电影 ID
                        String movieId = movieSubjectInfoBean.getId();
                        Log.d(TAG, "电影 ID: " + movieId);

                        // 上映日期
                        String pubdate = movieSubjectInfoBean.getPubdate();
                        Log.d(TAG, "上映日期: " + pubdate);

                        // 电影中文名
                        String title = movieSubjectInfoBean.getTitle();
                        Log.d(TAG, "电影中文名: " + title);

                        // 语言
                        String languages = movieSubjectInfoBean.getLanguages().get(0);
                        Log.d(TAG, "语言: " + languages);

                        // 编剧
                        String writerAvatar = movieSubjectInfoBean.getWriters().get(0).getAvatars().getMedium();    // 编剧头像
                        String writerNameEn = movieSubjectInfoBean.getWriters().get(0).getName_en();                // 编剧英文名
                        String writerName = movieSubjectInfoBean.getWriters().get(0).getName();                     // 编剧中文名
                        String writerId = movieSubjectInfoBean.getWriters().get(0).getId();                         // 编剧 ID
                        Log.d(TAG, "编剧头像: " + writerAvatar);
                        Log.d(TAG, "编剧英文名: " + writerNameEn);
                        Log.d(TAG, "编剧中文名: " + writerName);
                        Log.d(TAG, "编剧 ID: " + writerId);

                        // 标签
                        String tag = movieSubjectInfoBean.getTags().get(0);
                        Log.d(TAG, "标签: " + tag);

                        // 片长
                        String durations = movieSubjectInfoBean.getDurations().toString();
                        String duration = durations.substring(1, durations.length() - 1);
                        Log.d(TAG, "片长: " + duration);

                        // 影片类型（最多提供3个）
                        String genres = movieSubjectInfoBean.getGenres().toString();
                        String genre = genres.substring(1, genres.length() - 1);
                        Log.d(TAG, "影片类型: " + genre);

                        // 预告片
                        String trailer = movieSubjectInfoBean.getTrailers().get(0).getMedium(); // 预告片图片
                        String trailerUrls = movieSubjectInfoBean.getTrailer_urls().get(0);     // 预告片影片
                        Log.d(TAG, "预告片图片: " + trailer);
                        Log.d(TAG, "预告片影片: " + trailerUrls);

                        // 花絮
                        String blooper = movieSubjectInfoBean.getBloopers().get(0).getMedium(); // 花絮图片
                        String blooperUrls = movieSubjectInfoBean.getBlooper_urls().get(0);     // 花絮影片（最多提供4个）
                        Log.d(TAG, "花絮图片: " + blooper);
                        Log.d(TAG, "花絮影片: " + blooperUrls);

                        // 片段
                        String clip = movieSubjectInfoBean.getClips().get(0).getMedium();       // 片段图片
                        String clipUrls = movieSubjectInfoBean.getClip_urls().get(0);           // 片段影片
                        Log.d(TAG, "片段图片: " + clip);
                        Log.d(TAG, "片段影片: " + clipUrls);

                        // 主演
                        String castAvatar = movieSubjectInfoBean.getCasts().get(0).getAvatars().getMedium();    // 主演头像
                        String castNameEn = movieSubjectInfoBean.getCasts().get(0).getName_en();                // 主演英文名
                        String castName = movieSubjectInfoBean.getCasts().get(0).getName();                     // 主演中文名
                        String castId = movieSubjectInfoBean.getCasts().get(0).getId();                         // 主演 ID
                        Log.d(TAG, "主演头像: " + castAvatar);
                        Log.d(TAG, "主演英文名: " + castNameEn);
                        Log.d(TAG, "主演中文名: " + castName);
                        Log.d(TAG, "主演 ID: " + castId);

                        // 制片国家/地区
                        String country = movieSubjectInfoBean.getCountries().get(0);
                        Log.d(TAG, "制片国家/地区: " + country);

                        // 大陆上映日期
                        String mainlandPubdate = movieSubjectInfoBean.getMainland_pubdate();
                        Log.d(TAG, "大陆上映日期: " + mainlandPubdate);

                        // 电影剧照
                        String photoImage = movieSubjectInfoBean.getPhotos().get(0).getImage();
                        Log.d(TAG, "电影剧照: " + photoImage);

                        // 简介
                        String summary = movieSubjectInfoBean.getSummary();
                        Log.d(TAG, "简介: " + summary);

                        // 导演
                        String directorAvatar = movieSubjectInfoBean.getDirectors().get(0).getAvatars().getMedium();    // 导演头像
                        String directorNameEn = movieSubjectInfoBean.getDirectors().get(0).getName_en();                // 导演英文名
                        String directorName = movieSubjectInfoBean.getDirectors().get(0).getName();                     // 导演中文名
                        String directorId = movieSubjectInfoBean.getDirectors().get(0).getId();                         // 导演 ID
                        Log.d(TAG, "导演头像: " + directorAvatar);
                        Log.d(TAG, "导演英文名: " + directorNameEn);
                        Log.d(TAG, "导演中文名: " + directorName);
                        Log.d(TAG, "导演 ID: " + directorId);

                        // 影评
                        String reviewValue = String.valueOf(movieSubjectInfoBean.getPopular_reviews().get(0).getRating().getValue());   // 影评评分
                        String reviewTitle = movieSubjectInfoBean.getPopular_reviews().get(0).getTitle();                               // 影评标题
                        String reviewAuthorName = movieSubjectInfoBean.getPopular_reviews().get(0).getAuthor().getName();               // 影评用户名
                        String reviewSummary = movieSubjectInfoBean.getPopular_reviews().get(0).getSummary();                           // 影评内容
                        Log.d(TAG, "影评评分: " + reviewValue);
                        Log.d(TAG, "影评标题: " + reviewTitle);
                        Log.d(TAG, "影评用户名: " + reviewAuthorName);
                        Log.d(TAG, "影评内容: " + reviewSummary);
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

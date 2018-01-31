package com.haocent.android.doubanmovie.ui.subject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieSubjectPhotosBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 电影条目剧照
 *
 * Created by Tnno Wu on 2018/01/30.
 */

public class MovieSubjectPhotosActivity extends AppCompatActivity {

    private static final String TAG = MovieSubjectPhotosActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_subject_content);

        initService();

        initView();

        // 电影条目剧照
        initMovieSubjectPhotosData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("电影条目剧照");
    }

    /**
     * 电影条目剧照
     */
    private void initMovieSubjectPhotosData() {
        Observable<MovieSubjectPhotosBean> observable = mService.getMovieSubjectPhotos(
                Constant.MOVIE_ID,
                Constant.API_KEY
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieSubjectPhotosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieSubjectPhotosBean movieSubjectPhotoBean) {
                        Log.d(TAG, "onNext: ");

                        // 电影剧照
                        String photoImage = movieSubjectPhotoBean.getPhotos().get(0).getImage();
                        Log.d(TAG, "电影剧照: " + photoImage);

                        // 评分
                        String average = String.valueOf(movieSubjectPhotoBean.getSubject().getRating().getAverage());
                        Log.d(TAG, "评分: " + average);

                        // 影片类型
                        String genres = movieSubjectPhotoBean.getSubject().getGenres().toString();
                        String genre = genres.substring(1, genres.length() - 1);
                        Log.d(TAG, "影片类型: " + genre);

                        // 影片标题
                        String title = movieSubjectPhotoBean.getSubject().getTitle();
                        Log.d(TAG, "影片标题: " + title);

                        // 主演
                        String castAvatar = movieSubjectPhotoBean.getSubject().getCasts().get(0).getAvatars().getMedium();
                        String castNameEn = movieSubjectPhotoBean.getSubject().getCasts().get(0).getName_en();
                        String castName = movieSubjectPhotoBean.getSubject().getCasts().get(0).getName();
                        String castId = movieSubjectPhotoBean.getSubject().getCasts().get(0).getId();
                        Log.d(TAG, "主演头像: " + castAvatar);
                        Log.d(TAG, "主演英文名: " + castNameEn);
                        Log.d(TAG, "主演中文名: " + castName);
                        Log.d(TAG, "主演 ID: " + castId);

                        // 片长
                        String durations = String.valueOf(movieSubjectPhotoBean.getSubject().getDurations());
                        String duration = durations.substring(1, durations.length() - 1);
                        Log.d(TAG, "片长: " + duration);

                        // 大陆上映日期
                        String mainlandPubdate = movieSubjectPhotoBean.getSubject().getMainland_pubdate();
                        Log.d(TAG, "大陆上映日期: " + mainlandPubdate);

                        // 原名
                        String originalTitle = movieSubjectPhotoBean.getSubject().getOriginal_title();
                        Log.d(TAG, "原名: " + originalTitle);

                        // 导演
                        String directorAvatar = movieSubjectPhotoBean.getSubject().getDirectors().get(0).getAvatars().getMedium();
                        String directorNameEn = movieSubjectPhotoBean.getSubject().getDirectors().get(0).getName_en();
                        String directorName = movieSubjectPhotoBean.getSubject().getDirectors().get(0).getName();
                        String directorId = movieSubjectPhotoBean.getSubject().getDirectors().get(0).getId();
                        Log.d(TAG, "导演头像: " + directorAvatar);
                        Log.d(TAG, "导演英文名: " + directorNameEn);
                        Log.d(TAG, "导演中文名: " + directorName);
                        Log.d(TAG, "导演 ID: " + directorId);

                        // 上映日期
                        String pubdates = movieSubjectPhotoBean.getSubject().getPubdates().toString();
                        String pubdate = pubdates.substring(1, pubdates.length() - 1);
                        Log.d(TAG, "onNext: " + pubdate);

                        // 年代
                        String year = movieSubjectPhotoBean.getSubject().getYear();
                        Log.d(TAG, "年代: " + year);

                        // 电影海报
                        String image = movieSubjectPhotoBean.getSubject().getImages().getMedium();
                        Log.d(TAG, "电影海报: " + image);

                        // 电影 ID
                        String id = movieSubjectPhotoBean.getSubject().getId();
                        Log.d(TAG, "电影 ID: " + id);
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

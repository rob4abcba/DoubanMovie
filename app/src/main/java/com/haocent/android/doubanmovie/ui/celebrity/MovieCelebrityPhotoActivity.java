package com.haocent.android.doubanmovie.ui.celebrity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieCelebrityPhotosBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 影人剧照
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieCelebrityPhotoActivity extends AppCompatActivity {

    private static final String TAG = MovieCelebrityPhotoActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_celebrity_content);

        initService();

        initView();

        // 影人剧照
        initMovieCelebrityPhotosData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("影人剧照");
    }

    /**
     * 影人剧照
     */
    private void initMovieCelebrityPhotosData() {
        Observable<MovieCelebrityPhotosBean> observable = mService.getMovieCelebrityPhotos(
                Constant.CELEBRITY_ID,
                Constant.API_KEY
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieCelebrityPhotosBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieCelebrityPhotosBean movieCelebrityPhotosBean) {
                        Log.d(TAG, "onNext: ");

                        String photoImage = movieCelebrityPhotosBean.getPhotos().get(0).getImage();
                        Log.d(TAG, "影人剧照: " + photoImage);

                        String celebrityAvatar = movieCelebrityPhotosBean.getCelebrity().getAvatars().getMedium();
                        String celebrityNameEn = movieCelebrityPhotosBean.getCelebrity().getName_en();
                        String celebrityName = movieCelebrityPhotosBean.getCelebrity().getName();
                        String celebrityId = movieCelebrityPhotosBean.getCelebrity().getId();
                        Log.d(TAG, "影人头像: " + celebrityAvatar);
                        Log.d(TAG, "影人英文名: " + celebrityNameEn);
                        Log.d(TAG, "影人中文名: " + celebrityName);
                        Log.d(TAG, "影人 ID: " + celebrityId);
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

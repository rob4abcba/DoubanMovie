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

                        String workRoles = movieCelebrityWorksBean.getWorks().get(0).getRoles().toString();
                        String workRole = workRoles.substring(1, workRoles.length() - 1);
                        String workAverage = String.valueOf(movieCelebrityWorksBean.getWorks().get(0).getSubject().getRating().getAverage());
                        String workGenres = movieCelebrityWorksBean.getWorks().get(0).getSubject().getGenres().toString();
                        String workGenre = workGenres.substring(1, workGenres.length() - 1);
                        String workTitle = movieCelebrityWorksBean.getWorks().get(0).getSubject().getTitle();
                        String workCastAvatar = movieCelebrityWorksBean.getWorks().get(0).getSubject().getCasts().get(0).getAvatars().getMedium();
                        String workCastNameEn = movieCelebrityWorksBean.getWorks().get(0).getSubject().getCasts().get(0).getName_en();
                        String workCastName = movieCelebrityWorksBean.getWorks().get(0).getSubject().getCasts().get(0).getName();
                        String workCastId = movieCelebrityWorksBean.getWorks().get(0).getSubject().getCasts().get(0).getId();
                        String workDurations = movieCelebrityWorksBean.getWorks().get(0).getSubject().getDurations().toString();
                        String workDuration = workDurations.substring(1, workDurations.length() - 1);
                        String workMainlandPubdate = movieCelebrityWorksBean.getWorks().get(0).getSubject().getMainland_pubdate();
                        String workOriginalTitle = movieCelebrityWorksBean.getWorks().get(0).getSubject().getOriginal_title();
                        String workSubtype = movieCelebrityWorksBean.getWorks().get(0).getSubject().getSubtype();
                        String workPubdates = movieCelebrityWorksBean.getWorks().get(0).getSubject().getPubdates().toString();
                        String workPubdate = workPubdates.substring(1, workPubdates.length() - 1);
                        String workYear = movieCelebrityWorksBean.getWorks().get(0).getSubject().getYear();
                        String workImage = movieCelebrityWorksBean.getWorks().get(0).getSubject().getImages().getMedium();
                        String workId = movieCelebrityWorksBean.getWorks().get(0).getSubject().getId();
                        Log.d(TAG, "作品担任角色: " + workRole);
                        Log.d(TAG, "作品评分: " + workAverage);
                        Log.d(TAG, "作品类型: " + workGenre);
                        Log.d(TAG, "作品名: " + workTitle);
                        Log.d(TAG, "作品主演头像: " + workCastAvatar);
                        Log.d(TAG, "作品主演英文名: " + workCastNameEn);
                        Log.d(TAG, "作品主演中文名: " + workCastName);
                        Log.d(TAG, "作品主演 ID: " + workCastId);
                        Log.d(TAG, "作品片长: " + workDuration);
                        Log.d(TAG, "作品大陆上映日期: " + workMainlandPubdate);
                        Log.d(TAG, "作品原名: " + workOriginalTitle);
                        Log.d(TAG, "作品类别: " + workSubtype);
                        Log.d(TAG, "作品上映日期: " + workPubdate);
                        Log.d(TAG, "作品年代: " + workYear);
                        Log.d(TAG, "作品海报图: " + workImage);
                        Log.d(TAG, "作品 ID: " + workId);
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

package com.haocent.android.doubanmovie.ui.celebrity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.haocent.android.doubanmovie.R;
import com.haocent.android.doubanmovie.api.DoubanMovieService;
import com.haocent.android.doubanmovie.common.Constant;
import com.haocent.android.doubanmovie.data.MovieCelebrityInfoBean;
import com.haocent.android.doubanmovie.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 影人条目信息
 *
 * Created by Tnno Wu on 2018/01/31.
 */

public class MovieCelebrityInfoActivity extends AppCompatActivity {

    private static final String TAG = MovieCelebrityInfoActivity.class.getSimpleName();

    private DoubanMovieService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_celebrity_content);

        initService();

        initView();

        // 影人条目信息
        initMovieCelebrityInfoData();
    }

    private void initService() {
        mService = new RetrofitClient().getMovieService();
    }

    private void initView() {
        setTitle("影人条目信息");
    }

    /**
     * 影人条目信息
     */
    private void initMovieCelebrityInfoData() {
        Observable<MovieCelebrityInfoBean> observable = mService.getMovieCelebrityInfo(
                Constant.CELEBRITY_ID,
                Constant.API_KEY
        );
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieCelebrityInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(MovieCelebrityInfoBean movieCelebrityInfoBean) {
                        Log.d(TAG, "onNext: ");

                        // 中文名
                        String name = movieCelebrityInfoBean.getName();
                        Log.d(TAG, "中文名: " + name);

                        // 英文名
                        String nameEn = movieCelebrityInfoBean.getName_en();
                        Log.d(TAG, "英文名: " + nameEn);

                        // 性别
                        String gender = movieCelebrityInfoBean.getGender();
                        Log.d(TAG, "性别: " + gender);

                        // 职业
                        String professions = movieCelebrityInfoBean.getProfessions().toString();
                        String profession = professions.substring(1, professions.length() - 1);
                        Log.d(TAG, "职业: " + profession);

                        // 影人头像
                        String avatar = movieCelebrityInfoBean.getAvatars().getMedium();
                        Log.d(TAG, "影人头像: " + avatar);

                        // 简介
                        String summary = movieCelebrityInfoBean.getSummary();
                        Log.d(TAG, "简介: " + summary);

                        // 影人剧照
                        String photos = movieCelebrityInfoBean.getPhotos().get(0).getImage();
                        Log.d(TAG, "影人剧照: " + photos);

                        // 出生日期
                        String birthday = movieCelebrityInfoBean.getBirthday();
                        Log.d(TAG, "出生日期: " + birthday);

                        // 更多中文名
                        String akas = movieCelebrityInfoBean.getAka().toString();
                        String aka = akas.substring(1, akas.length() - 1);
                        Log.d(TAG, "更多中文名: " + aka);

                        // 出生地
                        String bornPlace = movieCelebrityInfoBean.getBorn_place();
                        Log.d(TAG, "出生地: " + bornPlace);

                        // 星座
                        String constellation = movieCelebrityInfoBean.getConstellation();
                        Log.d(TAG, "星座: " + constellation);

                        // 影人 ID
                        String id = movieCelebrityInfoBean.getId();
                        Log.d(TAG, "影人 ID: " + id);

                        // 影人作品
                        String workRoles = movieCelebrityInfoBean.getWorks().get(0).getRoles().toString();
                        String workRole = workRoles.substring(1, workRoles.length() - 1);
                        String workAverage = String.valueOf(movieCelebrityInfoBean.getWorks().get(0).getSubject().getRating().getAverage());
                        String workGenres = movieCelebrityInfoBean.getWorks().get(0).getSubject().getGenres().toString();
                        String workGenre = workGenres.substring(1, workGenres.length() - 1);
                        String workTitle = movieCelebrityInfoBean.getWorks().get(0).getSubject().getTitle();
                        String workCastAvatar = movieCelebrityInfoBean.getWorks().get(0).getSubject().getCasts().get(0).getAvatars().getMedium();
                        String workCastNameEn = movieCelebrityInfoBean.getWorks().get(0).getSubject().getCasts().get(0).getName_en();
                        String workCastName = movieCelebrityInfoBean.getWorks().get(0).getSubject().getCasts().get(0).getName();
                        String workCastId = movieCelebrityInfoBean.getWorks().get(0).getSubject().getCasts().get(0).getId();
                        String workDurations = movieCelebrityInfoBean.getWorks().get(0).getSubject().getDurations().toString();
                        String workDuration = workDurations.substring(1, workDurations.length() - 1);
                        String workMainlandPubdate = movieCelebrityInfoBean.getWorks().get(0).getSubject().getMainland_pubdate();
                        String workOriginalTitle = movieCelebrityInfoBean.getWorks().get(0).getSubject().getOriginal_title();
                        String workSubtype = movieCelebrityInfoBean.getWorks().get(0).getSubject().getSubtype();
                        String workDirectorAvatar = movieCelebrityInfoBean.getWorks().get(0).getSubject().getDirectors().get(0).getAvatars().getMedium();
                        String workDirectorNameEn = movieCelebrityInfoBean.getWorks().get(0).getSubject().getDirectors().get(0).getName_en();
                        String workDirectorName = movieCelebrityInfoBean.getWorks().get(0).getSubject().getDirectors().get(0).getName();
                        String workDirectorId = movieCelebrityInfoBean.getWorks().get(0).getSubject().getDirectors().get(0).getId();
                        String workPubdates = movieCelebrityInfoBean.getWorks().get(0).getSubject().getPubdates().toString();
                        String workPubdate = workPubdates.substring(1, workPubdates.length() - 1);
                        String workYear = movieCelebrityInfoBean.getWorks().get(0).getSubject().getYear();
                        String workImage = movieCelebrityInfoBean.getWorks().get(0).getSubject().getImages().getMedium();
                        String workId = movieCelebrityInfoBean.getWorks().get(0).getSubject().getId();
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
                        Log.d(TAG, "作品导演头像: " + workDirectorAvatar);
                        Log.d(TAG, "作品导演英文名: " + workDirectorNameEn);
                        Log.d(TAG, "作品导演中文名: " + workDirectorName);
                        Log.d(TAG, "作品导演 ID: " + workDirectorId);
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

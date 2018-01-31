package com.haocent.android.doubanmovie.api;

import com.haocent.android.doubanmovie.data.MovieSubjectCommentsBean;
import com.haocent.android.doubanmovie.data.MovieSubjectInfoBean;
import com.haocent.android.doubanmovie.data.MovieSubjectPhotosBean;
import com.haocent.android.doubanmovie.data.MovieSubjectReviewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 豆瓣电影 API 官方地址：https://developers.douban.com/wiki/?title=movie_v2
 *
 * Created by Tnno Wu on 2018/01/30.
 */

public interface DoubanMovieService {

    /* 电影条目 */

    /**
     * 电影条目信息
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * city：所在城市，例如北京、上海等
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：http://api.douban.com/v2/movie/subject/26004132?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：http://api.douban.com/v2/movie/subject/26004132?apikey=0b2bdeda43b5688921839c8ecb20399b&city=%E5%8C%97%E4%BA%AC&client=&udid=
     */
    @GET("subject/{movieId}")
    Observable<MovieSubjectInfoBean> getMovieSubjectInfo(@Path("movieId") String movieId,
                                                         @Query("apikey") String apikey);

    /**
     * 电影条目剧照
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/subject/26004132/photos?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/subject/26004132/photos?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=100&client=&udid=
     */
    @GET("subject/{movieId}/photos")
    Observable<MovieSubjectPhotosBean> getMovieSubjectPhotos(@Path("movieId") String movieId,
                                                             @Query("apikey") String apikey);

    /**
     * 电影条目长评
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * start：分页使用，表示第几页
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/subject/26004132/reviews?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/subject/26004132/reviews?apikey=0b2bdeda43b5688921839c8ecb20399b&start=0&count=20&client=&udid=
     */
    @GET("subject/{movieId}/reviews")
    Observable<MovieSubjectReviewsBean> getMovieSubjectReviews(@Path("movieId") String movieId,
                                                               @Query("apikey") String apikey);

    /**
     * 电影条目短评
     *
     * apikey：固定值 0b2bdeda43b5688921839c8ecb20399b
     * count：分页使用，表示数量
     * client：客户端信息。可为空
     * udid：用户 id。可为空
     *
     * 简：https://api.douban.com/v2/movie/subject/26004132/comments?apikey=0b2bdeda43b5688921839c8ecb20399b
     * 全：https://api.douban.com/v2/movie/subject/26004132/comments?apikey=0b2bdeda43b5688921839c8ecb20399b&count=20&client=&udid=
     */
    @GET("subject/{movieId}/comments")
    Observable<MovieSubjectCommentsBean> getMovieSubjectComments(@Path("movieId") String movieId,
                                                                 @Query("apikey") String apikey);
}

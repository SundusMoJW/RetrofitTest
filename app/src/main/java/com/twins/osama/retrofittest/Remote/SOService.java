package com.twins.osama.retrofittest.Remote;

import com.twins.osama.retrofittest.Models.Response;
import com.twins.osama.retrofittest.Models.WorcipeAppItem;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Osama on 10/5/2017.
 */

public interface SOService {
    //    @GET("api.php?cat_id=1")
    @GET("api.php")
    Call<Response> getAnswers();
    @GET("api.php")
    Call<WorcipeAppItem> getAnswersWorcipeAppItem();
}

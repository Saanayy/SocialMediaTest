package com.saanayy.socialmediatest.Utilities;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface2 {
    @GET("{uid}/")
    Call<String> userDetails(@Path("uid") String uid, @Query("fields") String fields, @Query("access_token") String at);

}

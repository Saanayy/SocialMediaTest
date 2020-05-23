package com.saanayy.socialmediatest.Utilities;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiInterface {



//    @POST("/api/register_police")
//    Call<RegistrationResult> register(@Body User user);
//
//    @POST("/api/login_police")
//    Call<LoginResult> login(@Body LoginCredential loginCredential);
//
//    @POST("/api/generate_pass")
//    Call<PassGenerationResult> createPass(@Header("x-access-tokens") String token, @Body Pass pass);
//
//    @Headers("Content-Type: application/json")
//    @GET("/api/user_passes")
//    Call<UserPassesResult> getPasses(@Header("x-access-tokens") String token);
//
//    @Headers("Content-Type: application/json")
//    @POST("/api/police/get_pass")
//    Call<SinglePassResult> getPass(@Header("x-access-tokens") String token, @Body Map<String, String> body);
//
//    @GET("/api/police/get_passes/{status}")
//    Call<UserPassesResult> getStatusPass(@Header("x-access-tokens") String token, @Path("status") int status);
//

    @FormUrlEncoded
    @POST("oauth/access_token/")
    Call<InstagramResponse> exchange(@Field("client_id") String client_id,
                          @Field("client_secret") String secret,
                          @Field("code") String code,
                          @Field("grant_type") String type,
                          @Field("redirect_uri") String redirect);



//    @GET("/api/police/get_quarantine_users/{type}")
//    Call<QuaratineUsersResult> quarantinedUsers(@Header("x-access-tokens") String token, @Path("type") int type);
//
//    @Headers("Content-Type: application/json")
//    @POST("/api/police/get_quarantine_user_report")
//    Call<QuarantineReportResult> getQuarantineReport(@Header("x-access-tokens") String token, @Body Map<String, String> body);
//
//    @Headers("Content-Type: application/json")
//    @POST("/api/police/get_quarantine_user_violation")
//    Call<QuarantineReportResult> getReprtViolation(@Header("x-access-tokens") String token, @Body Map<String, String> body);
//
//    @GET
//    Call<String> reportPicture(@Url String url);
//
//    @POST("/api/police/delete_quarantine_user")
//    Call<GeneralResult> endQuarantine(@Header("x-access-tokens") String token, @Body Map<String, String> body);
//
//    @POST("/api/police/update_quarantine_user")
//    Call<GeneralResult> extendQuarantine(@Header("x-access-tokens") String token, @Body Map<String, String> body);
//
//    @Headers("Content-Type: application/json")
//    @POST("/api/police/register_ngo")
//    Call<GeneralResult> register_ngo(@Header("x-access-tokens") String token, @Body NGO ngo);
//
//    @Headers("Content-Type: application/json")
//    @GET("/api/police/get_ngo_list")
//    Call<NGOList> get_ngo(@Header("x-access-tokens") String token);
//
//    @Headers("Content-Type: application/json")
//    @POST("/api/police/register_ngo_activity")
//    Call<GeneralResult> addNgoActivity(@Header("x-access-tokens") String token, @Body Event event);
//
//    @Headers("Content-Type: application/json")
//    @POST("/api/police/get_ngo_activities")
//    Call<NgoActivityList> getNgoActivity(@Header("x-access-tokens") String token, @Body Map<String, String> body);
//
//    @Headers("Content-Type: application/json")
//    @POST("/api/police/add_state_quarantine_address")
//    Call<GeneralResult> addAddress(@Header("x-access-tokens") String token, @Body Map<String, String> body);
//
//    @GET("/api/items")
//    Call<List<Item>> getItems(@QueryMap Map<String, String> map);
//
//    @GET("/api/employee/{email}")
//    Call<Employee> getEmployee(@Path("email") String email);
//
//    @POST("/api/employee/register")
//    Call<Employee> postEmployee(@Body Employee employee);
//
//    @GET("/api/employee/resendPasscode/{email}")
//    Call<String> getResend(@Path("email") String email);
//
//    @PUT("/api/items")
//    Call<Item> updateItem(@Body Item item);


}

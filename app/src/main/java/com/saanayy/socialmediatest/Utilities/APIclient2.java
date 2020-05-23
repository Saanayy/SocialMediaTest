package com.saanayy.socialmediatest.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIclient2 {
    //  use this url for the deployed url
    //  public static final String BASE_URL = "http://202.56.13.210:5000/";


    //  use this url for the deployed url
//    public static final String BASE_URL = "http://192.168.43.114:5000/";
//    public static final String BASE_URL = "https://saanayy-token-gen.herokuapp.com/";
//    public static final String BASE_URL = "http://13.127.163.197:5000/";

    //    use this url when the IP is static. Sanay
    public static final String BASE_URL = "https://graph.instagram.com/";



//        use this url when the IP is static. Suraj
//      public static final String BASE_URL = "http://192.168.43.193:5000/";

    //    This is the singleton pattern for declaring the instance of retrofit.
    public static Retrofit retrofit = null;


    public static Retrofit getApiClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(builder.build())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

}

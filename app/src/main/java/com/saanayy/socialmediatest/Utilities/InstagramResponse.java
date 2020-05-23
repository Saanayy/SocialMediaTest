
package com.saanayy.socialmediatest.Utilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InstagramResponse {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("user_id")
    @Expose
    private String userId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InstagramResponse() {
    }

    /**
     * 
     * @param accessToken
     * @param userId
     */
    public InstagramResponse(String accessToken, String userId) {
        super();
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



}

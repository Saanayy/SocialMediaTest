package com.saanayy.socialmediatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RedirectActivity extends AppCompatActivity {
    String url = "https://api.instagram.com/oauth/authorize?client_id=2352074551562548&redirect_uri=https://www.ojamapp.com/&scope=user_profile&response_type=code";
    String TAG = "redirect";
    static InstagramAuthListener listener;

    public static void getMainContext(InstagramAuthListener context){
        listener = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new InstaWebClient());
    }

    private class InstaWebClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            if (url.startsWith("https://www.ojamapp.com/")) {
//                return true;
//            }
//            return false;
//        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (url.contains("code=")) {
//                Uri uri = Uri.EMPTY.parse(url);
////                String access_token = uri.getEncodedFragment();
//                String access_token = uri;
                String access_token = url.substring(url.lastIndexOf("=") +1 );
                access_token = access_token.substring(0, access_token.length()-2);
                listener.onAuthRecived(access_token);
                Log.d(TAG, "onPageFinished: "+access_token);
                finish();
            }
            Log.d(TAG, "onPageFinished: outside if"+url);
        }


    }
}

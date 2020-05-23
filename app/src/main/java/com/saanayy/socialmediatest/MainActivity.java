package com.saanayy.socialmediatest;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.saanayy.socialmediatest.Utilities.APIClient;
import com.saanayy.socialmediatest.Utilities.APIclient2;
import com.saanayy.socialmediatest.Utilities.ApiInterface;
import com.saanayy.socialmediatest.Utilities.ApiInterface2;
import com.saanayy.socialmediatest.Utilities.InstagramResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements InstagramAuthListener {

    @BindView(R.id.insta)
    Button insta;
    String TAG = "main";
    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate: " + printKeyHash(this));
        Toast.makeText(this, "" + printKeyHash(this), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.insta)
    public void onViewClicked() {
        Intent intent = new Intent(MainActivity.this, RedirectActivity.class);
        startActivity(intent);
        RedirectActivity.getMainContext(this);
    }

    public static String printKeyHash(Activity context) {
        PackageInfo packageInfo;
        String key = null;
        try {
            //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();

            //Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                // String key = new String(Base64.encodeBytes(md.digest()));
                Log.e("Key Hash=", key);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }

    @Override
    public void onAuthRecived(String auth_token) {
        ApiInterface api = APIClient.getApiClient().create(ApiInterface.class);
//        Map<String, String> m = new HashMap<>();
//        m.put("client_id","2352074551562548");
//        m.put("client_secret","cbd028e24a9d58dbbe4f966f428246ea");
//        m.put("code",auth_token);
//        m.put("grant_type","authorization_code");
//        m.put("redirect_uri", "https://www.ojamapp.com/");

        Call<InstagramResponse> call = api.exchange("2352074551562548", "cbd028e24a9d58dbbe4f966f428246ea", auth_token, "authorization_code", "https://www.ojamapp.com/");
        call.enqueue(new Callback<InstagramResponse>() {
            @Override
            public void onResponse(Call<InstagramResponse> call, Response<InstagramResponse> response) {
                Log.d(TAG, "onResponse: " + response.body());
                if (response.code() == 200) {
                    InstagramResponse ir = response.body();
                    Log.d(TAG, "onResponse: " + ir.getUserId() + "   " + ir.getAccessToken());

                    makerequest2(ir);

                    Toast.makeText(MainActivity.this, "" + ir.getUserId(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InstagramResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void makerequest2(InstagramResponse ir) {
        ApiInterface2 ap2 = APIclient2.getApiClient().create(ApiInterface2.class);
        Call<String> call = ap2.userDetails(ir.getUserId(), "id,username", ir.getAccessToken());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse: " + response.body());
                text.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }
}

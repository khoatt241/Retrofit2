package com.example.retrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient okHttpClient =  new OkHttpClient.Builder() //set up cho client, request chặt chẽ hơn
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        // 1 : Khởi tạo retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.1.138:80/") // đường dẫn gốc, địa chỉ ipv4
                .client(okHttpClient)
                .build();

        // 2 : Khởi tạo interface request

        // 3 : Nhận giá trị qua callback



    }
}

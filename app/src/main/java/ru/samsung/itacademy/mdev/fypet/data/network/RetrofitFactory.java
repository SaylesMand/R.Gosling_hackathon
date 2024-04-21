package ru.samsung.itacademy.mdev.fypet.data.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.samsung.itacademy.mdev.fypet.data.source.CredentialsDataSource;
import ru.samsung.itacademy.mdev.fypet.data.source.UserApi;
import ru.samsung.itacademy.mdev.fypet.data.source.FormApi;
import ru.samsung.itacademy.mdev.fypet.data.source.CommentApi;

public class RetrofitFactory {
    private static RetrofitFactory INSTANCE;

    private RetrofitFactory() {
    }

    public static synchronized RetrofitFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitFactory();
        }
        return INSTANCE;
    }

    private final OkHttpClient.Builder client = new OkHttpClient.Builder()
            .addInterceptor(chain -> {
                        String authData = CredentialsDataSource.getInstance().getAuthData();
                        if (authData == null) {
                            return chain.proceed(chain.request());
                        } else {
                            Request request = chain.request()
                                    .newBuilder()
                                    .addHeader("Authorization", authData)
                                    .build();
                            return chain.proceed(request);
                        }

                    }
            );

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public UserApi getUserApi() {
        return retrofit.create(UserApi.class);
    }
    public FormApi getFormApi() {

        return retrofit.create(FormApi.class);
    }
    public CommentApi getCommentApi() {

        return retrofit.create(CommentApi.class);
    }
}

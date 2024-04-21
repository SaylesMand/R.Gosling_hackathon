package ru.samsung.itacademy.mdev.fypet.data.source;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.samsung.itacademy.mdev.fypet.data.dto.FormDto;
import ru.samsung.itacademy.mdev.fypet.data.dto.FormPostDto;


public interface FormApi {
    @GET("form/{id}")
    Call<FormDto> getById(@Path("id") String id);

    @POST("form/post")
    Call<Void> createForm(@Body FormPostDto dto);
}

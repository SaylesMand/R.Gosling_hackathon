package ru.samsung.itacademy.mdev.fypet.data.source;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.samsung.itacademy.mdev.fypet.data.dto.FormDto;


public interface FormApi {
    @GET("form/{id}")
    Call<FormDto> getById(@Path("id") String id);
}

package ru.samsung.itacademy.mdev.fypet.data.dto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class UserDto {
    @NonNull
    @SerializedName("id")
    public String id;
    @NonNull
    @SerializedName("name")
    public String name;
    @NonNull
    @SerializedName("surname")
    public String surname;
//    @NonNull
//    @SerializedName("password")
//    public String password;
    @Nullable
    @SerializedName("email")
    public String email;
    @Nullable
    @SerializedName("phone")
    public String phone;
    @Nullable
    @SerializedName("address")
    public String address;
}

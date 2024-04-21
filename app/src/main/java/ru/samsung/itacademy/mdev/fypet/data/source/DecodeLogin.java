package ru.samsung.itacademy.mdev.fypet.data.source;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import okio.ByteString;

public class DecodeLogin {
    public static String decodeLogin() {
        String authData = CredentialsDataSource.getInstance().getAuthData();
        try {
            byte[] res = new String(authData.getBytes(StandardCharsets.ISO_8859_1), "ISO_8859_1").getBytes(StandardCharsets.UTF_8);
            return new String(res, StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            Log.i("DecodeLogin UnsupportedEncodingException", e.getMessage());
            return null;
        } catch (NullPointerException e) {
            return null;
        }

    }
}

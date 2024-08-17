package com.aplicacion.ecoinnovate;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {

    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public UserManager(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void RegisterUser(String email, String password){
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PASSWORD,password);
        editor.apply();
    }
    public boolean LoginUser(String email, String password){
        String RegisteredEmail = sharedPreferences.getString(KEY_EMAIL,null);
        String RegisteredPassword = sharedPreferences.getString(KEY_PASSWORD,null);
    return email.equals(RegisteredEmail) && password.equals(RegisteredPassword);
    }
}

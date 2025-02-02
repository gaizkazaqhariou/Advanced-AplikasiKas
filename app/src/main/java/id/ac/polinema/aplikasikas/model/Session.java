package id.ac.polinema.aplikasikas.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private static final String USERNAME_KEY = "key_username";
    private static final String TOKEN_KEY = "key_token";
    private static final String KEEP_USERNAME_KEY = "key_keep_username";

    private SharedPreferences preferences;

    public Session(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getUsername() {
        return preferences.getString(USERNAME_KEY, null);
    }

    public void setUsername(String username) {
        preferences.edit().putString(USERNAME_KEY, username)
                .apply();
    }

    public void setSession(String token) {
        preferences.edit().putString(TOKEN_KEY, token)
                .apply();
    }

    public boolean isLoggedIn() {
        String token = preferences.getString(TOKEN_KEY, null);
        return (token != null);
    }

    public boolean validate(String username, String password) {
        if (username.equals("gaizka") && password.equals("gaizka")) {
            setSession(username);
            return true;
        }
        return false;
    }

    public boolean isKeepUsername() {
        return preferences.getBoolean(KEEP_USERNAME_KEY, false);
    }

    public void logout() {
        preferences.edit().remove(TOKEN_KEY).apply();
    }
}

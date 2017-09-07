package com.wangchang.languageswitch_android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

/**
 * Created by Administrator on 2017/9/7.
 */

public class LanguageUtils {

    private static final int CHINESE = 0;
    private static final int ENGLISH = 1;
    private static final int DEFAULTS = 2;

    public static void switchLanguage(Context context, int mode) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (mode == CHINESE) {
            configuration.locale = Locale.CHINA;
        } else if (mode == ENGLISH) {
            configuration.locale = Locale.ENGLISH;
        } else if (mode == DEFAULTS) {
            configuration.locale = Locale.getDefault();
        } else {
            configuration.locale = Locale.getDefault();
        }

        resources.updateConfiguration(configuration, displayMetrics);
        SharedPreferences preferences = context.getSharedPreferences("language", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("language", mode);
        editor.apply();
    }

    public static int getLanguageMode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("language", Context.MODE_PRIVATE);
        return preferences.getInt("language", DEFAULTS);
    }

    public static Locale getLocale(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("language", Context.MODE_PRIVATE);
        int mode = preferences.getInt("language", DEFAULTS);
        if (mode == CHINESE) {
            return Locale.CHINESE;
        } else if (mode == ENGLISH) {
            return Locale.ENGLISH;
        } else if (mode == DEFAULTS) {
            return Locale.getDefault();
        } else {
            return Locale.getDefault();
        }
    }
}

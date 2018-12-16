package com.almawashi.base.mvp.model.local;

import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.almawashi.R;

import java.util.Locale;

public enum LocalLanguage {
    ARABIC("ar", R.string.label_language_arabic),
    ENGLISH("en", R.string.label_language_english);
    String id;
    int displayName;

    LocalLanguage(String id, @StringRes int displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public static LocalLanguage getLocalLanguageById(String id) {
        if (TextUtils.isEmpty(id)) {
            return LocalLanguage.ARABIC.getId()
                    .equalsIgnoreCase(Locale.getDefault().getLanguage())
                    ? LocalLanguage.ARABIC
                    : LocalLanguage.ENGLISH;
        } else if (ARABIC.getId().equalsIgnoreCase(id)) {
            return ARABIC;
        } else if (ENGLISH.getId().equalsIgnoreCase(id)) {
            return ENGLISH;
        } else {
            return ENGLISH;
        }
    }

    public String getId() {
        return id;
    }

    @StringRes
    public int getDisplayName() {
        return displayName;
    }
}

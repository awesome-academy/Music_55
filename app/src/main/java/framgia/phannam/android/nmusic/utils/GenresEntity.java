package framgia.phannam.android.nmusic.utils;

import android.support.annotation.StringDef;

@StringDef({
        GenresEntity.ALL_MUSIC,
        GenresEntity.ALL_AUDIO,
        GenresEntity.ALTERNATIVE,
        GenresEntity.AMBIENT,
        GenresEntity.CLASSICAL,
        GenresEntity.COUNTRY
})
public @interface GenresEntity {
    String ALL_MUSIC = "all-music";
    String ALL_AUDIO = "all-audio";
    String ALTERNATIVE = "alternativerock";
    String AMBIENT = "ambient";
    String CLASSICAL = "classical";
    String COUNTRY = "country";
}

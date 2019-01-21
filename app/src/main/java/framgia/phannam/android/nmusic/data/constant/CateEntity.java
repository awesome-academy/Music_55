package framgia.phannam.android.nmusic.data.constant;

import android.support.annotation.StringDef;

@StringDef({
        CateEntity.ALL_MUSIC,
        CateEntity.ALL_AUDIO,
        CateEntity.ALTERNATIVE,
        CateEntity.AMBIENT,
        CateEntity.CLASSICAL,
        CateEntity.COUNTRY
})
public @interface CateEntity {
    String ALL_MUSIC = "all-music";
    String ALL_AUDIO = "all-audio";
    String ALTERNATIVE = "alternativerock";
    String AMBIENT = "ambient";
    String CLASSICAL = "classical";
    String COUNTRY = "country";
}

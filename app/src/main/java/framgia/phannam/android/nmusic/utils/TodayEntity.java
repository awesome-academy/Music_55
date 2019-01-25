package framgia.phannam.android.nmusic.utils;

import android.support.annotation.StringDef;

@StringDef({
        TodayEntity.MUSIC_1,
        TodayEntity.MUSIC_2,
        TodayEntity.MUSIC_3,
        TodayEntity.MUSIC_4,
        TodayEntity.MUSIC_5,

})
public @interface TodayEntity {
    String MUSIC_1 = "Today_top_1";
    String MUSIC_2 = "Today_top_2";
    String MUSIC_3 = "Today_top_3";
    String MUSIC_4 = "Today_top_4";
    String MUSIC_5 = "Today_top_5";

}

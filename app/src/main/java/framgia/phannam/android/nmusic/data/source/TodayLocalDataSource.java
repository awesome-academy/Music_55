package framgia.phannam.android.nmusic.data.source;

import com.fristproject.android.music55.R;

import java.util.ArrayList;
import java.util.List;

import framgia.phannam.android.nmusic.utils.TodayEntity;
import framgia.phannam.android.nmusic.data.model.home.Today;

/**
 * Created by namp5 on 1/21/2019.
 */

public class TodayLocalDataSource implements TodayDataSource{
    @Override
    public List<Today> getToday() {
        List<Today> todays =new ArrayList<>();
        todays.add(new Today(TodayEntity.MUSIC_1, R.string.today_artists1, R.string.today_top_1,
                R.raw.today1));
        todays.add(new Today(TodayEntity.MUSIC_2, R.string.today_artists2, R.string.today_top_2,
                R.raw.today3));
        todays.add(new Today(TodayEntity.MUSIC_3, R.string.today_artists3, R.string.today_top_3,
                R.raw.today4));
        todays.add(new Today(TodayEntity.MUSIC_4, R.string.today_artists3, R.string.today_top_3,
                R.raw.today1));
        todays.add(new Today(TodayEntity.MUSIC_5, R.string.today_artists3, R.string.today_top_3,
                R.raw.today3));
        return todays;
    }
}

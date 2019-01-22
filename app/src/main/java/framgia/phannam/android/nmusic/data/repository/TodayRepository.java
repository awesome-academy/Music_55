package framgia.phannam.android.nmusic.data.repository;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Today;
import framgia.phannam.android.nmusic.data.source.TodayDataSource;

/**
 * Created by namp5 on 1/21/2019.
 */

public class TodayRepository {
    private static TodayRepository sInstance;
    private TodayDataSource mTodayLocalDataSource;

    private TodayRepository(TodayDataSource todayLocalDataSource) {
        mTodayLocalDataSource = todayLocalDataSource;
    }

    public static TodayRepository getInstance(TodayDataSource todayLocalDataSource) {
        if (sInstance == null) {
            sInstance = new TodayRepository(todayLocalDataSource);
        }
        return sInstance;
    }

    public List<Today> getTodays() {
        return mTodayLocalDataSource.getToday();
    }

}

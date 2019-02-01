package framgia.phannam.android.nmusic.utils;

import com.fristproject.android.music55.BuildConfig;

import java.util.concurrent.TimeUnit;

/**
 * Created by namp5 on 1/28/2019.
 */

public class StringUtils {
    public static String formatTrackURL(String genre, int limit, int offSet) {
        return String.format(Constants.TRACK_QUERY_FORMAT, Constants.BASE_URL,
                Constants.GENRE, genre, Constants.CLIENT_ID,
                BuildConfig.KEY_API, Constants.LIMIT, limit, Constants.OFFSET, offSet);
    }

    public static String convertMilisecondToTimer(long milliseconds) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(milliseconds) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliseconds) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));
    }
}

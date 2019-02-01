package framgia.phannam.android.nmusic.utils;

/**
 * Created by namp5 on 1/24/2019.
 */

public class Constants {
    public static final String CLIENT_ID = "client_id";
    public static final String BASE_URL = "https://api-v2.soundcloud.com/";
    public static final String GENRE = "charts?kind=top&genre=soundcloud%3Agenres%3A";
    public static final String BASE_URL_TRACK = "http://api.soundcloud.com/tracks";
    public static final String REQUEST_METHOD_GET = "GET";
    public static final String LIMIT = "limit";
    public static final String OFFSET = "offset";
    public static final String TRACK_QUERY_FORMAT = "%s%s%s&%s=%s&%s=%d&%s=%d";
    public static final String SPLASH = "/";
    public static final String QUESTION_MARK = "?";
    public static final String BREAK_LINE = "\n";
    public static final int READ_TIME_OUT = 5000;
    public static final int CONNECT_TIME_OUT = 5000;
    public static final int OFFSET_DEFAULT = 0;
    public static final int LIMIT_DEFAULT = 20;
    public static final String DB_QUERY_EQUAL_SELECTION = " %s = ? ";
    public static final String PERCENT = "%";
    public static final String DB_SORT_COLUMN_ASC = " %s ASC ";
    public static final int ITEM_SIZE = 72;
}

package framgia.phannam.android.nmusic.data.model.home;

/**
 * Created by namp5 on 1/21/2019.
 */

public class Today {
    private String mTodayName;
    private int mTodayArtists;
    private int mToday;
    private int mTodayImage;

    public Today(String todayName, int todayArtists, int today, int todayImage) {
        mTodayName = todayName;
        mTodayArtists = todayArtists;
        mToday = today;
        mTodayImage = todayImage;
    }

    public int getTodayArtists() {
        return mTodayArtists;
    }

    public void setTodayArtists(int todayArtists) {
        mTodayArtists = todayArtists;
    }

    public String getTodayName() {
        return mTodayName;
    }

    public void setTodayName(String todayName) {
        mTodayName = todayName;
    }

    public int getToday() {
        return mToday;
    }

    public void setToday(int today) {
        mToday = today;
    }

    public int getTodayImage() {
        return mTodayImage;
    }

    public void setTodayImage(int todayImage) {
        mTodayImage = todayImage;
    }
}

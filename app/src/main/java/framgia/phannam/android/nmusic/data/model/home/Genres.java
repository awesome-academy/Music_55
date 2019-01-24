package framgia.phannam.android.nmusic.data.model.home;

/**
 * Created by namp5 on 1/18/2019.
 */

public class Genres {
    private String mGenresName;
    private int mGenres;
    private int mGenresImage;

    public Genres(String cateName, int cate, int genresImage) {
        mGenresName = cateName;
        mGenres = cate;
        mGenresImage = genresImage;
    }

    public String getGenresName() {
        return mGenresName;
    }

    public void setGenresName(String genresName) {
        mGenresName = genresName;
    }

    public int getGenres() {
        return mGenres;
    }

    public void setGenres(int genres) {
        mGenres = genres;
    }

    public int getGenresImage() {
        return mGenresImage;
    }

    public void setGenresImage(int genresImage) {
        mGenresImage = genresImage;
    }
}

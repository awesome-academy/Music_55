package framgia.phannam.android.nmusic.data.repository;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Genres;
import framgia.phannam.android.nmusic.data.source.GenresDataSource;

public class GenresRepository {
    private static GenresRepository sInstance;
    private GenresDataSource mGenresLocalDataSource;

    private GenresRepository(GenresDataSource genresLocalDataSource) {
        this.mGenresLocalDataSource = genresLocalDataSource;
    }

    public static GenresRepository getInstance(GenresDataSource genresLocalDataSource) {
        if (sInstance == null) {
            sInstance = new GenresRepository(genresLocalDataSource);
        }
        return sInstance;
    }

    public List<Genres> getGenres() {
        return mGenresLocalDataSource.getGenres();
    }
}

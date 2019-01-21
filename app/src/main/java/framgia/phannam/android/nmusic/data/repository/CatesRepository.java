package framgia.phannam.android.nmusic.data.repository;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Categories;
import framgia.phannam.android.nmusic.data.source.DataSource;

public class CatesRepository {
    private static CatesRepository sInstance;
    private DataSource mLocalDataSource;

    private CatesRepository(DataSource localDataSource) {
        this.mLocalDataSource = localDataSource;
    }

    public static CatesRepository getInstance(DataSource genresLocalDataSource) {
        if (sInstance == null) {
            sInstance = new CatesRepository(genresLocalDataSource);
        }
        return sInstance;
    }

    public List<Categories> getCates() {
        return mLocalDataSource.getCates();
    }
}

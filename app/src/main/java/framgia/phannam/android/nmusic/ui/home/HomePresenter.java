package framgia.phannam.android.nmusic.ui.home;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Genres;
import framgia.phannam.android.nmusic.data.repository.GenresRepository;

/**
 * Created by namp5 on 1/17/2019.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private GenresRepository mGenresRepository;

    public HomePresenter(HomeContract.View view, GenresRepository genresRepository) {
        this.mView = view;
        mGenresRepository = genresRepository;
    }

    @Override
    public void loadGenres() {
        List<Genres> genres = mGenresRepository.getGenres();
        mView.showGenres(genres);
    }

    @Override
    public void loadSongsByGenres() {

    }
}

package framgia.phannam.android.nmusic.ui.home;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Genres;

/**
 * Created by namp5 on 1/17/2019.
 */

public class HomeContract {
    interface Presenter {
        void loadGenres();

        void loadSongsByGenres();
    }

    interface View {
        void showGenres(List<Genres> genres);

        void showSongsByGenres();
    }
}

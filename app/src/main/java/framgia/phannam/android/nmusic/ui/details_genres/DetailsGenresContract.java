package framgia.phannam.android.nmusic.ui.details_genres;

import java.util.ArrayList;

import framgia.phannam.android.nmusic.data.model.home.Track;
import framgia.phannam.android.nmusic.ui.BasePresenter;
import framgia.phannam.android.nmusic.ui.BaseView;

/**
 * Created by namp5 on 1/29/2019.
 */

public class DetailsGenresContract {
    interface Presenter extends BasePresenter {
        void loadTracks(String genre, int limit, int offset);
    }

    interface View extends BaseView<Presenter> {
        void showTrack(ArrayList<Track> tracks);

        void showNoTrackAvailable();

        void showLoadingTracksError(String error);
    }
}

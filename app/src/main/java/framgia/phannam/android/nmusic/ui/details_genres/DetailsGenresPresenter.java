package framgia.phannam.android.nmusic.ui.details_genres;

import java.util.ArrayList;
import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Track;
import framgia.phannam.android.nmusic.data.repository.TrackRepository;
import framgia.phannam.android.nmusic.data.source.TrackDataSource;

/**
 * Created by namp5 on 1/29/2019.
 */

public class DetailsGenresPresenter implements DetailsGenresContract.Presenter,
        TrackDataSource.OnFetchDataListener<Track> {
    private DetailsGenresContract.View mView;
    private TrackRepository mTrackRepository;

    public DetailsGenresPresenter(DetailsGenresContract.View view, TrackRepository trackRepository) {
        mView = view;
        mTrackRepository = trackRepository;
    }

    @Override
    public void start() {
    }

    @Override
    public void onFetchDataSuccess(List<Track> data) {
        if (data == null || data.isEmpty()) {
            mView.showNoTrackAvailable();
            return;
        }
        mView.showTrack((ArrayList<Track>) data);
    }

    @Override
    public void onFetchDataFailure(Exception e) {
        mView.showLoadingTracksError(e.getMessage());
    }

    @Override
    public void loadTracks(String genre, int limit, int offset) {
        mTrackRepository.getOnlineTracks(genre, limit, offset, this);
    }
}

package framgia.phannam.android.nmusic.data.source.remote;

import framgia.phannam.android.nmusic.data.model.home.Track;
import framgia.phannam.android.nmusic.data.source.TrackDataSource;

/**
 * Created by namp5 on 1/25/2019.
 */

public class TrackRemoteDataSource implements TrackDataSource.RemoteDataSource {
    private static TrackRemoteDataSource sInstance;

    public static TrackRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new TrackRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getOnlineTracks(String genre, int limit, int offSet,
                                TrackDataSource.OnFetchDataListener<Track> listener) {

    }

    @Override
    public void searchTracksOnline(String name, int offSet, TrackDataSource.OnFetchDataListener<Track> listener) {

    }
}

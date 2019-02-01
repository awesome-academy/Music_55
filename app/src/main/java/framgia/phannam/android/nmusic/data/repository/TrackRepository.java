package framgia.phannam.android.nmusic.data.repository;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Track;
import framgia.phannam.android.nmusic.data.source.TrackDataSource;
import framgia.phannam.android.nmusic.data.source.local.TrackLocalDataSource;
import framgia.phannam.android.nmusic.data.source.remote.TrackRemoteDataSource;

/**
 * Created by namp5 on 1/28/2019.
 */

public class TrackRepository implements TrackDataSource.LocalDataSource,
        TrackDataSource.RemoteDataSource {

    private static TrackRepository sInstance;
    private TrackDataSource.LocalDataSource mLocalDataSource;
    private TrackDataSource.RemoteDataSource mRemoteDataSource;

    private TrackRepository(TrackDataSource.LocalDataSource localDataSource,
                           TrackDataSource.RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    public static TrackRepository getInstance() {
        if (sInstance == null) {
            sInstance = new TrackRepository(TrackLocalDataSource.getInstance(),
                    TrackRemoteDataSource.getInstance());
        }
        return sInstance;
    }
    @Override
    public void getOfflineTracksInFolder(String folderName,
                                         TrackDataSource.OnFetchDataListener<Track> listener) {
        if (mLocalDataSource != null) {
            mLocalDataSource.getOfflineTracksInFolder(folderName, listener);
        }
    }

    @Override
    public void getOfflineTracks(TrackDataSource.OnFetchDataListener<Track> listener) {
        if (mLocalDataSource != null) {
            mLocalDataSource.getOfflineTracks(listener);
        }
    }

    @Override
    public boolean deleteOfflineTrack(Track track) {
        return mLocalDataSource.deleteOfflineTrack(track);
    }

    @Override
    public boolean deleteTrack(Track track) {
        return mLocalDataSource != null && mLocalDataSource.deleteTrack(track);
    }

    @Override
    public List<Track> getTracksFavorite() {
        return mLocalDataSource != null ? mLocalDataSource.getTracksFavorite() : null;
    }

    @Override
    public void getOnlineTracks(String genre, int limit, int offSet,
                                TrackDataSource.OnFetchDataListener<Track> listener) {
        if (mRemoteDataSource != null) {
            mRemoteDataSource.getOnlineTracks(genre, limit, offSet, listener);
        }
    }

    @Override
    public void searchTracksOnline(String name, int offSet, TrackDataSource.OnFetchDataListener<Track> listener) {
        if (mRemoteDataSource != null) {
            mRemoteDataSource.searchTracksOnline(name, offSet, listener);
        }
    }
}

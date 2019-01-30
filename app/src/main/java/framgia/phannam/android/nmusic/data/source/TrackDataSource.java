package framgia.phannam.android.nmusic.data.source;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Track;

/**
 * Created by namp5 on 1/25/2019.
 */

public interface TrackDataSource {
    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }

    interface RemoteDataSource {
        void getOnlineTracks(String genre, int limit, int offSet, OnFetchDataListener<Track> listener);

        void searchTracksOnline(String name, int offSet, OnFetchDataListener<Track> listener);
    }

    interface LocalDataSource {
        void getOfflineTracksInFolder(String folderName, OnFetchDataListener<Track> listener);

        void getOfflineTracks(OnFetchDataListener<Track> listener);

        boolean deleteOfflineTrack(Track track);

        boolean deleteTrack(Track track);

        List<Track> getTracksFavorite();

    }
}


package framgia.phannam.android.nmusic.ui;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Track;

public interface TrackListener {
    void onPlayTrack(int position, List<Track> tracks);

    void onAddToNowPlaying(Track track);

    void onAddToFavorite(Track track);

    void downloadTrack(Track track);

    void onAddToNextUp(Track track);

    void onRemoveTrackFromFavorite(Track track);
}

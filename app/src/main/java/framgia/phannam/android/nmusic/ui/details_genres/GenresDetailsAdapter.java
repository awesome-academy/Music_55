package framgia.phannam.android.nmusic.ui.details_genres;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fristproject.android.music55.R;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Track;
import framgia.phannam.android.nmusic.ui.TrackListener;
import framgia.phannam.android.nmusic.utils.Constants;

/**
 * Created by namp5 on 1/28/2019.
 */

public class GenresDetailsAdapter extends RecyclerView.Adapter
        <GenresDetailsAdapter.GenreDetailViewHolder> {
    private Context mContext;
    private List<Track> mTracks;
    private TrackListener mTrackListener;
    private LayoutInflater mInflater;

    public GenresDetailsAdapter(Context context, List<Track> tracks, TrackListener trackListener) {
        mContext = context;
        mTracks = tracks;
        mTrackListener = trackListener;
    }

    @NonNull
    @Override
    public GenreDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.item_details_genres, viewGroup, false);
        return new GenreDetailViewHolder(view, mTrackListener, mTracks);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreDetailViewHolder genreDetailViewHolder, int i) {
        genreDetailViewHolder.bindData(i);

    }

    @Override
    public int getItemCount() {
        return mTracks == null ? 0 : mTracks.size();
    }

    public static class GenreDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextArtist;
        private TextView mTextNameTrack;
        private ImageView mImageFavorite;
        private ImageView mImageOption;
        private Track mCurrentTrack;
        private List<Track> mTracks;
        private TrackListener mTrackListener;
        private ImageView mImageViewTrack;

        public GenreDetailViewHolder(@NonNull View itemView,
                                     TrackListener trackListener, List<Track> tracks) {
            super(itemView);
            this.mTrackListener = trackListener;
            this.mTracks = tracks;
            mTextArtist = itemView.findViewById(R.id.text_artist);
            mTextNameTrack = itemView.findViewById(R.id.text_name_track);
            mImageFavorite = itemView.findViewById(R.id.image_favorite_details_genres);
            mImageFavorite.setOnClickListener(this);
            mImageOption = itemView.findViewById(R.id.image_option_details_genres);
            mImageOption.setOnClickListener(this);
            mImageViewTrack = itemView.findViewById(R.id.image_track_details);
        }

        public void bindData(int position) {
            if (mTracks == null)
                return;
            mCurrentTrack = mTracks.get(position);
            mTextNameTrack.setText(mCurrentTrack.getTitle());
            mTextArtist.setText(mCurrentTrack.getPublisherAlbumTitle());
            Glide.with(itemView.getContext()).load(mCurrentTrack.getArtworkUrl())
                    .apply(new RequestOptions()
                            .override(Constants.ITEM_SIZE)
                            .fitCenter()
                            .error(R.drawable.image6))
                    .into(mImageViewTrack);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.image_favorite_details_genres:
                    break;
                case R.id.image_option_details_genres:
                    break;
                default:
                    handlePlayTracks();
                    break;
            }
        }

        private void handlePlayTracks() {
            if (mTrackListener == null) return;
            mTrackListener.onPlayTrack(getAdapterPosition(), mTracks);
        }
    }

    public void updateListTrack(List<Track> tracks) {
        mTracks.addAll(tracks);
        notifyDataSetChanged();
    }

    public void clearData() {
        if (mTracks != null) {
            mTracks.clear();
            notifyDataSetChanged();
        }
    }
}

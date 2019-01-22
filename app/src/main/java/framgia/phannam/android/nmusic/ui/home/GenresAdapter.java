package framgia.phannam.android.nmusic.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.fristproject.android.music55.R;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Genres;

/**
 * Created by namp5 on 1/17/2019.
 */

public class GenresAdapter extends RecyclerView.Adapter
        <GenresAdapter.ViewHolder> {
    private List<Genres> mGenres;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnGenresClickListener mListener;

    public GenresAdapter(List<Genres> genres, Context context) {
        mGenres = genres;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        View view = mInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_categories, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Genres genres = mGenres.get(i);
        viewHolder.bindView(genres, mListener);
    }

    @Override
    public int getItemCount() {
        return mGenres != null ? mGenres.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextViewTitle;
        private ImageView mImageViewGenres;
        private String mNameGenres;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.text_categories);
            mImageViewGenres = itemView.findViewById(R.id.image_categories);
        }

        public void bindView(final Genres genres, final OnGenresClickListener listener) {
            mTextViewTitle.setText(genres.getGenres());
            Glide.with(mImageViewGenres)
                    .load(genres.getGenresImage())
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(mImageViewGenres);
            mNameGenres = genres.getGenresName();
            mImageViewGenres.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onGenresClicked(mNameGenres);
        }
    }

    public void setGenres(List<Genres> categories) {
        this.mGenres = categories;
        notifyDataSetChanged();
    }

    public void setOnGenreClickListener(OnGenresClickListener listener) {
        mListener = listener;
    }

    interface OnGenresClickListener {
        void onGenresClicked(String genres);
    }
}

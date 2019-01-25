package framgia.phannam.android.nmusic.ui.today;

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

import framgia.phannam.android.nmusic.data.model.home.Today;


/**
 * Created by namp5 on 1/21/2019.
 */

public class ToDayAdapter extends RecyclerView.Adapter
        <ToDayAdapter.ViewHolder> {
    private List<Today> mToday;
    private Context mContext;
    private LayoutInflater mInflater;
    private ToDayAdapter.OnTodayClickListener mListener;

    public ToDayAdapter(List<Today> today, Context context) {
        mToday = today;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(viewGroup.getContext());
        }
        View view = mInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_today, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Today today = mToday.get(i);
        viewHolder.bindView(today, mListener);
    }

    @Override
    public int getItemCount() {
        return mToday != null ? mToday.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextViewTitle;
        private ImageView mImageViewToday;
        private TextView mTextViewArtists;
        private String mNameToday;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewToday = itemView.findViewById(R.id.image_today);
            mTextViewTitle = itemView.findViewById(R.id.text_today);
            mTextViewArtists = itemView.findViewById(R.id.text_today_artists);
        }

        public void bindView(final Today today, final ToDayAdapter.OnTodayClickListener listener) {
            mTextViewTitle.setText(today.getToday());
            mTextViewArtists.setText(today.getTodayArtists());
            Glide.with(mImageViewToday)
                    .load(today.getTodayImage())
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(mImageViewToday);
            mNameToday = today.getTodayName();
            mImageViewToday.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onTodayClicked(mNameToday);
        }
    }

    public void setToday(List<Today> todays) {
        this.mToday = todays;
        notifyDataSetChanged();
    }

    public void setOnGenreClickListener(ToDayAdapter.OnTodayClickListener listener) {
        mListener = listener;
    }

    interface OnTodayClickListener {
        void onTodayClicked(String click);
    }
}

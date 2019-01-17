package framgia.phannam.android.nmusic.ui.home;

import android.annotation.SuppressLint;
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

import framgia.phannam.android.nmusic.data.model.home.Categories;

/**
 * Created by namp5 on 1/17/2019.
 */

public class HomeCategoriesAdapter extends RecyclerView.Adapter
        <HomeCategoriesAdapter.ViewHolder> {
    private List<Categories> mCategories;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnCateClickListener mListener;

    public HomeCategoriesAdapter(List<Categories> categories, Context context) {
        mCategories = categories;
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
        Categories categories = mCategories.get(i);
        viewHolder.bindView(categories, mListener);
    }

    @Override
    public int getItemCount() {
        return mCategories != null ? mCategories.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle;
        private ImageView mImageViewCate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.text_categories);
            mImageViewCate = itemView.findViewById(R.id.image_categories);
        }

        public void bindView(final Categories categories, final OnCateClickListener listener) {
            mTextViewTitle.setText(categories.getCate());
            Glide.with(mImageViewCate)
                    .load(categories.getCateImage())
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(mImageViewCate);
            mImageViewCate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCateClicked(categories.getCateName());
                }
            });
        }
    }

    public void setOnGenreClickListener(OnCateClickListener listener) {
        mListener = listener;
    }

    interface OnCateClickListener {
        void onCateClicked(String genre);
    }
}

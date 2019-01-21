package framgia.phannam.android.nmusic.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fristproject.android.music55.R;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Categories;
import framgia.phannam.android.nmusic.data.repository.CatesRepository;
import framgia.phannam.android.nmusic.data.source.CategoriesLocalDataSource;


public class FragmentCategories extends Fragment implements HomeContract.View,
        HomeCategoriesAdapter.OnCateClickListener {
    public static final int SPAN_COUNT = 2;
    private RecyclerView mRecyclerView;
    private HomeCategoriesAdapter mCategoriesAdapter;
    private Context mContext;
    private HomeContract.Presenter mPresenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gategories, container, false);
        mContext = getContext();
        mRecyclerView = view.findViewById(R.id.recyler_categories);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        mRecyclerView.setLayoutManager(layoutManager);
        mCategoriesAdapter = new HomeCategoriesAdapter(null, mContext);
        mCategoriesAdapter.setOnGenreClickListener(this);
        mRecyclerView.setAdapter(mCategoriesAdapter);
        mPresenter = new HomePresenter(this,
                CatesRepository.getInstance(new CategoriesLocalDataSource()));
        mPresenter.loadCategories();
        return view;
    }

    public static FragmentCategories newInstance() {
        FragmentCategories fragmentCategories = new FragmentCategories();
        return fragmentCategories;
    }

    @Override
    public void onCateClicked(String cates) {

    }

    @Override
    public void showCategories(List<Categories> categories) {
        mCategoriesAdapter.setGenres(categories);
    }

    @Override
    public void showSongsByCates() {
    }
}

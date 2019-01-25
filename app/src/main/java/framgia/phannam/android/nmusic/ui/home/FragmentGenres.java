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

import framgia.phannam.android.nmusic.data.model.home.Genres;
import framgia.phannam.android.nmusic.data.repository.GenresRepository;
import framgia.phannam.android.nmusic.data.source.GenresLocalDataSource;


public class FragmentGenres extends Fragment implements
        GenresAdapter.OnGenresClickListener, HomeContract.View {
    public static final int SPAN_COUNT = 2;
    private RecyclerView mRecyclerView;
    private GenresAdapter mCategoriesAdapter;
    private Context mContext;
    private HomeContract.Presenter mPresenter;

    public static FragmentGenres newInstance() {
        FragmentGenres fragmentGenres = new FragmentGenres();
        return fragmentGenres;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_genres, container, false);
        mContext = getContext();
        mRecyclerView = view.findViewById(R.id.recyler_categories);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        mRecyclerView.setLayoutManager(layoutManager);
        mCategoriesAdapter = new GenresAdapter(null, mContext);
        mCategoriesAdapter.setOnGenreClickListener(this);
        mRecyclerView.setAdapter(mCategoriesAdapter);
        mPresenter = new HomePresenter(this,
                GenresRepository.getInstance(new GenresLocalDataSource()));
        mPresenter.loadGenres();
        return view;
    }

    @Override
    public void onGenresClicked(String cates) {

    }

    @Override
    public void showGenres(List<Genres> genres) {
        mCategoriesAdapter.setGenres(genres);
    }

    @Override
    public void showSongsByGenres() {
    }
}

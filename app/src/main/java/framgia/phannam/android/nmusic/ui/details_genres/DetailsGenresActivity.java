package framgia.phannam.android.nmusic.ui.details_genres;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fristproject.android.music55.R;

import java.util.ArrayList;

import framgia.phannam.android.nmusic.data.model.home.Track;
import framgia.phannam.android.nmusic.data.repository.TrackRepository;
import framgia.phannam.android.nmusic.ui.TrackListener;
import framgia.phannam.android.nmusic.utils.Constants;
import framgia.phannam.android.nmusic.utils.ScrollListener;

/**
 * Created by namp5 on 1/30/2019.
 */

public class DetailsGenresActivity extends AppCompatActivity implements DetailsGenresContract.View {
    private static final String NAME_GENRES = "name_genres";
    private DetailsGenresContract.Presenter mPresenter;
    private GenresDetailsAdapter mAdapter;
    private TrackListener mTrackListener;
    private RecyclerView mRecyclerTracks;
    private Toolbar mToolbar;
    private ProgressBar mProgressLoad;
    private TextView mTextNameGenres;
    private String mGenre;
    private Window mWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_genres);
        loadData();
        setColorStatusBar();
        initView();
    }

    private void loadData() {
        Intent intent = getIntent();
        mGenre = intent.getStringExtra(NAME_GENRES);
        mPresenter = new DetailsGenresPresenter(this, TrackRepository.getInstance());
        mPresenter.loadTracks(mGenre, Constants.LIMIT_DEFAULT, Constants.OFFSET_DEFAULT);
        mAdapter = new GenresDetailsAdapter(this, new ArrayList<Track>(), mTrackListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerTracks.setAdapter(mAdapter);
        mRecyclerTracks.addOnScrollListener(new ScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int offset) {
                mPresenter.loadTracks(mGenre, Constants.LIMIT_DEFAULT, offset);
            }
        });
    }

    private void initView() {
        mToolbar = findViewById(R.id.tool_bar_details_genres);
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mProgressLoad = findViewById(R.id.progress);
        mRecyclerTracks = findViewById(R.id.recycler_details_genres);

        mTextNameGenres = findViewById(R.id.text_name_genres_details_genres);
        mTextNameGenres.setText(mGenre);
    }

    private void setColorStatusBar() {
        mWindow = getWindow();
        mWindow.setStatusBarColor(ContextCompat.
                getColor(this, R.color.color_background_navigatiton));
    }

    @Override
    public void setPresenter(DetailsGenresContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showTrack(ArrayList<Track> tracks) {
        mProgressLoad.setVisibility(View.GONE);
        mAdapter.updateListTrack(tracks);
    }

    @Override
    public void showNoTrackAvailable() {

    }

    @Override
    public void showLoadingTracksError(String error) {

    }
}

package framgia.phannam.android.nmusic.ui.today;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fristproject.android.music55.R;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Today;
import framgia.phannam.android.nmusic.data.repository.TodayRepository;
import framgia.phannam.android.nmusic.data.source.TodayLocalDataSource;

/**
 * Created by namp5 on 1/21/2019.
 */

public class FragmentToDay extends Fragment implements ToDayAdapter.OnTodayClickListener,
        ToDayContract.View {
    private RecyclerView mRecyclerView;
    private ToDayAdapter mToDayAdapter;
    private Context mContext;
    private ToDayContract.Presenter mPresenter;

    public static FragmentToDay newInstance() {
        FragmentToDay fragmentToday = new FragmentToDay();
        return fragmentToday;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        mContext = getContext();
        mRecyclerView = view.findViewById(R.id.recyler_today);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mToDayAdapter = new ToDayAdapter(null, mContext);
        mToDayAdapter.setOnGenreClickListener(this);
        mRecyclerView.setAdapter(mToDayAdapter);
        mPresenter = new ToDayPresenter(this,
                TodayRepository.getInstance(new TodayLocalDataSource()));
        mPresenter.loadToDay();
        return view;
    }

    @Override
    public void onTodayClicked(String click) {

    }

    @Override
    public void showToday(List<Today> todays) {
        mToDayAdapter.setToday(todays);
    }

    @Override
    public void showSongsByToday() {

    }
}

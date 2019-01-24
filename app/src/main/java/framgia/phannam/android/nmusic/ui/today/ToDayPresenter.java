package framgia.phannam.android.nmusic.ui.today;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Today;
import framgia.phannam.android.nmusic.data.repository.TodayRepository;

/**
 * Created by namp5 on 1/21/2019.
 */

public class ToDayPresenter implements ToDayContract.Presenter {
    private ToDayContract.View mView;
    private TodayRepository mTodayRepository;

    public ToDayPresenter(ToDayContract.View view, TodayRepository catesRepository) {
        mView = view;
        mTodayRepository = catesRepository;
    }

    @Override
    public void loadToDay() {
        List<Today> todays = mTodayRepository.getTodays();
        mView.showToday(todays);
    }

    @Override
    public void loadSongsByToday() {

    }
}

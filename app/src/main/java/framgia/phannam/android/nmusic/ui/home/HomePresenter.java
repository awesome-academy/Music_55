package framgia.phannam.android.nmusic.ui.home;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Categories;
import framgia.phannam.android.nmusic.data.repository.CatesRepository;

/**
 * Created by namp5 on 1/17/2019.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private CatesRepository mCatesRepository;

    public HomePresenter(HomeContract.View view, CatesRepository catesRepository) {
        this.mView = view;
        mCatesRepository = catesRepository;
    }

    @Override
    public void loadCategories() {
        List<Categories> cates = mCatesRepository.getCates();
        mView.showCategories(cates);
    }

    @Override
    public void loadSongsByCates() {

    }
}

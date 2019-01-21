package framgia.phannam.android.nmusic.ui.home;

import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Categories;

/**
 * Created by namp5 on 1/17/2019.
 */

public class HomeContract {
    interface Presenter {
        void loadCategories();

        void loadSongsByCates();
    }

    interface View {
        void showCategories(List<Categories> categories);

        void showSongsByCates();
    }
}

package framgia.phannam.android.nmusic.ui.today;

import java.util.List;
import framgia.phannam.android.nmusic.data.model.home.Today;

/**
 * Created by namp5 on 1/21/2019.
 */

public class ToDayContract {
    interface Presenter {
        void loadToDay();
        void loadSongsByToday();
    }

    interface View {
        void showToday(List<Today> todays);
        void showSongsByToday();
    }
}

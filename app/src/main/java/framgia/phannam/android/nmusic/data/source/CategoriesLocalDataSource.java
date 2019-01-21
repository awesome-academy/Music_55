package framgia.phannam.android.nmusic.data.source;

import com.fristproject.android.music55.R;

import java.util.ArrayList;
import java.util.List;

import framgia.phannam.android.nmusic.data.constant.CateEntity;
import framgia.phannam.android.nmusic.data.model.home.Categories;

public class CategoriesLocalDataSource implements DataSource {

    @Override
    public List<Categories> getCates() {
        List<Categories> genres = new ArrayList<>();
        genres.add(new Categories(CateEntity.ALL_MUSIC, R.string.genre_all_music, R.raw.allmusic));
        genres.add(new Categories(CateEntity.ALL_AUDIO, R.string.genre_all_audio, R.raw.audio));
        genres.add(new Categories(CateEntity.ALTERNATIVE, R.string.genre_alternative, R.raw.alternative));
        genres.add(new Categories(CateEntity.AMBIENT, R.string.genre_ambient, R.raw.ambient));
        genres.add(new Categories(CateEntity.CLASSICAL, R.string.genre_classical, R.raw.classical));
        genres.add(new Categories(CateEntity.COUNTRY, R.string.genre_country, R.raw.countryside));
        return genres;
    }
}

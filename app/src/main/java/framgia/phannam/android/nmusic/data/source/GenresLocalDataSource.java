package framgia.phannam.android.nmusic.data.source;

import com.fristproject.android.music55.R;

import java.util.ArrayList;
import java.util.List;

import framgia.phannam.android.nmusic.data.model.home.Genres;
import framgia.phannam.android.nmusic.utils.GenresEntity;

public class GenresLocalDataSource implements GenresDataSource {

    @Override
    public  List<Genres> getGenres() {
        List<Genres> genres = new ArrayList<>();
        genres.add(new Genres(GenresEntity.ALL_MUSIC, R.string.genre_all_music, R.raw.allmusic));
        genres.add(new Genres(GenresEntity.ALL_AUDIO, R.string.genre_all_audio, R.raw.audio));
        genres.add(new Genres(GenresEntity.ALTERNATIVE, R.string.genre_alternative, R.raw.alternative));
        genres.add(new Genres(GenresEntity.AMBIENT, R.string.genre_ambient, R.raw.ambient));
        genres.add(new Genres(GenresEntity.CLASSICAL, R.string.genre_classical, R.raw.classical));
        genres.add(new Genres(GenresEntity.COUNTRY, R.string.genre_country, R.raw.countryside));
        return genres;
    }
}

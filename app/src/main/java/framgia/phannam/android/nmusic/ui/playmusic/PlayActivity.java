package framgia.phannam.android.nmusic.ui.playmusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fristproject.android.music55.R;

/**
 * Created by namp5 on 1/17/2019.
 */

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar mToolbar;
    public static final String TITLE_ACTION_BAR = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        initView();

    }

    private void initView() {
        mToolbar = findViewById(R.id.tool_bar_play_music);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(TITLE_ACTION_BAR);
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        mToolbar.setNavigationOnClickListener(this);
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, PlayActivity.class);
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.now_playing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_now_playing:
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tool_bar_play_music :
                onBackPressed();
                break;
        }
    }
}


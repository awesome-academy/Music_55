package framgia.phannam.android.nmusic.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fristproject.android.music55.R;

import framgia.phannam.android.nmusic.ui.home.FragmentGenres;
import framgia.phannam.android.nmusic.ui.today.FragmentToDay;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    public static final String TITLE_ACTIONBAR = "Music";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_menu);
        getSupportActionBar().setTitle(TITLE_ACTIONBAR);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new FragmentGenres());
        loadFragmentToDay(new FragmentToDay());
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_categories, fragment);
        transaction.commit();
    }

    private void loadFragmentToDay(Fragment fragment){
        FragmentTransaction transaction1 =getSupportFragmentManager().beginTransaction();
        transaction1.add(R.id.frame_today,fragment);
        transaction1.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                return true;
            case R.id.navigation_favorite:
                return true;
            case R.id.navigation_my_music:
                return true;
            default:
                break;
        }
        return false;
    }
}

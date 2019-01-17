package framgia.phannam.android.nmusic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import framgia.phannam.android.nmusic.ui.home.HomeActivity;

public class FlashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(FlashScreenActivity.this, HomeActivity.class));
        finish();
    }
}

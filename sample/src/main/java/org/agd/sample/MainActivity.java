package org.agd.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.agd.badges.Badges;
import org.agd.badges.BadgesNotSupported;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.text_badge_count)
    EditText badgeCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    public void updateButtonPressed(View v) {
        int badgeCount = Integer.parseInt(badgeCountText.getText().toString());
        updateBadge(badgeCount);
    }

    private void updateBadge(int count) {
        try {
            Badges.setBadge(this, count);
        } catch (BadgesNotSupported badgesNotSupported) {
            Log.d(TAG, badgesNotSupported.getMessage());
        }
    }
}

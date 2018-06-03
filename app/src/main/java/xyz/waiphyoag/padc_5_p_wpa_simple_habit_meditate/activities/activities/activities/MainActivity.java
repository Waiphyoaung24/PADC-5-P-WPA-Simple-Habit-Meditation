package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.MeditationApp;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.ItemAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.MeFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.OnTheGoFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.SeriesFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.TeachersFragment;

public class MainActivity extends BaseActivity implements SessionsItemDelegate {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.vp_tab)
    ViewPager vpTab;
    private ItemAdapter itemAdapter;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.fl_main_screen)
    FrameLayout flMainScreen;

    public static Intent meditateIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Simple Meditate");

        }

        itemAdapter = new ItemAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(vpTab);
        itemAdapter.addTab("On The Go", new OnTheGoFragment());
        itemAdapter.addTab("Series", new SeriesFragment());
        itemAdapter.addTab("Teachers", new TeachersFragment());
        vpTab.setAdapter(itemAdapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.item_meditate:
                        Intent intentForMeditate = MainActivity.meditateIntent(getApplicationContext());
                        startActivity(intentForMeditate);
                        break;
                    case R.id.item_me:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_main_screen, MeFragment.newInstance())
                                .commit();
                    case R.id.item_more:
                        break;
                }

                return true;
            }


        });
    }


    @Override
    public void onTapSessionItem(String categoryId, String programId) {
        Intent intent = SessionDetailActivity.newIntentForCategories(getApplicationContext(), categoryId, programId);
        intent.putExtra(MeditationApp.PROGRAM_ID, programId);
        intent.putExtra(MeditationApp.PROGRAM_ID, categoryId);
        startActivity(intent);

    }

    @Override
    public void onTapStartHere(String programId) {
        Intent intent = SessionDetailActivity.newIntentForCurrentProgram(getApplicationContext());
        intent.putExtra(MeditationApp.PROGRAM_ID, programId);
        startActivity(intent);

    }

    @Override
    public void onTapTopicItem() {

    }
}


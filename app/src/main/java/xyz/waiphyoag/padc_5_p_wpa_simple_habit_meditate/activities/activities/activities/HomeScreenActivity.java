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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.ItemAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.HomePresenterDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.delegates.SessionsItemDelegate;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.MeFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.OnTheGoFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.SeriesFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.TeachersFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.presenters.HomeScreenPresenter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.HomeScreenView;

public class HomeScreenActivity extends BaseActivity implements HomeScreenView,HomePresenterDelegate{

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
    private HomeScreenPresenter mPresenter;

    public static Intent meditateIntent(Context context) {
        Intent intent = new Intent(context, HomeScreenActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        mPresenter=new HomeScreenPresenter(this);
        mPresenter.onCreate();

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
//                        Intent intentForMeditate = HomeScreenActivity.meditateIntent(getApplicationContext());
//                        startActivity(intentForMeditate);
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
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }


    @Override
    public HomeScreenPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void displaySessionList(List<SharedParent> mData) {
        SeriesFragment seriesFragment = (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.displaySessionList(mData);
    }

    @Override
    public void displayErrorList(String errorMsg) {
        SeriesFragment seriesFragment= (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.displayErrorList(errorMsg);

    }

    @Override
    public void lauchSessionList(String programId, String categoryId) {
        SeriesFragment seriesFragment= (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.lauchSessionList(programId,categoryId);


    }

    @Override
    public void lauchCurrentProgram(String programId) {
        SeriesFragment seriesFragment= (SeriesFragment) itemAdapter.getItem(1);
        seriesFragment.lauchCurrentProgram(programId);


    }
}


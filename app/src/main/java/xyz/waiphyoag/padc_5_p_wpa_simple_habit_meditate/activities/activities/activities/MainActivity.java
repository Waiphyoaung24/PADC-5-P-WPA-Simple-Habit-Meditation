package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.ItemAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.OnTheGoFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.SeriesFragment;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.fragments.TeachersFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.vp_tab)
    ViewPager vpTab;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Simple Meditate");

        }

        itemAdapter=new ItemAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(vpTab);
        itemAdapter.addTab("On The Go",new OnTheGoFragment());
        itemAdapter.addTab("Series",new SeriesFragment());
        itemAdapter.addTab("Teachers",new TeachersFragment());
        vpTab.setAdapter(itemAdapter);


    }
}

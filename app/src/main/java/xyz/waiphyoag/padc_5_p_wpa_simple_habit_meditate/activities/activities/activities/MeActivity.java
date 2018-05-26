package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;

/**
 * Created by WaiPhyoAg on 5/26/18.
 */

public class MeActivity extends BaseActivity {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static Intent MeIntent(Context context)
    {
        Intent intent=new Intent(context,MeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpod_me);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle("Me");
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id) {
                    case R.id.item_meditate:
                        Intent meditateIntent=MainActivity.meditateIntent(getApplicationContext());
                        startActivity(meditateIntent);
                    case R.id.item_me:
//                        Intent meIntent=MeActivity.MeIntent(getApplicationContext());
//                        startActivity(meIntent);
                    case R.id.item_more:
                        break;
                }
                return true;
            }
        });


    }
}

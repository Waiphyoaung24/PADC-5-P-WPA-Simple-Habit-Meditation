package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.CategoryTipsAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.HealthyTipsAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.MeditationTipsAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.NewTipsAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_meditation_tips)
    RecyclerView rvMeditationTips;
    @BindView(R.id.rv_healthy_tips)
    RecyclerView rvHealthyTips;
    @BindView(R.id.rv_new_tips)
    RecyclerView rvNewTips;
    @BindView(R.id.rv_category_tips)
    RecyclerView rvCategoryTips;

    private NewTipsAdapter newTipsAdapter;
    private HealthyTipsAdapter healthyTipsAdapter;
    private MeditationTipsAdapter meditationTipAdapter;
    private CategoryTipsAdapter categoryTipsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        meditationTipAdapter =new MeditationTipsAdapter();
        LinearLayoutManager linearLayoutManagerforMeditationTips=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvMeditationTips.setLayoutManager(linearLayoutManagerforMeditationTips);
        rvMeditationTips.setAdapter(meditationTipAdapter);

        healthyTipsAdapter =new HealthyTipsAdapter();
        LinearLayoutManager linearLayoutManagerforHealthyTips=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvHealthyTips.setLayoutManager(linearLayoutManagerforHealthyTips);
        rvHealthyTips.setAdapter(healthyTipsAdapter);


        newTipsAdapter =new NewTipsAdapter();
        LinearLayoutManager linearLayoutManagerforNewTips=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvNewTips.setLayoutManager(linearLayoutManagerforNewTips);
        rvNewTips.setAdapter(newTipsAdapter);

        categoryTipsAdapter =new CategoryTipsAdapter();
        LinearLayoutManager linearLayoutManagerforCategoryTips=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvCategoryTips.setLayoutManager(linearLayoutManagerforCategoryTips);
        rvCategoryTips.setAdapter(categoryTipsAdapter);


    }
}

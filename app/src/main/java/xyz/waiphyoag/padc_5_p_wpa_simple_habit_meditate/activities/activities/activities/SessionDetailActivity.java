package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.MeditationApp;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.SessionListAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model.UserModel;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;

/**
 * Created by WaiPhyoAg on 5/31/18.
 */

public class SessionDetailActivity extends BaseActivity {
    @BindView(R.id.rv_session_list)
    RecyclerView rvSessionList;

    @BindView(R.id.tv_session_detail)
    TextView tvSessionDetail;
    private SessionListAdapter mSessionAdapter;
    private CurrentProgramsVO currentProgramsVO;
    private String programName;

    private static final String IE_PROGRAM_NAME = "IE_PROGRAM_NAME";



    public static Intent newIntent(Context context,String programName) {
        Intent intent = new Intent(context, SessionDetailActivity.class);
        intent.putExtra(IE_PROGRAM_NAME,"programID");
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail);
        ButterKnife.bind(this, this);


        mSessionAdapter = new SessionListAdapter(this);
        LinearLayoutManager linearLayoutManagerforSession = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSessionList.setAdapter(mSessionAdapter);
        rvSessionList.setLayoutManager(linearLayoutManagerforSession);

//        int programID= getIntent().getIntExtra(MeditationApp.Current_program,0);
//        CurrentProgramsVO currentProgramsVO= (CurrentProgramsVO) UserModel.getInstance().getCollectionList().get(programID);
//        mSessionAdapter.appendNewData(currentProgramsVO.getSessionsVO());
//        tvSessionDetail.setText(currentProgramsVO.getDescription());


        programName=getIntent().getStringExtra(IE_PROGRAM_NAME);
        tvSessionDetail.setText(currentProgramsVO.getDescription());
    }



}

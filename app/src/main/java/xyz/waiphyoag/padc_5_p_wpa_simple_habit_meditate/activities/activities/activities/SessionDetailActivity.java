package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.MeditationApp;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters.SessionListAdapter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model.UserModel;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.presenters.SessionDetailPresenter;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.mvp.views.SessionDetailView;


/**
 * Created by WaiPhyoAg on 5/31/18.
 */

public class SessionDetailActivity extends BaseActivity implements SessionDetailView {
    @BindView(R.id.rv_session_list)
    RecyclerView rvSessionList;
    @BindView(R.id.tv_session_main_title)
    TextView tvSessionTitle;
    @BindView(R.id.tv_session_detail)
    TextView tvSessionDetail;
    @BindView(R.id.tv_read_more)
    TextView tvReadMore;



    private SessionListAdapter mSessionAdapter;
    private CurrentProgramsVO currentProgramsVO;
    private ProgramsVO programsVO;
    private String programName;
    private SessionDetailPresenter mPresenter;


    public static Intent newIntentForCurrentProgram(Context context) {
        Intent intent = new Intent(context, SessionDetailActivity.class);
        intent.putExtra(MeditationApp.IE_PROGRAM_NAME, MeditationApp.Current_Program);
        return intent;
    }

    public static Intent newIntentForCategories(Context context, String categoryId, String programId) {
        Intent intent = new Intent(context, SessionDetailActivity.class);
        intent.putExtra(MeditationApp.IE_PROGRAM_NAME, MeditationApp.Category);
        intent.putExtra(MeditationApp.IE_CATEGORY_ID, categoryId);
        intent.putExtra(MeditationApp.IE_PROGRAM_ID, programId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail);
        ButterKnife.bind(this, this);
        mPresenter = new SessionDetailPresenter(this);
        mPresenter.onCreate();

        mSessionAdapter = new SessionListAdapter(this);


        LinearLayoutManager linearLayoutManagerforSession = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSessionList.setAdapter(mSessionAdapter);
        rvSessionList.setLayoutManager(linearLayoutManagerforSession);


        if (getIntent().getStringExtra(MeditationApp.IE_PROGRAM_NAME).equals(MeditationApp.Current_Program)) {
            String programId = getIntent().getStringExtra(MeditationApp.IE_PROGRAM_ID);

            mPresenter.onFinishLoadingCurrentProgramDetail(programId, currentProgramsVO);


        } else if (getIntent().getStringExtra(MeditationApp.IE_PROGRAM_NAME).equals(MeditationApp.Category)) {
            String categoryId = getIntent().getStringExtra(MeditationApp.IE_CATEGORY_ID);
            String programId = getIntent().getStringExtra(MeditationApp.IE_PROGRAM_ID);

            mPresenter.onFinishLoadingProgram(categoryId, programId, programsVO);


        }
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
    public void onFinishLauchingCurrentProgram(String programId, CurrentProgramsVO currentProgramsVO) {
        mSessionAdapter.setNewData(currentProgramsVO.getSessionsVO());
        tvSessionDetail.setText(currentProgramsVO.getDescription());
    }

    @Override
    public void onFinishLauchingPrograms(String categoryId, String programId, ProgramsVO programsVO) {
        mSessionAdapter.setNewData(programsVO.getSessionsVO());
        tvSessionDetail.setText(programsVO.getDescription());
        tvSessionTitle.setText(programsVO.getTitle());
    }
}

package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.SessionsVO;

/**
 * Created by WaiPhyoAg on 5/31/18.
 */

public class SessionDetailActivity extends BaseActivity {
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
    private List<SessionsVO> sessionList;

    private static final String IE_PROGRAM_NAME = "IE_PROGRAM_NAME";
    private static final String IE_PROGRAM_ID = "IE_PROGRAM_ID";
    private static final String IE_CATEGORY_ID = "IE_CATEGORY_ID";


    public static Intent newIntentForCurrentProgram(Context context) {
        Intent intent = new Intent(context, SessionDetailActivity.class);
        intent.putExtra(IE_PROGRAM_NAME, "programID");
        return intent;
    }

    public static Intent newIntentForCategories(Context context, String categoryId, String programId) {
        Intent intent = new Intent(context, SessionDetailActivity.class);
        intent.putExtra(IE_PROGRAM_ID, programId);
        intent.putExtra(IE_CATEGORY_ID, categoryId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail);
        ButterKnife.bind(this, this);


        mSessionAdapter = new SessionListAdapter(this);


//        int programID= getIntent().getIntExtra(MeditationApp.PROGRAM_ID,0);
//        CurrentProgramsVO currentProgramsVO= (CurrentProgramsVO) UserModel.getInstance().getCollectionList().get(programID);
//        mSessionAdapter.appendNewData(currentProgramsVO.getSessionsVO());
//        tvSessionDetail.setText(currentProgramsVO.getDescription());


        String programID = getIntent().getStringExtra(MeditationApp.PROGRAM_ID);
        String categoryID = getIntent().getStringExtra(MeditationApp.CATEGORY_ID);

        int CurrentProgramID = getIntent().getIntExtra(MeditationApp.PROGRAM_ID, 0);

        if (UserModel.getInstance().getCurrentProgramByProgramID(programID) != null) {
            CurrentProgramsVO currentProgramsVO = (CurrentProgramsVO) UserModel.getInstance().getCollectionList().get(CurrentProgramID);
            mSessionAdapter.appendNewData(currentProgramsVO.getSessionsVO());
            tvSessionDetail.setText(currentProgramsVO.getDescription());

            if (tvSessionDetail.getLineCount() < tvSessionDetail.getMaxLines()) {
                tvReadMore.setVisibility(View.GONE);

            }

        } else if (UserModel.getInstance().getProgramByProgramID(programID, categoryID) != null) {
            programsVO = UserModel.getInstance().getProgramByProgramID(programID, categoryID);
            mSessionAdapter.setNewData(programsVO.getSessionsVO());
            tvSessionDetail.setText(programsVO.getDescription());
            tvSessionTitle.setText(programsVO.getTitle());
            mSessionAdapter.setNewData(programsVO.getSessionsVO());


        }

        LinearLayoutManager linearLayoutManagerforSession = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSessionList.setAdapter(mSessionAdapter);
        rvSessionList.setLayoutManager(linearLayoutManagerforSession);

    }


}

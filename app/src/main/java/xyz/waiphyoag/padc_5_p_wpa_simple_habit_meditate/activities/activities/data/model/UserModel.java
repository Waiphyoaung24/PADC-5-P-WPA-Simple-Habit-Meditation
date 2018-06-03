package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.Events.RestApiEvent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.ProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.DataAgents.RetrofitDataAgent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.DataAgents.SimpleHabitDataAgent;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class UserModel {
    private static UserModel objInstance;
    private List<SharedParent> collectionList;
    private List<CategoriesVO> categoriesVOS;

    public List<SharedParent> getCollectionList() {
        return collectionList;
    }

    private SimpleHabitDataAgent simpleHabitDataAgent;
    private static final int pageNo = 1;
    private static final String accessToken = "b002c7e1a528b7cb460933fc2875e916";

    private UserModel() {
        EventBus.getDefault().register(this);

        collectionList = new ArrayList<>();
    }

    public static UserModel getInstance() {
        if (objInstance == null) {
            objInstance = new UserModel();
        }
        return objInstance;
    }

    public void StartloadingSimpleHabit() {
        RetrofitDataAgent.getInstance().loadCurrentProgram(pageNo, accessToken);

    }

    @Subscribe
    public void onCurrentProgramDataLoaded(RestApiEvent.LoadedCurrentProgramList event) {
        collectionList.add(event.getCurrentProgramsVOList());
        RetrofitDataAgent.getInstance().loadCategory(pageNo, accessToken);

    }

    @Subscribe
    public void onCategoriesDataLoaded(RestApiEvent.LoadedCategoriesList event) {
        collectionList.addAll(event.getCategoriesVOList());
        RetrofitDataAgent.getInstance().loadTopic(pageNo, accessToken);

    }

    @Subscribe
    public void onTopicDataLoaded(RestApiEvent.LoadedTopicList event) {
        collectionList.addAll(event.getLoadTopicsList());
        RestApiEvent.SuccessEvent dataSuccess = new RestApiEvent.SuccessEvent(collectionList);
        EventBus.getDefault().post(dataSuccess);

    }

    public CurrentProgramsVO getCurrentProgramByProgramID(String programId) {

        for (SharedParent obj : collectionList) {
            if (obj instanceof CurrentProgramsVO)
                return (CurrentProgramsVO) obj;
        }
        return null;
    }

    public ProgramsVO getProgramByProgramID(String programId, String categoryId) {
        ProgramsVO programsVO = null;

        for (int i = 0; i < collectionList.size(); i++) {
            if ((collectionList.get(i) instanceof CategoriesVO)) {
                if (((CategoriesVO) collectionList.get(i)).getCategoryID().equals(categoryId)) {
                    for (int j = 0; j < ((CategoriesVO) collectionList.get(i)).getPrograms().size(); j++) {
                        if (((CategoriesVO) collectionList.get(i)).getPrograms().get(j).getProgramID().equals(programId)) {
                            return ((CategoriesVO) collectionList.get(i)).getPrograms().get(j);
                        }

                    }

                }
            }
        }
        return null;
    }

}


//                for (int i = 0; i < collectionList.size(); i++) {
//        if (collectionList.get(i) instanceof CategoriesVO) {
//        for (int j = 0; j < ((CategoriesVO) collectionList.get(i)).getPrograms().size(); j++) {
//        String id = ((CategoriesVO) collectionList.get(i)).getPrograms().get(j).getProgramID();
//        if (id.equals(programId)) {
//        programsVO = ((CategoriesVO) collectionList.get(i)).getPrograms().get(j);
//        }
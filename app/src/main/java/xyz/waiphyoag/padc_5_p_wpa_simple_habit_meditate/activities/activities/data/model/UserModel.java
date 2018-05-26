package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.Events.RestApiEvent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.DataAgents.RetrofitDataAgent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.DataAgents.SimpleHabitDataAgent;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class UserModel {
    private static UserModel objInstance;
    private List<TopicsVO> mTopic;
    private int mmPageIndex=1;
    private SimpleHabitDataAgent simpleHabitDataAgent;

    private UserModel()
    {
        EventBus.getDefault().register(this);
        mTopic=new ArrayList<>();
        simpleHabitDataAgent=RetrofitDataAgent.getInstance();
    }
    public static UserModel getInstance()
    {
        if(objInstance==null)
        {
            objInstance=new UserModel();
        }
        return objInstance;
    }
    public void StartloadingSimpleHabit()
    {
//        RetrofitDataAgent.getInstance().loadData(1,"b002c7e1a528b7cb460933fc2875e916");
        simpleHabitDataAgent.loadData(1,"b002c7e1a528b7cb460933fc2875e916");
    }
    @Subscribe
    public void onTopicDataLoaded(RestApiEvent.LoadedTopicList event)
    {
        mTopic.addAll(event.getLoadTopicsList());


    }

}

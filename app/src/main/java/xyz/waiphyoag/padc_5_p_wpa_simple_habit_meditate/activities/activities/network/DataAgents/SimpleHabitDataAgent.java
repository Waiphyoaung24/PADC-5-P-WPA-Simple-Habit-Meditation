package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.network.DataAgents;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public interface SimpleHabitDataAgent {

    void loadTopic(int pageNo,String accessToken);
    void loadCurrentProgram (int pageNo,String accessToken);
    void loadCategory (int pageNo,String accessToken);
}

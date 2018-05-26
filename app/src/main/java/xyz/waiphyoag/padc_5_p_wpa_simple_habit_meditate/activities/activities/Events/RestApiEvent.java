package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.Events;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class RestApiEvent {
    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class LoadedTopicList {
        private String loadedPageIndex;
        private List<TopicsVO> loadTopicsList;

        public LoadedTopicList(String loadedPageIndex, List<TopicsVO> loadTopics) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadTopicsList = loadTopics;
        }

        public String getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<TopicsVO> getLoadTopicsList() {
            return loadTopicsList;
        }
    }
}

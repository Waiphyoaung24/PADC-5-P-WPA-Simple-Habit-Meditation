package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.Events;

import java.util.List;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.components.SharedParent;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CategoriesVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.CurrentProgramsVO;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.vo.TopicsVO;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class RestApiEvent {
    public static class EmptyResponseEvent {


    }

    public static class SuccessEvent {
        private List<SharedParent> successData;

        public SuccessEvent(List<SharedParent> successData) {
            this.successData = successData;
        }

        public List<SharedParent> getSuccessData() {
            return successData;
        }
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

        private List<TopicsVO> loadTopicsList;

        public LoadedTopicList(List<TopicsVO> loadTopics) {
            this.loadTopicsList = loadTopics;
        }


        public List<TopicsVO> getLoadTopicsList() {
            return loadTopicsList;
        }

    }

    public static class LoadedCurrentProgramList {
        private CurrentProgramsVO currentProgramsVOList;

        public LoadedCurrentProgramList(CurrentProgramsVO currentProgramsVOList) {
            this.currentProgramsVOList = currentProgramsVOList;
        }

        public CurrentProgramsVO getCurrentProgramsVOList() {
            return currentProgramsVOList;
        }
    }

    public static class LoadedCategoriesList {
        private List<CategoriesVO> categoriesVOList;

        public LoadedCategoriesList(List<CategoriesVO> categoriesVOList) {
            this.categoriesVOList = categoriesVOList;
        }

        public List<CategoriesVO> getCategoriesVOList() {
            return categoriesVOList;
        }
    }
}

package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities;

import android.app.Application;
import android.util.Log;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.data.model.UserModel;

/**
 * Created by WaiPhyoAg on 5/16/18.
 */

public class MeditationApp extends Application {

    public static final String PROGRAM_ID ="ProgramId";
    public static final String CATEGORY_ID = "CategoryId";
    public static final String IE_PROGRAM_NAME = "IE_PROGRAM_NAME";
    public static final String IE_PROGRAM_ID = "programId";
    public static final String IE_CATEGORY_ID = "categoryId";
    public static final String Current_Program="currentProgram";
    public static final String Category="category";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}

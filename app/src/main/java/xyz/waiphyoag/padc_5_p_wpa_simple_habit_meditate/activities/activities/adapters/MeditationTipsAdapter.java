package xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.R;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.FirstTipsViewHolder;
import xyz.waiphyoag.padc_5_p_wpa_simple_habit_meditate.activities.activities.viewholders.ItemMeditationTipsViewHolder;

/**
 * Created by WaiPhyoAg on 5/17/18.
 */

public class MeditationTipsAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.item_meditation_tips,parent,false);
        ItemMeditationTipsViewHolder itemMeditationTipsViewHolder=new ItemMeditationTipsViewHolder(view);
        return  itemMeditationTipsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}

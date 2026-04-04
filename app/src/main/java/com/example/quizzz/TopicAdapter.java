package com.example.quizzz;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends BaseAdapter {
    private final Context context;
    private final List<Topic> topics;

    public TopicAdapter(Context context, List<Topic> topics) {
        this.context = context;
            this.topics = topics == null ? new ArrayList<Topic>() : topics;
    }


    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int position) {
        return topics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_topic, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.topicTitle);
            holder.desc = convertView.findViewById(R.id.topicDescription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Topic topic = topics.get(position);
        holder.title.setText(topic.getTitle());
        holder.desc.setText(topic.getDescription());

        return convertView;
    }

    public Context getContext() {
        return context;
    }
    static class ViewHolder {
        TextView title, desc;
    }
}

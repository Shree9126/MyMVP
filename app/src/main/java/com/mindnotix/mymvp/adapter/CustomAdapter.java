package com.mindnotix.mymvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mindnotix.mymvp.R;
import com.mindnotix.mymvp.listener.IBaseCallBack;
import com.mindnotix.mymvp.model.User;

import java.util.ArrayList;

/**
 * Created by Admin on 3/24/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private static final String TAG = CustomAdapter.class.getSimpleName();
    IBaseCallBack iBaseCallBack;
    ArrayList<User> userArrayList;

    public CustomAdapter(IBaseCallBack iBaseCallBack, ArrayList<User> userArrayList) {
        this.iBaseCallBack = iBaseCallBack;
        this.userArrayList = userArrayList;
        Log.d(TAG, "CustomAdapter:userArrayList.size " + userArrayList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        User user = userArrayList.get(position);
        Log.d(TAG, "onBindViewHolder:getName "+user.getName());
        holder.UserId.setText(user.getId());
        holder.UserName.setText(user.getName());
        holder.UserBody.setText(user.getBody());
        holder.itemView.setTag(user);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public void onReferesh(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private android.widget.TextView UserId;
        private android.widget.TextView UserName;
        private android.widget.TextView UserBody;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.UserBody = (TextView) view.findViewById(R.id.UserBody);
            this.UserName = (TextView) view.findViewById(R.id.UserName);
            this.UserId = (TextView) view.findViewById(R.id.UserId);
        }

        @Override
        public void onClick(View v) {
            iBaseCallBack.onclick((User) v.getTag());
        }
    }
}

package com.mindnotix.mymvp.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.mindnotix.mymvp.R;
import com.mindnotix.mymvp.adapter.CustomAdapter;
import com.mindnotix.mymvp.contract.MainContract;
import com.mindnotix.mymvp.databinding.ActivityMainBinding;
import com.mindnotix.mymvp.listener.IBaseCallBack;
import com.mindnotix.mymvp.model.User;
import com.mindnotix.mymvp.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainContract.View, IBaseCallBack {

    private static final String TAG = MainActivity.class.getSimpleName();
    MainContract.Presenter mIMainPresenter;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mIMainPresenter = new MainPresenter(this, this);
        mIMainPresenter.onCreatePresenter(getIntent().getExtras());
    }


    @Override
    public void initialization() {
        Log.d(TAG, "initialization: ");
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setRecyclerViewAdapter(CustomAdapter customAdapter) {
        activityMainBinding.recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onclick(Object o) {
        if (o instanceof User) {
            Toast.makeText(this, "" + ((User) o).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}

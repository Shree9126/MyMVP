package com.mindnotix.mymvp.presenter;

import android.os.Bundle;
import android.util.Log;

import com.mindnotix.mymvp.adapter.CustomAdapter;
import com.mindnotix.mymvp.contract.MainContract;
import com.mindnotix.mymvp.listener.IBaseCallBack;
import com.mindnotix.mymvp.model.User;

import java.util.ArrayList;

/**
 * Created by Admin on 3/24/2018.
 */

public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private MainContract.View mIMainView;
    private IBaseCallBack iBaseCallBack;
    private CustomAdapter customAdapter;
    private ArrayList<User> userArrayList = new ArrayList<>();

    public MainPresenter(MainContract.View view, IBaseCallBack iBaseCallBack) {
        super(view);
        this.mIMainView = view;
        this.iBaseCallBack = iBaseCallBack;
    }


    @Override
    public void onCreatePresenter(Bundle bundle) {

        userArrayList.add(new User("1", "Shree", "Gud Boy"));
        userArrayList.add(new User("2", "Guru", "Bad Boy"));
        userArrayList.add(new User("3", "Ramesh", "Gud Boy"));
        userArrayList.add(new User("4", "Suresh", "Bad Boy"));
        userArrayList.add(new User("5", "Ravi", "Bad Boy"));
        userArrayList.add(new User("6", "Mohan", "Bad Boy"));
        userArrayList.add(new User("7", "Shiva", "Gud Boy"));
        userArrayList.add(new User("8", "Dinesh", "Bad Boy"));
        userArrayList.add(new User("9", "Senthil", "Gud Boy"));

        Log.d(TAG, "onCreatePresenter: " + userArrayList.size());

        mIMainView.initialization();
        mIMainView.ShowProgress();
        mIMainView.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callAdapter();
            }
        }, 3000);


    }

    private void callAdapter() {

        mIMainView.DimissProgress();
        if (customAdapter == null) {
            customAdapter = new CustomAdapter(iBaseCallBack, userArrayList);
            mIMainView.setRecyclerViewAdapter(customAdapter);
        } else {
            customAdapter.onReferesh(userArrayList);
        }

    }
}

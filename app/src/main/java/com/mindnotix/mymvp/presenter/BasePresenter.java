package com.mindnotix.mymvp.presenter;

import android.content.Intent;

import com.mindnotix.mymvp.contract.BaseContract;
import com.mindnotix.mymvp.contract.MainContract;

/**
 * Created by Admin on 3/24/2018.
 */

public abstract class BasePresenter implements MainContract.Presenter {


    BaseContract.View view;

    public BasePresenter(BaseContract.View view) {
        this.view = view;
        view.bindPresenter(this);
    }

    @Override
    public void onStartPresenter() {

    }

    @Override
    public void onStopPresenter() {

    }

    @Override
    public void onPausePresenter() {

    }

    @Override
    public void onResumePresenter() {

    }

    @Override
    public void onDestroyPresenter() {

    }

    @Override
    public void onRestartPresenter() {

    }

    @Override
    public void onActivityResultPresenter(int requestCode, int resultCode, Intent data) {

    }

}

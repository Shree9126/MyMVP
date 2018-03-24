package com.mindnotix.mymvp.contract;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mindnotix.mymvp.presenter.BasePresenter;

/**
 * Created by Admin on 3/24/2018.
 */

public interface BaseContract {


    interface View {

        void showMessage(String msg);

        Handler getHandler();

        Activity getActivity();

        void bindPresenter(BasePresenter basePresenter);

        void ShowProgress();

        void DimissProgress();
    }

    interface Presenter{


        void onCreatePresenter(Bundle bundle);

        void onStartPresenter();

        void onStopPresenter();

        void onPausePresenter();

        void onResumePresenter();

        void onDestroyPresenter();

        void onRestartPresenter();

        void onActivityResultPresenter(int requestCode, int resultCode, Intent data);
    }
}

package com.mindnotix.mymvp.view.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mindnotix.mymvp.contract.BaseContract;
import com.mindnotix.mymvp.presenter.BasePresenter;

/**
 * Created by Admin on 3/24/2018.
 */

public class BaseActivity extends AppCompatActivity implements BaseContract.View {

    Handler mHandler;
    ProgressDialog mProgressDialog;
    BasePresenter basePresenter;

    @Override
    public void showMessage(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Handler getHandler() {

        synchronized (this) {
            if (mHandler == null)
                mHandler = new Handler();
        }
        return mHandler;
    }

    @Override
    public Activity getActivity() {
        return BaseActivity.this;
    }

    @Override
    public void bindPresenter(BasePresenter basePresenter) {
        this.basePresenter = basePresenter;
    }

    @Override
    public void ShowProgress() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.show();
    }

    @Override
    public void DimissProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (basePresenter != null)
            basePresenter.onDestroyPresenter();
    }
}

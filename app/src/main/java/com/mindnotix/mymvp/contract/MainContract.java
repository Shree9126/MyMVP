package com.mindnotix.mymvp.contract;

import com.mindnotix.mymvp.adapter.CustomAdapter;

/**
 * Created by Admin on 3/24/2018.
 */

public interface MainContract {

    interface View extends BaseContract.View{
        void setRecyclerViewAdapter(CustomAdapter customAdapter);
        void initialization();
    }

    interface Presenter extends BaseContract.Presenter {


    }
}

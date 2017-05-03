package com.huweiqiang.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by huweiqiang on 2017/5/2.
 */

public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        Injector.inject();
    }
}

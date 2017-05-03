package com.huweiqiang.base;


import android.app.Activity;

import java.util.Map;

/**
 * Created by huweiqiang on 2017/5/2.
 */

public interface GroupLoader {
    Map<String, GroupLoader> injectModule();

    Map<String, Class<? extends IService>> injectService();

    Class<? extends Activity> getActivity(String activityName);
}

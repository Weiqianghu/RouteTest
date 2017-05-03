package com.huweiqiang.main;

import android.app.Activity;

import com.huweiqiang.base.IService;
import com.huweiqiang.base.GroupLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huweiqiang on 2017/5/2.
 */

public class MainGroupLoader implements GroupLoader {
    private Map<String, Class<? extends Activity>> sActivityMap;

    @Override
    public Map<String, GroupLoader> injectModule() {
        Map<String, GroupLoader> result = new HashMap<>();

        result.put("main", new MainGroupLoader());
        return result;
    }

    @Override
    public Map<String, Class<? extends IService>> injectService() {
        return null;
    }

    @Override
    public Class<? extends Activity> getActivity(String activityName) {
        if (sActivityMap == null) {
            sActivityMap = new MainActivityLoader().injectActivity();
        }
        if (sActivityMap == null) {
            throw new IllegalStateException(activityName + "not found!");
        }

        return sActivityMap.get(activityName);
    }
}

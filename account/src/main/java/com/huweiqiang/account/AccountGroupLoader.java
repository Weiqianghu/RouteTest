package com.huweiqiang.account;

import android.app.Activity;

import com.huweiqiang.base.AccountUtil;
import com.huweiqiang.base.IService;
import com.huweiqiang.base.GroupLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huweiqiang on 2017/5/2.
 */

public class AccountGroupLoader implements GroupLoader {
    private Map<String, Class<? extends Activity>> sActivityMap;

    @Override
    public Map<String, GroupLoader> injectModule() {
        Map<String, GroupLoader> result = new HashMap<>();

        result.put("account", new AccountGroupLoader());
        return result;
    }

    public Map<String, Class<? extends IService>> injectService() {
        Map<String, Class<? extends IService>> serviceMap = new HashMap<>();
        serviceMap.put(AccountUtil.class.getSimpleName(), AccountUtilImpl.class);
        return serviceMap;
    }

    @Override
    public Class<? extends Activity> getActivity(String activityName) {
        if (sActivityMap == null) {
            sActivityMap = new AccountActivityLoader().injectActivity();
        }
        if (sActivityMap == null) {
            throw new IllegalStateException(activityName + "not found!");
        }

        return sActivityMap.get(activityName);
    }
}

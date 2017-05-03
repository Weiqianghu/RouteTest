package com.huweiqiang.main;

import android.app.Activity;

import com.huweiqiang.base.ActivityLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huweiqiang on 2017/5/2.
 */

public class MainActivityLoader implements ActivityLoader {
    @Override
    public  Map<String, Class<? extends Activity>> injectActivity() {
        Map<String, Class<? extends Activity>> result = new HashMap<>();

        result.put("HomeActivity", HomeActivity.class);

        return result;
    }
}

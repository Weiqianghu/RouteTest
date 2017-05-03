package com.huweiqiang.base;

import android.app.Activity;

import java.util.Map;

/**
 * Created by huweiqiang on 2017/5/2.
 */

public interface ActivityLoader {
    Map<String, Class<? extends Activity>> injectActivity();
}

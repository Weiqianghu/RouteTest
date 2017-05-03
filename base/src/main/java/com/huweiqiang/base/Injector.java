package com.huweiqiang.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huweiqiang on 2017/4/25.
 */

class Injector {

    private static Map<String, GroupLoader> sModuleLoaderMap = new HashMap<>();
    private static Map<String, Class<? extends IService>> sServiceClassMap = new HashMap<>();
    private static Map<String, IService> sServiceMap = new HashMap<>();

    static void inject() {
        try {
            GroupLoader mainGroupLoader = (GroupLoader) Class.forName("com.huweiqiang.main.MainGroupLoader").newInstance();
            Map<String, GroupLoader> mainModuleLoaderMap = mainGroupLoader.injectModule();
            if (mainModuleLoaderMap != null) {
                sModuleLoaderMap.putAll(mainModuleLoaderMap);
            }
            Map<String, Class<? extends IService>> mainServiceMap = mainGroupLoader.injectService();
            if (mainServiceMap != null) {
                sServiceClassMap.putAll(mainServiceMap);
            }

            GroupLoader mineGroupLoader = (GroupLoader) Class.forName("com.huweiqiang.mine.MineGroupLoader").newInstance();
            Map<String, GroupLoader> mineModuleLoaderMap = mineGroupLoader.injectModule();
            if (mineModuleLoaderMap != null) {
                sModuleLoaderMap.putAll(mineModuleLoaderMap);
            }
            Map<String, Class<? extends IService>> mineServiceMap = mineGroupLoader.injectService();
            if (mineServiceMap != null) {
                sServiceClassMap.putAll(mineServiceMap);
            }

            GroupLoader accountGroupLoader = (GroupLoader) Class.forName("com.huweiqiang.account.AccountGroupLoader").newInstance();
            Map<String, GroupLoader> accountModuleMap = accountGroupLoader.injectModule();
            if (accountModuleMap != null) {
                sModuleLoaderMap.putAll(accountModuleMap);
            }
            Map<String, Class<? extends IService>> accountServiceMap = accountGroupLoader.injectService();
            if (accountServiceMap != null) {
                sServiceClassMap.putAll(accountServiceMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static GroupLoader getModuleLoader(String moduleName) {
        return sModuleLoaderMap.get(moduleName);
    }

    static IService getService(String serviceName) {
        if (sServiceMap.get(serviceName) != null) {
            return sServiceMap.get(serviceName);
        }

        if (sServiceClassMap.get(serviceName) != null) {
            try {
                sServiceMap.put(serviceName, sServiceClassMap.get(serviceName).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sServiceMap.get(serviceName);
    }
}

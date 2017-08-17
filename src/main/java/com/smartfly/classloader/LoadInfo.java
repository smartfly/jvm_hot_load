package com.smartfly.classloader;

/**
 * Created with IntelliJ IDEA.
 * User: hutao01
 * Date: 2017/8/16
 * Time: 11:32
 * Description: 封装加载的类信息
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class LoadInfo {

    private MyClassLoader myLoader;
    private long loadTime;
    private BaseManager manager;

    public LoadInfo(MyClassLoader myLoader, long loadTime) {
        this.myLoader = myLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyLoader() {
        return myLoader;
    }

    public void setMyLoader(MyClassLoader myLoader) {
        this.myLoader = myLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}

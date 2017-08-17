package com.smartfly.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: hutao01
 * Date: 2017/8/16
 * Time: 13:54
 * Description: 动态加载Manager的工厂类
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class ManagerFactory {

    /*记录热加载类的加载信息*/
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<String, LoadInfo>();

    public static final String  CLASS_PATH = "D:/";

    public static final String MY_MANAGER = "com.smartfly.classloader.MyManager";

    public static BaseManager getManager(String className){
        System.out.println(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();

        /*查看是否被加载过，如果没有被加载则加载*/
        if (loadTimeMap.get(className) == null){
            load(className, lastModified);
        } else if (loadTimeMap.get(className).getLoadTime() != lastModified){
            /*如果被加载过，查看加载时间，如果该类已经被修改，则重新加载*/
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getManager();
    }

    private static void load(String className, long lastModified){
        MyClassLoader myLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo2 = new LoadInfo(myLoader, lastModified);
        loadInfo2.setManager(manager);
        loadTimeMap.put(className, loadInfo2);
    }

    private static BaseManager newInstance(Class<?> cls) {
        try {
            return (BaseManager) cls.getConstructor(new Class[] {}).newInstance(new Object[] {});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

}

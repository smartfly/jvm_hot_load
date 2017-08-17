package com.smartfly.classloader;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: hutao01
 * Date: 2017/8/16
 * Time: 14:20
 * Description: 开启线程不断刷新重新加载类
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class MsgHandler implements Runnable{

    public void run() {
        while (true){
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}

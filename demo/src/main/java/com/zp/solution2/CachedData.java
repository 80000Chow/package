package com.zp.solution2;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.*;


import static java.util.concurrent.locks.ReentrantReadWriteLock.*;


/**
 * @author 80000Chow
 * @date 2020/5/13 17:36
 * //
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                           O\  =  /O
 * //                        ____/`---'\____
 * //                      .'  \\|     |//  `.
 * //                     /  \\|||  :  |||//  \
 * //                    /  _||||| -:- |||||-  \
 * //                    |   | \\\  -  /// |   |
 * //                    | \_|  ''\---/''  |   |
 * //                    \  .-\__  `-`  ___/-. /
 * //                  ___`. .'  /--.--\  `. . __
 * //               ."" '<  `.___\_<|>_/___.'  >'"".
 * //              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * //              \  \ `-.   \_ __\ /__ _/   .-` /  /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * //                     Buddha Bless, No Bug !
 */

public class CachedData {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private ReadLock readLock = readWriteLock.readLock();
    private WriteLock writeLock = readWriteLock.writeLock();

    public void processCachedData(String key) {

        Map cache = new ConcurrentHashMap(16);

        try {
            readLock.lock();
            String o = (String) cache.get(key);
            if (null == o) {
                readLock.unlock();
                try {
                    writeLock.lock();
                    String result = (String) cache.get(key);
                    if (null == result) {
                        result = Math.random() + "更新了缓存";
                        cache.put(key, result);
                    }
                    readLock.lock();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            } else {
                System.out.println("缓存值为：" + o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }
}

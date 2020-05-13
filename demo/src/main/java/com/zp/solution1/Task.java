package com.zp.solution1;

/**
 * @author 80000Chow
 * @date 2020/5/13 17:04
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
public class Task implements Executor{
    private String name;
    private int state;

    public Task( String name, int state) {
        this.name = name;
        this.state = state;
    }

    public boolean execute() {
        System.out.println(name +" ");
        state = 1;
        return true;
    }

    public boolean hasExecuted() {
        return state == 1;
    }
}

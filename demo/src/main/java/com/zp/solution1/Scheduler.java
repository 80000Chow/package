package com.zp.solution1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 80000Chow
 * @date 2020/5/13 17:16
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
public class Scheduler {
    public void schedule(Digraph digraph) {
     while (true) {
        List<Task> todo = new ArrayList<Task>();
        for (Task task : digraph.getTasks()) {
            if (!task.hasExecuted()) {
                Set<Task> prevs = digraph.getMap().get(task);
                if (prevs != null && !prevs.isEmpty()) {
                    boolean toAdd = true;
                    for (Task task1 : prevs) {
                        if (!task1.hasExecuted()) {
                            toAdd = false;
                            break;
                        }
                    }
                    if (toAdd) {
                        todo.add(task);
                    }
                } else {
                    todo.add(task);
                }
            }
        }
        if (!todo.isEmpty()) {
            for (Task task : todo) {
                if (!task.execute()) {
                    throw new RuntimeException();
                }
            }
        } else {
            break;
        }
    }
}

    public static void main(String[] args) {
        Digraph digraph = new Digraph();
        Task taskA = new Task( "任务 A", 0);
        Task taskB = new Task( "任务 B", 0);
        Task taskC = new Task( "任务 C", 0);
        Task taskD = new Task( "任务 D", 0);
        Task taskE = new Task( "任务 E", 0);
        Task taskF = new Task( "任务 F", 0);
        Task taskG = new Task( "任务 G", 0);
        Task taskH = new Task( "任务 H", 0);
        digraph.addTask(taskA);
        digraph.addTask(taskB);
        digraph.addTask(taskC);
        digraph.addTask(taskD);
        digraph.addTask(taskE);
        digraph.addTask(taskF);
        digraph.addTask(taskG);
        digraph.addTask(taskH);
        digraph.addEdge(taskC, taskH);
        digraph.addEdge(taskA, taskC);
        digraph.addEdge(taskD, taskA);
        digraph.addEdge(taskF, taskD);
        digraph.addEdge(taskG,taskB);
        digraph.addEdge(taskA,taskG);
        digraph.addEdge(taskE,taskG);
        digraph.addEdge(taskE,taskB);
        digraph.addEdge(taskF,taskE);
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(digraph);
    }

}

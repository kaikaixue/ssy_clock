package com.soft.generics.dao;

import com.soft.generics.entity.Worker;

import java.util.Objects;

public class WorkerDao extends BaseDao<Worker> {
    /**
     * 静态成员变量workerDaoInstance，所有WorkerDao对象共享
     */
    private static WorkerDao workerDaoInstance = null;

    /**
     * 构造方法私有，外部不能通过new来生成WorkerDao的实例
     */
    private WorkerDao() {

    }

    public static WorkerDao getWorkerDaoInstance() {
        if (Objects.isNull(workerDaoInstance)) {
            workerDaoInstance = new WorkerDao();
        }
        return workerDaoInstance;
    }
}

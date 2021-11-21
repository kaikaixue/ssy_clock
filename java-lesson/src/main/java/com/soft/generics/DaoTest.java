package com.soft.generics;

import com.soft.generics.dao.WorkerDao;
import com.soft.generics.entity.Worker;

public class DaoTest {
    public static void main(String[] args) {
        // 获取WorkerDao实例
        WorkerDao workerDao = WorkerDao.getWorkerDaoInstance();
        // 创建对象并调用相应方法
        // add
        Worker worker = new Worker(111, "Java工程师");
        workerDao.add(worker);
        // find
        System.out.println(workerDao.find(222));
        // update
        workerDao.update(worker);
        // delete
        workerDao.delete(111);
    }
}

package com.github.jsjchai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  库存
 */
public class Inventory {



    private final int inventorySize;
    private final List<Item> items;
    private final Lock lock;


    public Inventory(int inventorySize) {
        this.inventorySize = inventorySize;
        this.items = new ArrayList<>(inventorySize);
        this.lock = new ReentrantLock();
    }


    public boolean addItem(Item item) {
        if (items.size() < inventorySize) {
            lock.lock();
            try {
                if (items.size() < inventorySize) {
                    items.add(item);
                    System.out.println(
                        Thread.currentThread() + ": items.size()=" + items.size() + " inventorySize="
                            + inventorySize);
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    /**
     * 获取所有库存商品
     *
     * @return  返回不可变的所有库存商品
     */
    public final List<Item> getItems() {
        //只读的
        return Collections.unmodifiableList(items);
    }

}

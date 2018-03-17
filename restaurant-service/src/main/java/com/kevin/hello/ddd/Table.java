package com.kevin.hello.ddd;

import com.kevin.hello.common.BaseEntity;

import java.math.BigInteger;

/**
 * 桌子
 */
public class Table extends BaseEntity<BigInteger> {

    private int capacity;

    public Table(BigInteger id, String name, int capacity) {
        super(id, name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

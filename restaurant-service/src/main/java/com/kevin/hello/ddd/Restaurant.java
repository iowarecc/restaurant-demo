package com.kevin.hello.ddd;

import com.kevin.hello.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 餐馆
 */
public class Restaurant extends BaseEntity<String> {

    private List<Table> tables = new ArrayList<>();

    private String address;

    public Restaurant(String id, String name, List<Table> tables) {
        super(id, name);
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "tables=" + tables +
                '}';
    }
}

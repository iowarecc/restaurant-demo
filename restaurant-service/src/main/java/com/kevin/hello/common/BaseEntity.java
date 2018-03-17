package com.kevin.hello.common;

public abstract class BaseEntity<T> extends Entity<T> {

    private T id;
    private String name;
    private final boolean isModified;

    public BaseEntity(T id, String name) {
        this.id = id;
        this.name = name;
        isModified = false;
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public void setId(T id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean modified) {
        isModified = modified;
    }
}

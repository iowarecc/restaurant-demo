package com.kevin.hello.common;

public abstract class ReadOnlyBaseService<TE, T> {

    private final Repository<TE, T> repository;

    public ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }

}

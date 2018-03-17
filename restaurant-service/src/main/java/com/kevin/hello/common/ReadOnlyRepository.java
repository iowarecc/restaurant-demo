package com.kevin.hello.common;

import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

    boolean contains(T id);

    Entity<T> get(T id);

    Collection<TE> getAll();

}

package com.scaler.distributedcache;

import java.util.concurrent.Future;

public interface Cache<V> {  // List<Integer>

    Future<Void> put(String key, V value);

    Future<V> get(String key);

    Future<Void> remove(String key);
}

package com.scaler.distributedcache;

import com.scaler.distributedcache.evictionstrategies.IEvictionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class CacheNode<V> {
    private int id;
    private Map<String, V> cache;
    private IEvictionStrategy evictionStrategy;
    private int limit;
    public CacheNode(IEvictionStrategy evictionStrategy, int limit) {
        cache = new HashMap<>();
        this.evictionStrategy = evictionStrategy;
        this.limit = limit;
    }

    public int getId() {
        return id;
    }


    public Future<V> get(String key) {
        return null;
    }

    public Future<Void> put(String key, V value) {
        return null;
    }

    public Future<Void> remove(String key) {
        cache.remove(key);
        evictionStrategy.notify(key, CacheOperation.DELETE);
        return CompletableFuture.completedFuture(null);
    }
}

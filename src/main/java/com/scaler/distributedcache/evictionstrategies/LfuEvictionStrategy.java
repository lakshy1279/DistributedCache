package com.scaler.distributedcache.evictionstrategies;

import com.scaler.distributedcache.CacheOperation;

public class LfuEvictionStrategy implements IEvictionStrategy {

    @Override
    public void notify(String key, CacheOperation operation) {

    }

    @Override
    public String evict() {
        return null;
    }
}

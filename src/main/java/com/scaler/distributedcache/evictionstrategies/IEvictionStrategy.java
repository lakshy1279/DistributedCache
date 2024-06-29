package com.scaler.distributedcache.evictionstrategies;

import com.scaler.distributedcache.CacheOperation;

public interface IEvictionStrategy {

    void notify(String  key, CacheOperation operation);

    String evict();
}

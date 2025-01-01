package com.example.redisexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheRefreshService {

    private static final Logger logger = LoggerFactory.getLogger(CacheRefreshService.class);
    // This will run every 1 minute (cron expression can be customized)
    @Scheduled(cron = "0 0/1 * * * ?")
    @CacheEvict(value = "users", allEntries = true)
    public void refreshCache() {
        logger.info("Cache refreshed at {}",System.currentTimeMillis());
    }
}

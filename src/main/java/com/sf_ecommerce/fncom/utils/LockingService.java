package com.sf_ecommerce.fncom.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@RequiredArgsConstructor
@Slf4j
public class LockingService {
    private final String lockingGroup;
    private final TransactionTemplate transactionTemplate;

    private final Map<String, ReentrantLock> lockMap = new ConcurrentHashMap<>();

    // 30 seconds is acceptable for waiting
    private static final Integer MAX_WAITING_TIME_MS = 30_000;

    public ReentrantLock getLock(String id) {
        return lockMap.computeIfAbsent(id, lockingId -> new ReentrantLock(true));
    }

    public void acquireLock(String id) {
        log.debug("Trying to lock by {} in {} group.", id, lockingGroup);
        getLock(id).lock();
    }

    public boolean acquireLock(String id, long milliseconds) {
        try {
            log.debug("Trying to lock by {} in {} group.", id, lockingGroup);
            return getLock(id).tryLock(milliseconds, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.error("Something went wrong when locking.", e);
        }
        return false;
    }


    public boolean isLocked(String id) {
        ReentrantLock lock = lockMap.get(id);
        return lock != null && lock.isLocked();
    }

    public void releaseLock(String id) {
        log.debug("Trying to unlock by {} in {} group.", id, lockingGroup);
        if (lockMap.get(id).isHeldByCurrentThread()) {
            lockMap.get(id).unlock();
        }
    }

    public void handleSafely(String id, LockSafeRunner lockSafeRunnable) {
        acquireLock(id, MAX_WAITING_TIME_MS);
        lockSafeRunnable.run();
        releaseLock(id);
    }

    public void handleTransactionSafely(String id, LockSafeRunner lockSafeRunnable) {
        acquireLock(id, MAX_WAITING_TIME_MS);
        transactionTemplate.execute(
                transactionStatus -> {
                    lockSafeRunnable.run();
                    return transactionStatus;
                }
        );
        releaseLock(id);
    }

    public <T> T handleSafely(String id, LockSafeAndReturnRunner<T> lockSafeRunnable) {
        acquireLock(id, MAX_WAITING_TIME_MS);
        T val = lockSafeRunnable.run();
        releaseLock(id);
        return val;
    }

    public interface LockSafeRunner {
        void run();
    }

    public interface LockSafeAndReturnRunner<T> {
        T run();
    }
}
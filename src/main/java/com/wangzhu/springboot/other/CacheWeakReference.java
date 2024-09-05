package com.wangzhu.springboot.other;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * Created by wangz on 2024/8/9 10:59.
 **/
public class CacheWeakReference {

    static class MyObject {
        byte[] dataArr = new byte[3 * 512 * 1024];

        int i;
        String key;

        MyObject(String key) {
            i = new Random().nextInt(100);
//            this.key = key;
            System.out.println("new obj " + i + " " + key);
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize: " + i + " " + key);
            super.finalize();
        }

        @Override
        public String toString() {
            return "MyObject{" +
                    "dataArr=" + Arrays.toString(dataArr) +
                    ", i=" + i +
                    ", key='" + key + '\'' +
                    '}';
        }
    }

    Map<String, MyObject> strongCache = new HashMap<>();

    Map<String, WeakReference<MyObject>> cache = new HashMap<>();

    WeakHashMap<String, MyObject> cacheNew = new WeakHashMap<>();

    MyObject get(String key) {
        WeakReference<MyObject> reference = cache.get(key);
        if (reference != null) {
            MyObject object = reference.get();
            if (object == null) {
                System.out.println(key + " object is null");
            }
            return object;
        }
        System.out.println(key + " not exists");
        return null;
    }

    void put(String key) {
        Reference<? extends MyObject> poll = queue.poll();
        System.out.println("queue: " + (poll == null ? "null" : "not null" + poll.get()));

        MyObject object = new MyObject(key);
        cache.put(key, new WeakReference<>(object, queue));

        strongCache.put(key, object);
    }

    ReferenceQueue<MyObject> queue = new ReferenceQueue<>();


    MyObject getNew(String key) {
        MyObject object = cacheNew.get(key);
        if (object == null) {
            System.out.println(key + " is null");
        }
        return object;
    }

    void putNew(String key) {
        MyObject object = new MyObject(key);
        cacheNew.put(key, object);
    }

    public static void main(String[] args) {
        CacheWeakReference cacheWeakReference = new CacheWeakReference();
        cacheWeakReference.start();
//        cacheWeakReference.startNew();
    }

    void releaseStrong(String key) {
        if (new Random().nextInt(2) < 0) {
            return;
        }
        // 去掉强引用
        strongCache.remove(key);
    }

    void start() {
        final String key = "abc";

        final int size = 6;
        for (int i = 0; i < size; i++) {
            put(key + (i % size));

            releaseStrong(key + (i % size));
        }


        for (int i = 0; i < 100; i++) {
            get(key + (i % size));
        }
    }

    void startNew() {
        final String key = "1qaz";

        final int size = 5;
        for (int i = 0; i < size; i++) {
            putNew(key + (i % size));

            System.out.println(cacheNew);
        }
        for (int i = 0; i < 30; i++) {
            getNew(key + (i % size));
        }
    }
}

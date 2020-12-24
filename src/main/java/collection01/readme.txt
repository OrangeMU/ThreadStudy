1.Vector Hashtable
 -- 基本不用 -- 自带锁

 HashMap TreeMap(有序)

ConcurrentHashMap ConcurrentSkipListMap 并发包下没有TreeMap，是因为对TreeMap进行CAS更新复杂度太高了，所以使用了SkipList实现有序Map

CopyOnWriteArrayList 写时不加锁，Vector读写都加锁。
add时复制出一个新的引用同时新增一个位置供写入，写完之后把引用指向新的
add时加锁，相当于写互斥
用在读特别多，写特别少的情况下（ReadWriteLock这样的概念）
对比会和Collections.synchronizedList() Vector

LinkedBlockingQueue ArrayBlockingQueue DelayQueue(时间上的排序) SynchronousQueue(主要用来两个线程之间传内容，一个) TransferQueue(可以传递内容，可以传递多个)
package LeetCode.Java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {

    public static void main(String[] args) {

    }

    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lru-cache
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 执行用时：45 ms, 在所有 Java 提交中击败了74.59% 的用户
     * 内存消耗：106.6 MB, 在所有 Java 提交中击败了94.71% 的用户
     */
    private static class Solution2 {
        // 数据缓存
        private final Map<Integer, LinkedNode> cache;
        // 缓存的数量
        private final int capacity;
        // 伪头节点
        private final LinkedNode head;
        // 伪尾节点
        private final LinkedNode tail;

        // 当前节点数量
        private int size;

        public Solution2(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            this.head = new LinkedNode();
            this.tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
            // 定义容量，即可确定cache的大小。避免HashMap的扩容。
            this.cache = new HashMap<>(capacity);
        }

        public int get(int key) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            LinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                node = new LinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, node);
                // 添加至双向链表的头部
                addToHead(node);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    node = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(node.key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(LinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(LinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private LinkedNode removeTail() {
            LinkedNode ans = tail.prev;
            removeNode(ans);
            return ans;
        }
    }

    /**
     * 定义双向链表
     */
    private static class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 通过继承{@link LinkedHashMap}实现LRUCache工具类。
     * https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
     */
    private static class Solution1 extends LinkedHashMap<Integer, Integer> {

        protected final int capacity;

        public Solution1(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}

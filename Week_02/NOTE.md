### HashMap

HashMap 是基于 Map 的一个 Hash 结构，平均查找、插入和删除的平均复杂度为 O(1)。那我们主要看一个 HashMap 常用的 put 和 get 方法。

#### put 方法

put 方法中包含两个参数，key 和 value。key 可以为 null。

```
public V put(K key, V value) {    
    return putVal(hash(key), key, value, false, true);
}
```

操作流程图


![](https://user-gold-cdn.xitu.io/2020/4/21/1719d1b90208807c?w=2694&h=2432&f=png&s=342971)

#### get 方法


hashmap 通过 get 方法的 key 来获取 value 值。

```
    public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
```
是通过 getNode 来获取节点内容

```
    /**
     * Implements Map.get and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @return the node, or null if none
     */
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```

![](https://user-gold-cdn.xitu.io/2020/4/21/1719d630bfc24ec9?w=2532&h=1532&f=png&s=239320)


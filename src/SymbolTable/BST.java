package SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

    private Node root;

    protected class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        // 以该节点为根的子树节点总数
        int N;
        // 红黑树中使用
        boolean color;

        Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return x.N;
    }

    @Override
    public void put(Key key, Value value) {
        put(root,key,value);
    }

    private Node put(Node x, Key key, Value value){
        if (x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            x.val = value;
        else if (cmp < 0)
            x.left = put(x.left, key, value);
        else
            x.right = put(x.right, key, value);
        recalculateSize(x);
        return x;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x.val;
        else if (cmp < 0)
            return get(x.left, key);
        else
            return get(x.right, key);
    }


    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x == null)
            return null;
        if (x.left == null)
            return x;
        return min(x.left);
    }


    @Override
    public Key max() {
        return null;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return size(x.left);
        else if (cmp < 0)
            return rank(key, x.left);
        else
            return 1 + size(x.left) + rank(key, x.right);
    }


    @Override
    public List<Key> keys(Key l, Key h) {
        return keys(root, l, h);
    }

    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list = new ArrayList<>();
        if (x == null)
            return list;
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if (cmpL < 0)
            list.addAll(keys(x.left, l, h));
        if (cmpL <= 0 && cmpH >= 0)
            list.add(x.key);
        if (cmpH > 0)
            list.addAll(keys(x.right, l, h));
        return list;
    }



    private void recalculateSize(Node x) {
        x.N = size(x.left) + size(x.right) + 1;
    }
}


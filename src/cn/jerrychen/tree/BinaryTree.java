package cn.jerrychen.tree;


import java.util.Queue;
/*
二叉树
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int size;

    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取树中元素的个数
    public int size() {
        return size;
    }

    //向树中添加元素key-value
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树x中添加key-value,并返回添加元素后新的树
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            size++;
            return new Node(key, value);
        }
        Node node = x;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    //查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        if (key.compareTo(x.key) == 0) return x.value;
        else if (key.compareTo(x.key) < 0) return get(x.left, key);
        else if (key.compareTo(x.key) > 0) return get(x.right, key);
        return null;
    }


    //删除树中key对应的value
    public void delete(Key key) {
        delete(root, key);
    }

    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }

        //x树不为null
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right, key);

        } else if (cmp < 0) {
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left, key);
        } else {
            //如果key等于x结点的键，完成真正的删除结点动作，要删除的结点就是x；

            //让元素个数-1
           size--;
            //得找到右子树中最小的结点
            if (x.right == null) {
                return x.left;
            }

            if (x.left == null) {
                return x.right;
            }

            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            //删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    //变换n结点即可
                    n = n.left;
                }
            }

            //让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minNode;
        }
        return x;

    }

    //查找整个树中最小的键
    public Key min() {
        return min(root).key;
    }

    //在指定树x中找出最小键所在的结点
    private Node min(Node x) {

        //需要判断x还有没有左子结点，如果有，则继续向左找，如果没有，则x就是最小键所在的结点
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    //在整个树中找到最大的键
    public Key max() {
        return max(root).key;
    }

    //在指定的树x中，找到最大的键所在的结点
    public Node max(Node x) {
        return null;
    }

    //获取整个树中所有的键
    public Queue<Key> preErgodic() {
        return null;
    }

    //获取指定树x的所有键，并放到keys队列中
    private void preErgodic(Node x, Queue<Key> keys) {


    }

    //使用中序遍历获取树中所有的键
    public Queue<Key> midErgodic() {
        return null;
    }

    //使用中序遍历，获取指定树x中所有的键，并存放到key中
    private void midErgodic(Node x, Queue<Key> keys) {


    }

    //使用后序遍历，把整个树中所有的键返回
    public Queue<Key> afterErgodic() {
        return null;
    }

    //使用后序遍历，把指定树x中所有的键放入到keys中
    private void afterErgodic(Node x, Queue<Key> keys) {

    }


    //使用层序遍历，获取整个树中所有的键
    public Queue<Key> layerErgodic() {
        return null;
    }


    //获取整个树的最大深度
    public int maxDepth() {
        return maxDepth(root);
    }


    //获取指定树x的最大深度
    private int maxDepth(Node x) {
        if (x==null) return 0;
        return Math.max(maxDepth(x.left),maxDepth(x.right))+1;
    }

}


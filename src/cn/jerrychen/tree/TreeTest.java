package cn.jerrychen.tree;

public class TreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(4, "龟田澳一郎");
        bt.put(1, "小泽澳澳子");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1, "老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        System.out.println(bt.size());
        System.out.println(bt.maxDepth());
        for (int i = 0; i < 100; i++) {
            bt.put(i, "test"+i);
        }
        System.out.println(bt.size());
        System.out.println(bt.maxDepth());

    }
}

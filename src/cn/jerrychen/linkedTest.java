package cn.jerrychen;

public class linkedTest {
    Node head;
    Node cur;

    void add(int num) {
        if (head == null) {
            head = new Node(num);
            cur = head;
        } else {
            cur.next = new Node(num);
            cur = cur.next;
        }

    }

    @Override
    public String toString() {
        String str = "";
        Node n = head;
        while (n != null) {
            str += n.value;
            n = n.next;
        }
        return str;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    static void reveresPrint(Node n, int num) {
        if (num <= 0) System.out.println("越界了");
        Node pre = null, next = n.next, head = n;
        for (int i = 0; i < num; i++) {
            if (n != null) {
                n.next = pre;
                pre = n;
                n = next;
                next = n.next;
            } else {
                System.out.println("越界了");
                return;
            }
        }
        head.next = n;
        System.out.print("转换后：");
        while (pre != null) {
            System.out.print(pre.value);
            pre = pre.next;
        }
    }

    public static void main(String[] args) {
        linkedTest linkedTest = new linkedTest();
        for (int i = 0; i < 5; i++) {
            linkedTest.add(i);
        }
        System.out.println("转换前：" + linkedTest);
        linkedTest.reveresPrint(linkedTest.head, 3);

    }
}

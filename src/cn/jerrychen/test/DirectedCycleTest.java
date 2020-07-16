package cn.jerrychen.test;

import cn.jerrychen.graph.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class DirectedCycleTest {
    public static void main(String[] args) {
        //准备Graph对象
        Digraph G = new Digraph(7);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(0, 4);
        G.addEdge(4, 5);
        G.addEdge(5, 6);

        G.addEdge(6, 1);


      TopoLogical topoLogical=new TopoLogical(G);

        Stack<Integer> s = topoLogical.order();

        for (Integer integer : s) {
            System.out.println(integer);
        }

    }
}

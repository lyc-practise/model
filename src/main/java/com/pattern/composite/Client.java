package com.pattern.composite;

/**
 * 组合模式
 *
 * 组合模式用于树状结构的抽象和整理，将叶子节点和非叶子节点抽象成组件对象
 *
 * 叶子Leaf 和非叶子 Folder 继承组件对象
 *
 * 通过 addChild  removeChild  operate 这几个方法来维护组件之间的结构关系
 *
 * Folder 类的 operate 是通过调用子节点的 operate 来递归实现。
 *
 *
 */
public class Client {

    public static void main(String[] args) {

        Component root = new Folder();
        Component leafA = new Leaf();
        Component folderB = new Folder();
        Component leafB1 = new Leaf();
        Component leafB2 = new Leaf();

        root.add(leafA);
        root.add(folderB);
        folderB.add(leafB1);
        folderB.add(leafB2);

        root.operate();
    }
}

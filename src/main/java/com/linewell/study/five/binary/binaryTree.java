package com.linewell.study.five.binary;

import java.util.Stack;

/**
 * @author xujianhao
 * @version 1.0
 * @description: 二叉树
 * @date 2021/12/2 15:03
 */
public class binaryTree {
    public static class Node{
        public int value;
        public Node right;
        public Node left;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "value: "+value;
        }
    }

    /**
     * 递归遍历二叉树
     * @param head
     */
    public static void traverseRecursion(Node head){
        if(head == null){
            return;
        }
        //先序
        //System.out.println(head);
        traverseRecursion(head.left);
        //中序
        //System.out.println(head);
        traverseRecursion(head.right);
        //后序
        //System.out.println(head);
    }

    /**
     * 非递归遍历二叉树（先序）
     * @param head
     */
    public static void traverseNotRecursion1(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()){
            head = stack.pop();
            System.out.println(head);
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
    }
    /**
     * 非递归遍历二叉树（后序）
     * @param head
     */
    public static void traverseNotRecursion2(Node head){
        if(head == null){
            return;
        }
        Stack<Node> first = new Stack<>();
        Stack<Node> second = new Stack<>();

        first.push(head);
        while (!first.empty()){
            head = first.pop();
            second.push(head);
            if(head.left != null){
                first.push(head.left);
            }
             if(head.right != null){
                 first.push(head.right);
             }
        }
        while (!second.empty()){
            head = second.pop();
            System.out.println(head);
        }
    }
    /**
     * 非递归遍历二叉树（中序）
     * @param head
     */
    public static void traverseNotRecursion3(Node head){
        if(head == null){
            return;
        }
        Stack<Node> first = new Stack<>();
        //head说明有右数
        //head说明有左值
        while (!first.empty() || head != null){
            if(head != null){
                first.push(head);
                head = head.left;
            }else {
                head = first.pop();
                System.out.println(head);
                head = head.right;
            }
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        traverseNotRecursion3(node);
    }
}

package com.linewell.study.link;

import lombok.Data;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xujianhao
 * @version 1.0
 * @description: 单链表
 * @date 2021/11/22 9:11
 */
@Data
public class SingleLink<T extends Comparable> {
    private Node head;
    private int size;

    public class Node {
        private T data;
        private Node next;

        public Node(T vaule ,Node next){
            this.data = vaule;
            this.next = next;
        }
        public Node(T vaule){
            this(vaule,null);
        }

        @Override
        public String toString(){

            return "data = " +this.data+"; next = "+this.next;
        }
    }

    public SingleLink(){
        this.head = null;
        this.size = 0;
    }

    public void addFirst(T value){
        Node node = new Node(value);
        node.next = this.head;
        this.head = node;
        this.size++;
    }
    public void add(T value,int index){
        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("index is error");
        }
        if(index == 0 ){
            this.addFirst(value);
            return;
        }
        Node itemNode = this.head;
        for(int i = 0 ; i < index - 1 ; i++){
            itemNode = itemNode.next;
        }
        itemNode.next = new Node(value,itemNode.next);
        this.size++;
    }
    public void add(T value){
        this.add(value,this.size);
    }

    public T removeFisrt(){
        if(this.head == null){
            return null;
        }
        Node removeItem = this.head;
        this.head = this.head.next;
        this.size--;
        return removeItem.data;
    }
    public T removeLast(){
        if(this.head == null){
            return null;
        }
        if(this.size == 1){
            this.removeFisrt();
        }
        //记录当前节点
        Node cur = this.head;
        //记录要删除结点的前一个结点
        Node per = null;
        while (cur.next != null){
            per = cur;
            cur = cur.next;
        }
        per.next = cur.next;
        this.size--;
        return cur.data;
    }
    public T remove(int index){
        if(index < 0 || index >= size){
            throw new  IllegalArgumentException("index is error");
        }
        if(index == 0){
            return this.removeFisrt();
        }
        //记录当前节点
        Node cur = this.head;
        //记录要删除结点的前一个结点
        Node per = null;
        for(int i = 0 ;i < index;i++){
            per = cur;
            cur = cur.next;
        }
        per.next = cur.next;
        this.size--;
        return cur.data;
    }

    public T checkFirst(){
        if(this.head == null){
            return null;
        }
        return this.head.data;
    }

    public T checkLast(){
        if(this.size == 0){
            return null;
        }
        Node itemNode = this.head;
        if(itemNode.next != null){
            itemNode = itemNode.next;
        }
        return itemNode.data;
    }

    public T check(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index is error");
        }
        if(index == 0){
            return this.checkFirst();
        }
        Node itemNode = this.head;
        for(int i = 0 ; i < index ; i++){
            itemNode = itemNode.next;
        }
        return itemNode.data;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean contains(T t){
        Node cur = this.head;
        while (cur != null){
            if(cur.data.equals(t)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void forEach(){
        if(this.head == null){
            System.out.println("链表无数据");
        }
        Node item = this.head;
        int index = 0;
        while (item != null){
            System.out.println("index: = "+index+"; item: = "+item.data);
            item = item.next;
            index++;
        }
    }

    /**
     * 链表反转
     */
    public void reversal(){
        Stack<Node> stack = new Stack<>();
        if(this.head == null){
            return;
        }
        Node cur = this.head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        this.head = null;
        cur = null;
        while (!stack.empty()){
            if(this.head == null){
                this.head = stack.pop();
                cur = this.head;
            }else {
                cur.next = stack.pop();
                cur = cur.next;
            }
        }
        cur.next = null;
    }
    /**
     * 链表反转2
     */
    public void reversal2(){
        if(this.head == null){
            return;
        }
        Node cur = this.head.next;
        this.head.next = null;
        Node n2 = this.head;
        Node n3 = null;
        while (cur != null ){
            n3 = cur.next;
            cur.next = n2;
            n2 = cur;
            cur = n3;
        }
        this.head = n2;
    }

    /**
     * 判断是否回文结构(栈)
     * @return
     */
    public boolean isReversal(){
        Stack<Node> stack = new Stack<>();
        if(this.size == 0 || this.size == 1){
            return true;
        }
        Node cur = this.head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = this.head;
        boolean falg = false;
        while (!stack.empty()){
            Node pop = stack.pop();
            if(pop.data.equals(cur.data)){
                falg = true;
            }else {
                falg = false;
                return falg;
            }
            cur = cur.next;
        }
        return falg;
    }
    /**
     * 判断是否回文结构（栈减半，快慢指针）
     * @return
     */
    public boolean isReversal2(){
        if(this.size == 0 || this.size == 1){
            return true;
        }
        Node n1 = this.head;
        Node n2 = this.head;
        if(n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (n1.next != null){
            stack.push(n1.next);
            n1 = n1.next;
        }
        n2 = this.head;
        while (!stack.empty()){
            Node item = stack.pop();
            if(!item.data.equals(n2.data)){
                return false;
            }
            n2 = n2.next;
        }
        return true;
    }
    /**
     * 判断是否回文结构（快慢指针）
     * @return
     */
    public boolean isReversal3(){
        if(this.head == null || this.head.next == null){
            return true;
        }
        Node n1 = this.head;
        Node n2 = this.head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = this.head;
        boolean falg = true;
        while (n1 != null && n2 !=null){
            if(!n1.data.equals(n2.data)){
                falg = false;
                break;
            }
            n1= n1.next;
            n2 = n2.next;
        }
        n2 = n3.next;
        n3.next = null;
        n1 = null;
        while (n2 != null){
            n1 = n2.next;
            n2.next = n3;
            n3 = n2;
            n2 = n1;
        }
        return falg;
    }

    /**
     * 将单向链表按某值划分成左边小、中间相等、右边大的形式
     * @return
     */
    public void zoning( T  num){
        Node sStar = null;
        Node sEnd = null;
        Node tStar = null;
        Node tEnd = null;
        Node bStar = null;
        Node bEnd = null;
        Node cur = this.head;
        while (cur != null){
            if(cur.data.compareTo(num) == 0){
                if(tStar == null){
                    tStar = cur;
                }else {
                    tEnd.next = cur;
                }
                tEnd = cur;
            }
            if(cur.data.compareTo(num) > 0){
                if(bStar == null){
                    bStar = cur;
                }else {
                    bEnd.next = cur;
                }
                bEnd = cur;
            }
            if(cur.data.compareTo(num) < 0){
                if(sStar == null){
                    sStar = cur;
                }else {
                    sEnd.next = cur;
                }
                sEnd = cur;
            }
            cur = cur.next;
        }
        this.head = null;

        if(sStar != null){
            sEnd.next = null;
            this.head = sStar;
        }
        if(tStar != null){
            tEnd.next = null;
            if(this.head == null){
                this.head = tStar;
            }else {
                sEnd.next = tStar;
            }
        }
        if(bEnd != null){
            bEnd.next = null;
            if(this.head == null ){
                this.head = bStar;
            }else {
                if(tStar != null){
                    tEnd.next = bStar;
                }else if(sStar != null){
                    sEnd.next = bStar;
                }

            }
        }
    }

}

class Test{
    public static void main(String[] args) {
        SingleLink<Integer> link = new SingleLink<>();
        link.add(12);
        link.add(0);

        link.zoning(9);
        link.forEach();
    }

    /**
     * 给定两个可能有环也可能无环的单链表，头节点head1和head2。请实现一个函数，如果两个链表相交，请返回相交的第一个节点。如果不相交，返回null
     */

    /**
     * 打印有序链表公共部分
     */
    public static void publicPath(SingleLink<Integer> a,SingleLink<Integer> b){
        int aIndex = 0;
        int bIndex = 0;
        ArrayList<Integer> publicPath = new ArrayList<>();
        while (aIndex < a.getSize() && bIndex < b.getSize()){
            if(a.check(aIndex) > b.check(bIndex)){
                bIndex++;
            }else if(a.check(aIndex) < b.check(bIndex)){
                aIndex++;
            }else {
                publicPath.add(a.check(aIndex));
                aIndex++;
                bIndex++;
            }
        }
        publicPath.forEach(e->{
            System.out.println(e);
        });
    }
}

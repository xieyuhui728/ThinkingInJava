package widetype;

/**
 * Created by л��� on 2016/8/21 0021.
 * �÷��ͣ�ʵ���Լ����ڲ���ʽ�洢����
 */
public class LinkedStak<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();//end sentinel ĩ���ڱ�

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStak<String> linkedStak =new LinkedStak<String>();
        for(String s:"Phasers on sun!".split(" ")){
            linkedStak.push(s);
        }
       String s;
        while ((s=linkedStak.pop())!=null){
            System.out.println(s);
        }
    }
}

import java.util.LinkedList;
public class LinkedStack implements IStackable {
    LinkedList<Integer> list;

    public LinkedStack(){
        this.list = new LinkedList<Integer>();
    }
    
    public int size() {
        return this.list.size();
    }

    public void push(int x) {
        this.list.addLast(x);
    }

    public int pop() {
        return this.list.removeLast();
    }
}

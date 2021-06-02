import java.util.ArrayList;
public class ArrayStack implements IStackable {
    ArrayList<Integer> list; 

    public ArrayStack(){
        this.list = new ArrayList<Integer>();
    }

    public int size() {
        return this.list.size();
    }

    public void push(int x) {
        this.list.add(x);
    }

    public int pop() {
        return this.list.remove(this.list.size()-1);
    }
}

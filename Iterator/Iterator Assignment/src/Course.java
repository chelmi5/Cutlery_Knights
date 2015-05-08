import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class Course implements Collection<Object> {
    private Node head;
    private int size;

    public class Node {

        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

        public Object getItem() {
            return this.data;
        }

        public String toString() {
            return this.getItem() + "";
        }
    }

    public CourseIterator iterator(){
        return new CourseIterator(this.head);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public class CourseIterator implements ListIterator<Object>  {

        private Node cur;

        public CourseIterator(Node start) {
            cur = start;
        }

        public void remove(){
            throw new UnsupportedOperationException("Unsupported operation\n");
        }

        public Object next(){
            if(hasNext()){
                Object data = cur.data;
                cur = cur.next;
                return data;
            }
            return null;
        }

        public boolean hasNext(){
            return cur != null;
        }

        public void add(Object e) {
            throw new UnsupportedOperationException("Unsupported operation\n");
        }

        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Unsupported operation\n");
        }

        public int nextIndex() {
            throw new UnsupportedOperationException("Unsupported operation\n");
        }

        public Object previous() {
            throw new UnsupportedOperationException("Unsupported operation\n");
        }

        public int previousIndex() {
            throw new UnsupportedOperationException("Unsupported operation\n");
        }

        public void set(Object e) {
            throw new UnsupportedOperationException("Unsupported operation\n");
        }
    }

    public Course() {
        this.head = new Node(null, null);
        this.size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public void addFirst(Object data){
        this.head.next = new Node(data, this.head.next);
        this.size++;
    }

    public boolean add(Object data) {
        Node cur = this.head;
        if(isEmpty()) {
            addFirst(data);
        }
        else {
            while(cur.next != null)
                cur = cur.next;
            this.size++;
        }
        cur.next = new Node(data, null);
        return true;
    }

    public boolean remove(Object dataToRemove) {
        if (isEmpty())
            return false;

        Node cur, prev;
        for (cur = this.head.next, prev = null; cur != null &&
                !cur.data.equals(dataToRemove); cur = cur.next)
        {
            prev = cur;
        }
        if (cur == null)
            return false;

        if (prev == null)
            this.head.next = this.head.next.next;
        else
            prev.next = cur.next;

        this.size--;
        return true;

    }

    public boolean removeAll(Collection<?> penuts) {
        Iterator<?> stepper = penuts.iterator();
        if(!containsAll(penuts)){
            System.out.println("Removed Some stuff");
            return false;
        }

        if(isEmpty())
            return false;
        else{
            while(stepper.hasNext()){
                remove(stepper.next());
            }
            return true;
        }
    }

    public void add(int index, Object newData) {
        if(index > -1 && index < this.size){
            if(index == 0){
                addFirst(newData);
            }
            else if(index == (this.size -1)) {
                add(newData);
            }
            else{
                Node cur = this.head.next;
                for(int i = 1; i < index; i++){
                    cur = cur.next;
                }
                Node temp = cur.next;
                cur.next = new Node(newData);
                cur.next.next = temp;
                this.size ++;
            }
        }
        else
            System.out.println("Could not be added");
    }
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        else
            return false;
    }

    public String toString()
    {
        String result = "List size is: " + this.size + "\r\n";
        for (Node cur = this.head.next; cur != null; cur = cur.next) {
            result += cur.data + "\r\n";
        }
        return result;
    }

    public boolean contains(Object Item) {
        for(Node cur = this.head.next; cur != null; cur = cur.next)
        {
            if(cur.data.equals(Item)) {
                return true;
            }
        }
        return false;
    }

    public boolean retainAll(Collection<?> Items) {
        if(!containsAll(Items)){
            return false;
        }
        Iterator<?> stepper = iterator();
        while (stepper.hasNext()) {
            if (!Items.contains(stepper.next())) {
                remove(stepper.next());
            }
        }
        return true;
    }

    @Override
    public void clear() {

    }

    public boolean containsAll(Collection<?> Items) {
        Iterator<?> stepper = Items.iterator();
        while (stepper.hasNext())
            if (!contains(stepper.next()))
                return false;
        return true;
    }

    public boolean addAll(Collection<?> Items) {
        Iterator<?> stepper = Items.iterator();
        while (stepper.hasNext())
            add(stepper.next());
        return true;
    }

    public boolean addAll(int index, Collection<?> Items) {
        int counter = 0;
        if(index > this.size) {
            System.out.println("Index is out of bounds");
            return false;
        }

        Iterator<?> stepper = Items.iterator();
        while (stepper.hasNext()){
            add(index + counter, stepper.next());
            counter ++;
        }
        return true;
    }

    public ListIterator<Object> listIterator() {
        return new CourseIterator(this.head.next);
    }

    public ListIterator<Object> listIterator(int index) {
        Node cur = this.head.next;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return new CourseIterator(cur);
    }
}

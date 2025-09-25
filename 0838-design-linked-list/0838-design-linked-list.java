class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int x) {
            this.val = x;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        if (index == 0) {
            return head.val;
        }
        if (index == size) {
            return tail.val;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = tail = new Node(val);
        } else {
            Node node = new Node(val);
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            head = new Node(val);
            tail = head;
            size++;
            return;
        }
        Node node = new Node(val);
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        if (index == 0) {
            if (head == null){
                return;
            }
            head = head.next;
            if (size == 1) tail = null;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (index == size - 1) {
                tail = temp;
            }
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
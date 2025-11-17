class DNode {
    int data;
    DNode prev;
    DNode next;
    
    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    private DNode head;
    private DNode tail;
    private int count;
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }
    
    public void addFirst(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }
    
    public void addLast(int data) {
        DNode newNode = new DNode(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }
    
    public void removeFirst() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        count--;
    }
    
    public void removeLast() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        count--;
    }
    
    public void remove(int data) {
        DNode current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    count--;
                }
                return;
            }
            current = current.next;
        }
    }
    
    public boolean contains(int data) {
        DNode current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void displayReverse() {
        DNode current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
    
    public void clear() {
        head = tail = null;
        count = 0;
    }
    
    public void add(int index, int data) {
        if (index < 0 || index > count) {
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == count) {
            addLast(data);
            return;
        }
        DNode newNode = new DNode(data);
        DNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        count++;
    }
    
    public void removeByIndex(int index) {
        if (index < 0 || index >= count) {
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == count - 1) {
            removeLast();
            return;
        }
        DNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        count--;
    }
    
    public int get(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        DNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public static void main(String[] args) {
        System.out.println("=== DoublyLinkedList - Двусвязный список ===\n");
        
        DoublyLinkedList list = new DoublyLinkedList();
        
        System.out.println("Добавляем элементы в конец: 10, 20, 30");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.print("Список (прямо): ");
        list.display();
        System.out.println("Размер: " + list.size());
        
        System.out.println("\nДобавляем в начало: 5");
        list.addFirst(5);
        System.out.print("Список (прямо): ");
        list.display();
        System.out.print("Список (в обратном порядке): ");
        list.displayReverse();
        
        System.out.println("\nДобавляем элемент 15 в позицию 2");
        list.add(2, 15);
        System.out.print("Список (прямо): ");
        list.display();
        
        System.out.println("\nПроверка наличия элемента 20: " + list.contains(20));
        System.out.println("Проверка наличия элемента 100: " + list.contains(100));
        
        System.out.println("\nПолучение элемента на позиции 1: " + list.get(1));
        
        System.out.println("\nУдаляем первый элемент");
        list.removeFirst();
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nУдаляем последний элемент");
        list.removeLast();
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nУдаляем элемент со значением 15");
        list.remove(15);
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nУдаляем элемент на позиции 1");
        list.removeByIndex(1);
        System.out.print("Список: ");
        list.display();
        System.out.print("В обратном порядке: ");
        list.displayReverse();
        
        System.out.println("\nПуст ли список? " + list.isEmpty());
    }
}
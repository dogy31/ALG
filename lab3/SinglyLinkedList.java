class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;
    private int count;
    
    public SinglyLinkedList() {
        head = null;
        count = 0;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        count++;
    }
    
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
    }
    
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            count--;
        }
    }
    
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            count--;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        count--;
    }
    
    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            count--;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            count--;
        }
    }
    
    public boolean contains(int data) {
        Node current = head;
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
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void clear() {
        head = null;
        count = 0;
    }
    
    public static void main(String[] args) {
        System.out.println("=== SinglyLinkedList - Односвязный список ===\n");
        
        SinglyLinkedList list = new SinglyLinkedList();
        
        System.out.println("Добавляем элементы в конец: 10, 20, 30");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.print("Список: ");
        list.display();
        System.out.println("Размер: " + list.size());
        
        System.out.println("\nДобавляем в начало: 5");
        list.addFirst(5);
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nПроверка наличия элемента 20: " + list.contains(20));
        System.out.println("Проверка наличия элемента 100: " + list.contains(100));
        
        System.out.println("\nУдаляем первый элемент");
        list.removeFirst();
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nУдаляем последний элемент");
        list.removeLast();
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nУдаляем элемент со значением 20");
        list.remove(20);
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nПуст ли список? " + list.isEmpty());
        
        System.out.println("\nОчищаем список");
        list.clear();
        System.out.println("Пуст ли список? " + list.isEmpty());
    }
}
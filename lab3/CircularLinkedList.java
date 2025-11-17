class CNode {
    int data;
    CNode next;
    
    CNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private CNode tail;
    private int count;
    
    public CircularLinkedList() {
        tail = null;
        count = 0;
    }
    
    public void addFirst(int data) {
        CNode newNode = new CNode(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        count++;
    }
    
    public void addLast(int data) {
        CNode newNode = new CNode(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }
    
    public void removeFirst() {
        if (tail == null) {
            return;
        }
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        count--;
    }
    
    public void removeLast() {
        if (tail == null) {
            return;
        }
        if (tail.next == tail) {
            tail = null;
        } else {
            CNode current = tail.next;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = tail.next;
            tail = current;
        }
        count--;
    }
    
    public void remove(int data) {
        if (tail == null) {
            return;
        }
        CNode current = tail.next;
        CNode prev = tail;
        do {
            if (current.data == data) {
                if (current == tail && tail.next == tail) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                count--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
    }
    
    public boolean contains(int data) {
        if (tail == null) {
            return false;
        }
        CNode current = tail.next;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != tail.next);
        return false;
    }
    
    public int size() {
        return count;
    }
    
    public boolean isEmpty() {
        return tail == null;
    }
    
    public void display() {
        if (tail == null) {
            System.out.println();
            return;
        }
        CNode current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
    
    public void clear() {
        tail = null;
        count = 0;
    }
    
    public void rotate() {
        if (tail != null) {
            tail = tail.next;
        }
    }
    
    public boolean find(int data) {
        return contains(data);
    }
    
    public static void main(String[] args) {
        System.out.println("=== CircularLinkedList - Циклический список ===\n");
        
        CircularLinkedList list = new CircularLinkedList();
        
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
        
        System.out.println("\nДобавляем еще в конец: 40");
        list.addLast(40);
        System.out.print("Список: ");
        list.display();
        
        System.out.println("\nПроверка наличия элемента 20: " + list.contains(20));
        System.out.println("Проверка наличия элемента 100: " + list.contains(100));
        
        System.out.println("\nРотация списка (сдвиг вправо на один элемент)");
        list.rotate();
        System.out.print("Список после ротации: ");
        list.display();
        
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
        System.out.println("Размер: " + list.size());
        
        System.out.println("\nОчищаем список");
        list.clear();
        System.out.println("Пуст ли список? " + list.isEmpty());
    }
}
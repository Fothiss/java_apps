package lab3;

public class Ex12_LinkedList {
    private Node head;

    // ==================== МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ ЦИКЛА ====================

    // а) ввод с головы
    public void createHead(int... values) {
        head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new Node(values[i], head);
        }
    }

    // б) ввод с хвоста
    public void createTail(int... values) {
        head = null;
        Node tail = null;
        for (int value : values) {
            Node newNode = new Node(value, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    // в) вывод (возвращается строка)
    public String toString() {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value);
            if (ref.next != null) sb.append(" -> ");
            ref = ref.next;
        }
        return sb.toString();
    }

    // г) добавление элемента в начало списка
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    // д) добавление элемента в конец списка
    public void addLast(int value) {
        if (head == null) {
            head = new Node(value, null);
            return;
        }
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = new Node(value, null);
    }

    // е) вставка элемента с указанным номером (0 - первая позиция)
    public void insert(int index, int value) {
        if (index < 0) return;
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node ref = head;
        for (int i = 0; i < index - 1; i++) {
            if (ref == null) return;
            ref = ref.next;
        }
        if (ref == null) return;
        ref.next = new Node(value, ref.next);
    }

    // ж) удаление элемента с головы списка
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // з) удаление последнего элемента списка
    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    // и) удаление из списка элемента с указанным номером
    public void remove(int index) {
        if (head == null || index < 0) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        Node ref = head;
        for (int i = 0; i < index - 1; i++) {
            if (ref.next == null) return;
            ref = ref.next;
        }
        if (ref.next == null) return;
        ref.next = ref.next.next;
    }

    // ==================== МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ РЕКУРСИИ ====================

    // а) ввод с головы (рекурсивный)
    public void createHeadRec(int... values) {
        head = createHeadRecHelper(values, 0);
    }

    private Node createHeadRecHelper(int[] values, int index) {
        if (index >= values.length) return null;
        return new Node(values[index], createHeadRecHelper(values, index + 1));
    }

    // б) ввод с хвоста (рекурсивный)
    public void createTailRec(int... values) {
        head = createTailRecHelper(values, 0);
    }

    private Node createTailRecHelper(int[] values, int index) {
        if (index >= values.length) return null;
        Node node = new Node(values[index], null);
        node.next = createTailRecHelper(values, index + 1);
        return node;
    }

    // в) вывод (рекурсивный)
    public String toStringRec() {
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        String current = String.valueOf(node.value);
        String next = toStringRecHelper(node.next);
        return next.isEmpty() ? current : current + " -> " + next;
    }

    // ==================== ТЕСТИРОВАНИЕ ====================

    public static void main(String[] args) {
        Ex12_LinkedList list = new Ex12_LinkedList();

        System.out.println("=== МЕТОДЫ С ЦИКЛОМ ===");

        list.createHead(1, 2, 3, 4, 5);
        System.out.println("createHead (1,2,3,4,5): " + list.toString());

        list.createTail(1, 2, 3, 4, 5);
        System.out.println("createTail (1,2,3,4,5): " + list.toString());

        list.addFirst(0);
        System.out.println("addFirst(0): " + list.toString());

        list.addLast(6);
        System.out.println("addLast(6): " + list.toString());

        list.insert(3, 99);
        System.out.println("insert(3, 99): " + list.toString());

        list.removeFirst();
        System.out.println("removeFirst(): " + list.toString());

        list.removeLast();
        System.out.println("removeLast(): " + list.toString());

        list.remove(2);
        System.out.println("remove(2): " + list.toString());

        System.out.println("\n=== МЕТОДЫ С РЕКУРСИЕЙ ===");

        list.createHeadRec(10, 20, 30, 40, 50);
        System.out.println("createHeadRec: " + list.toStringRec());

        list.createTailRec(10, 20, 30, 40, 50);
        System.out.println("createTailRec: " + list.toStringRec());
    }
}


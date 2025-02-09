class Counter {
    static int count = 0;  // Shared across all objects

    Counter() {
        count++;
    }

    static void showCount() {  // Static method
        System.out.println("Count: " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        new Counter();
        new Counter();
        Counter.showCount();  // Call without creating an object
    }
}

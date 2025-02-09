class Task extends Thread {
    private String name;
    public Task(String name) { this.name = name; }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " running: " + i);
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        Task t1 = new Task("Thread 1");
        Task t2 = new Task("Thread 2");
        
        t1.start();  // Start thread 1
        t2.start();  // Start thread 2
    }
}


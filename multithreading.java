package JavaProject1;
import java.util.Scanner;

class ChatUser extends Thread {
    private String userName;
    private int messageCount;
    private boolean paused = false;
    private boolean stopped = false;

    public ChatUser(String name, int count, int priority) {
        this.userName = name;
        this.messageCount = count;
        setPriority(priority);
    }
    public void run() {
        try {
            for (int i = 1; i<= messageCount;i++) {
                synchronized (this) {
                    while (paused) {
                        wait();
                    }
                }
                if (stopped) {
                    System.out.println(userName + "stopped");
                    break;
                }
                System.out.println(userName+"sent message"+i);
                Thread.sleep(1000);
            }
            if (!stopped) {
                System.out.println(userName + "finished sending all messages");
            }
        } catch (InterruptedException e) {
            System.out.println(userName + "interrupted");
        }
    }
    public synchronized void pauseThread() {
        paused = true;
        System.out.println("Paused"+ userName);
    }
    public synchronized void resumeThread() {
        paused = false;
        notify();
        System.out.println("[System] Resumed " + userName);
    }
    public void stopThread() {
        stopped = true;
        synchronized (this) {
            paused = false;
            notify();
        }
    }
}

public class multithreading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChatUser user1 = null; 
        ChatUser user2 = null;

        while (true) {
            try {
                System.out.println("\n-- CHAT MENU --");
                System.out.println("1. Start Chat ");
                System.out.println("2. Pause Chat");
                System.out.println("3. Resume Chat");
                System.out.println("4. Stop Chat");
                System.out.println("5. Cheack Thread Status");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
             
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        if (user1 == null || !user1.isAlive()) {
                            user1 = new ChatUser("VIRAT", 10, 8);
                            user2 = new ChatUser("ROHIT", 10, 5);
                            user1.start();
                            user2.start();
                            System.out.println(" Chats Started VIRAT and ROHIT");
                        } else {
                            System.out.println("Threads are already running!");
                        }
                        break;
                    case 2:
                        if (user1 != null && user1.isAlive()) {
                            user1.pauseThread();
                        } else {
                            System.out.println("VIRAT is not actively running.");
                        }
                        break;
                    case 3:	
                        if (user1 != null && user1.isAlive()) {
                            user1.resumeThread();
                        } else {
                            System.out.println("ROHIT is not actively running.");
                        }
                        break;
                    case 4:
                        if (user1 != null && user1.isAlive()) {
                            user1.stopThread();
                        } else {
                            System.out.println("VIRAT is not running.");
                        }
                        break;
                    case 5:
                        if (user2 != null && user2.isAlive()) {
                            user2.stopThread();
                        } else {
                            System.out.println("ROHIT is not running.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting application...");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
            }
        }
    }
}

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        for (int i = 0; i < 1000; i++) {
            Runnable runnable = () -> {
                app.sendMail();
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public void sendMail() {
        try {
            System.out.println("email sent by started by thread: " + Thread.currentThread().getName());
            Thread.sleep(8000);
            System.out.println("email sent by ended by thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
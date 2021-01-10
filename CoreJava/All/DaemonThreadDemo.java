package mt;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am daemon running in backend...");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){}
                System.out.println("I am done...");
            }
        });
        t.setDaemon(true);
        t.start();
    }
}

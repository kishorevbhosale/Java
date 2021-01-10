package mt;

class Customer{
    int amount=1000;

    synchronized void withdraw(int amount){
        System.out.println("going to withdraw...");
        if (this.amount<amount){
            System.out.println("Less balance; waiting for deposit.....");
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.amount -= amount;
        System.out.println("Withdraw operation completed.........");
    }

    synchronized void deposite(int amount){
        System.out.println("going to deposit...");
        this.amount+=amount;
        System.out.println("deposit completed... ");
        notify();
    }
}
public class WaitNotifyDemo1 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                customer.withdraw(15000);
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                customer.deposite(15000);
            }
        });
        thread.start();
        thread1.start();
    }
}

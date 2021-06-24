package cn.edu.bupt.thread;

public class Main {
    public static void main(String[] args) {

        Data data = new Data();

        new Thread(() ->{
            for (int i = 0; i < 50; i++) {
                try {
                    data.even();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T1").start();

        new Thread(() ->{
            for (int i = 0; i < 50; i++) {
                try {
                    data.odd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2").start();
    }
}

class Data{
    int nums = 100;

    public synchronized void even() throws InterruptedException {
        if(nums % 2 != 0){
            //等待并释放锁
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + "=>" + nums);
        nums--;
        this.notifyAll();
    }


    public synchronized void odd() throws InterruptedException {
        if(nums % 2 == 0){
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + "=>" + nums);
        nums--;
        this.notifyAll();
    }

}

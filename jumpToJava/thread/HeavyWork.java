package jumpToJava.thread;

public class HeavyWork implements Runnable{

    private String name;

    public HeavyWork(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
        System.out.printf("%s done. \n", this.name);
    }
}

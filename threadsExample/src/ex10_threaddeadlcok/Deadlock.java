package ex10_threaddeadlcok;

public class Deadlock {

    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alice =
                new Friend("Alice");
        final Friend bob =
                new Friend("Bob");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // System.out.println("Thread 1");
            //    synchronized (bob){
                    alice.bow(bob);
              //  }
                // System.out.println("Th: gaston bowed to alphonse");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //  System.out.println("Thread 2");

                bob.bow(alice);
                //  System.out.println("2.gaston waiting alph bowed");
            }
        }).start();
    }
}

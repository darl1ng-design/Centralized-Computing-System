public class StatisticsReport implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            synchronized (Statistics.class) {
                System.out.println("---- Statistics ----");
                System.out.println("Total clients connected: " + Statistics.getTotalClients());
                System.out.println("Total operations: " + Statistics.getTotalOperations());
                System.out.println("ADD operations: " + Statistics.getAddCount());
                System.out.println("SUB operations: " + Statistics.getSubCount());
                System.out.println("MUL operations: " + Statistics.getMulCount());
                System.out.println("DIV operations: " + Statistics.getDivCount());
                System.out.println("Invalid operations: " + Statistics.getInvalidOperations());
                System.out.println("Sum of results: " + Statistics.getResultSum());
                System.out.println("--------------------");
            }
        }
    }
}
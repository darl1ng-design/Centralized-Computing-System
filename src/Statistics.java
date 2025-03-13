public class Statistics {
    private static int totalClients = 0;
    private static int totalOperations = 0;
    private static int invalidOperations = 0;
    private static int addCount = 0;
    private static int subCount = 0;
    private static int mulCount = 0;
    private static int divCount = 0;
    private static long resultSum = 0;

    public static synchronized void incrementClientNumber() {
        totalClients++;
    }

    public static synchronized void incrementError() {
        invalidOperations++;
        totalOperations++;
    }

    public static synchronized void incrementAddNumber() {
        addCount++;
        totalOperations++;
    }

    public static synchronized void incrementSubNumber() {
        subCount++;
        totalOperations++;
    }

    public static synchronized void incrementMulNumber() {
        mulCount++;
        totalOperations++;
    }

    public static synchronized void incrementDivNumber() {
        divCount++;
        totalOperations++;
    }

    public static synchronized void sumResult(int result) {
        resultSum += result;
    }

    public static synchronized int getTotalClients() {
        return totalClients;
    }

    public static synchronized int getTotalOperations() {
        return totalOperations;
    }

    public static synchronized int getInvalidOperations() {
        return invalidOperations;
    }

    public static synchronized int getAddCount() {
        return addCount;
    }

    public static synchronized int getSubCount() {
        return subCount;
    }

    public static synchronized int getMulCount() {
        return mulCount;
    }

    public static synchronized int getDivCount() {
        return divCount;
    }

    public static synchronized long getResultSum() {
        return resultSum;
    }
}
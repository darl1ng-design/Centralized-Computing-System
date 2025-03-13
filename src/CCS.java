public class CCS {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("run by: java -jar CCS.jar <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);

        new Thread(() -> new UDPServer(port).run()).start();
        new Thread(() -> new TCPServer(port).run()).start();
        new Thread(new StatisticsReport()).start();
    }
}
import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 3) {
                    out.println("ERROR");
                    Statistics.incrementError();
                    continue;
                }

                String operation = parts[0];
                int arg1 = Integer.parseInt(parts[1]);
                int arg2 = Integer.parseInt(parts[2]);

                int result;
                switch (operation) {
                    case "ADD":
                        result = arg1 + arg2;
                        Statistics.incrementAddNumber();
                        break;
                    case "SUB":
                        result = arg1 - arg2;
                        Statistics.incrementSubNumber();
                        break;
                    case "MUL":
                        result = arg1 * arg2;
                        Statistics.incrementMulNumber();
                        break;
                    case "DIV":
                        if (arg2 == 0) {
                            out.println("ERROR: Division by zero");
                            Statistics.incrementError();
                            continue;
                        }
                        result = arg1 / arg2;
                        Statistics.incrementDivNumber();
                        break;
                    default:
                        out.println("ERROR: Unknown operation");
                        Statistics.incrementError();
                        continue;
                }

                System.out.println(result);
                Statistics.sumResult(result);
            }
        } catch (IOException e) {
            System.err.println("Client communication error: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}

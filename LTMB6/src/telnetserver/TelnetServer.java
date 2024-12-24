package telnetserver;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class TelnetServer {

    private static final String USERS_FILE = "C:\\Users\\Admin\\Documents\\Java 28 Base\\JAVA\\LTMB6\\src\\telnetserver\\users.txt";
    private static final String OUTPUT_FILE = "C:\\Users\\Admin\\Documents\\Java 28 Base\\JAVA\\LTMB6\\src\\telnetserver\\out.txt";
    private static final Lock fileLock = new ReentrantLock();

    // Method to authenticate user credentials
    private static boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(USERS_FILE), "UTF-8"));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 2) {
                    System.out.println("Checking: " + parts[0] + " == " + username); // Debug log
                    if (parts[0].equals(username) && parts[1].equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading users.txt file: " + e.getMessage());
        }
        return false;
    }


    // Method to execute system commands
    private static String executeCommand(String command) {
        fileLock.lock(); // Prevent file access conflicts
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Write the result to out.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            // Read the result from out.txt
            StringBuilder result = new StringBuilder();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            }
            return result.toString();
        } catch (IOException e) {
            return "Error executing command: " + e.getMessage();
        } finally {
            fileLock.unlock();
        }
    }

    // Method to handle client requests
    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            out.println("Enter username:");
            String username = in.readLine();
            System.out.println("Received username: " + username);  // Debug log

            out.println("Enter password:");
            String password = in.readLine();
            System.out.println("Received password: " + password);  // Debug log

            if (!authenticate(username, password)) {
                out.println("Login failed.");
                clientSocket.close();
                return;
            }

            out.println("Login successful!");

            // Wait for commands from the client
            String command;
            while (true) {
                out.println("Enter command (or 'exit' to disconnect):");
                command = in.readLine();

                if (command == null || command.equalsIgnoreCase("exit")) {
                    out.println("Closing connection.");
                    break;
                }

                String result = executeCommand(command);
                out.println("Command result:\n" + result);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TelnetServer <port>");
            return;
        }

        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid port!");
            return;
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Telnet Server is running on port " + port);

            // Listen for client connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from " + clientSocket.getInetAddress());

                // Handle each client in a separate thread
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

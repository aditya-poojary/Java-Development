package com.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.awt.Desktop;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception {
        // Configure these for your environment if you want to actually connect
        String url = ""; // e.g. jdbc:mysql://localhost:3306/your_db?serverTimezone=UTC
        String uname = "root";
        String password = "";

        // modern MySQL driver class name
        String driverClass = "com.mysql.cj.jdbc.Driver";

        // Start a lightweight HTTP server that will show connection status
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) {
                try {
                    String body;
                    if (url == null || url.isEmpty()) {
                        body = "<html><body><h1>Database connection test</h1>"
                                + "<p>No JDBC URL provided. Skipping DB connection test.</p>"
                                + "<p>To connect, set 'url' in App.java and add the MySQL connector to the classpath.</p>"
                                + "</body></html>";
                    } else {
                        try {
                            Class.forName(driverClass);
                            try (Connection con = DriverManager.getConnection(url, uname, password)) {
                                boolean connected = con != null && !con.isClosed();
                                body = "<html><body><h1>Database connection test</h1>"
                                        + "<p>Connected: " + connected + "</p>"
                                        + "</body></html>";
                            }
                        } catch (Exception e) {
                            body = "<html><body><h1>Database connection test</h1>"
                                    + "<p>Connection failed: " + e.getMessage() + "</p>"
                                    + "</body></html>";
                        }
                    }

                    byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
                    exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
                    exchange.sendResponseHeaders(200, bytes.length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(bytes);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    try {
                        byte[] bytes = "Internal server error".getBytes(StandardCharsets.UTF_8);
                        exchange.sendResponseHeaders(500, bytes.length);
                        try (OutputStream os = exchange.getResponseBody()) {
                            os.write(bytes);
                        }
                    } catch (Exception ignore) {
                    }
                }
            }
        });
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();

        int port = server.getAddress().getPort();
        String localUrl = "http://localhost:" + port + "/";
        System.out.println("Server started at " + localUrl);

        // Try to open the default browser
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(localUrl));
            } else {
                System.out.println("Open this URL in your browser: " + localUrl);
            }
        } catch (Exception e) {
            System.out.println("Could not open browser automatically. Open this URL manually: " + localUrl);
        }

        System.out.println("Press Enter to stop the server and exit...");
        System.in.read();
        server.stop(0);
    }

    // helper used by unit tests
    public static String greet(String name) {
        if (name == null) return "Hello, World!";
        return "Hello, " + name + "!";
    }
}

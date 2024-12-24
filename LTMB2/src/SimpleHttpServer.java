import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        // Tạo server chạy trên cổng 8000
        HttpServer server = HttpServer.create(new InetSocketAddress("172.20.10.5", 8000), 0);

        // Đăng ký context "/calculate" để xử lý tính toán
        server.createContext("/calculate", new CalculateHandler());

        // Đăng ký context "/" để hiển thị form nhập liệu
        server.createContext("/", new FormHandler());

        // Bắt đầu server
        server.setExecutor(null); // Sử dụng executor mặc định
        server.start();
        System.out.println("Server đang chạy tại http://172.20.10.5:8000");
    }

    // Xử lý hiển thị form nhập liệu
    static class FormHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = """
                    <html>
                    <body>
                        <h1>Insert 2 nums</h1>
                        <form method="POST" action="/calculate">
                            <label for="a">Num a:</label>
                            <input type="number" id="a" name="a" required>
                            <br><br>
                            <label for="b">Num b:</label>
                            <input type="number" id="b" name="b" required>
                            <br><br>
                            <button type="submit">Calculate sum</button>
                        </form>
                    </body>
                    </html>
                """;

                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }
    }

    // Xử lý tính toán khi nhận giá trị từ form
    static class CalculateHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                // Đọc dữ liệu gửi từ form
                InputStream is = exchange.getRequestBody();
                String formData = new String(is.readAllBytes(), StandardCharsets.UTF_8);

                // Phân tích dữ liệu (vd: a=5&b=3)
                String[] params = formData.split("&");
                int a = Integer.parseInt(params[0].split("=")[1]);
                int b = Integer.parseInt(params[1].split("=")[1]);

                // Tính toán
                int result = a + b;

                // Trả kết quả về trình duyệt
                String response = """
                    <html>
                    <body>
                        <h1>Result</h1>
                        <p>Num a: %d</p>
                        <p>Num b: %d</p>
                        <p><strong>Sum: %d</strong></p>
                        <a href="/">Return</a>
                    </body>
                    </html>
                """.formatted(a, b, result);

                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }
    }
}

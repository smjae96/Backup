package webserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

//HTTP 서버 구현 클래스
public class SimpleHttpServer {

 // 메인 실행 메서드
 public static void main(String[] args) throws Exception {
     // 포트 8000에서 동작하는 HTTP 서버 인스턴스 생성
     HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

     // '/test' 경로에 대한 핸들러 설정
     server.createContext("/test", new TestHandler());

     // 루트 경로에 대한 에러 핸들러 설정
     server.createContext("/", new ErrorHandler());

     // 스레드 풀 설정 (null로 설정 시 기본 executor 사용)
     server.setExecutor(null);

     // 서버 시작
     server.start();
 }

 // '/test' 경로의 요청 핸들러
 static class TestHandler implements HttpHandler {
     @Override
     public void handle(HttpExchange exchange) throws IOException {
         // 응답 메시지 설정
         String response = "Hello, HTTP!";

         // 200 상태 코드와 함께 응답 헤더 전송
         exchange.sendResponseHeaders(200, response.length());

         // 응답 본문 전송
         OutputStream os = exchange.getResponseBody();
         os.write(response.getBytes());
         os.close();
     }
 }

 // 루트 경로 외의 요청 핸들러 (에러 처리)
 static class ErrorHandler implements HttpHandler {
     @Override
     public void handle(HttpExchange exchange) throws IOException {
         // 에러 메시지 설정
         String errorResponse = "404 Error: Invalid path!";

         // 404 상태 코드와 함께 응답 헤더 전송
         exchange.sendResponseHeaders(404, errorResponse.length());

         // 응답 본문 전송
         OutputStream os = exchange.getResponseBody();
         os.write(errorResponse.getBytes());
         os.close();
     }
 }
}

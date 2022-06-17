//package com.example.socketintegrationapp.Configs;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//import javax.servlet.http.HttpSession;
//import java.util.Map;
//
//public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
//    private static final Log logger = LogFactory
//            .getLog(HandshakeInterceptor.class);
//
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        logger.info("Before handshake");
//        if(request instanceof ServletServerHttpRequest){
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            HttpSession session = servletRequest.getServletRequest().getSession(false);
//            if (session != null) {
//                attributes.put("deviceId","123");
//            }
//        }
//        return super.beforeHandshake(request, response, wsHandler, attributes);
//
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
//        super.afterHandshake(request, response, wsHandler, ex);
//    }
//}

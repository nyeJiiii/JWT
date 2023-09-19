package com.cos.jwt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("필터3");
//        chain.doFilter(request, response);

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 토큰(cos)를 만들어줘야함
        // id, pw가 정상적으로 들어와서 로그인 완료되면 토큰을 만들어주고 그걸 응답해준다.
        // 그때 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지만 검증하면 됨 (RSA, HS256)
        if(req.getMethod().equals("POST")) {
            System.out.println("POST 요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println("headerAuth = " + headerAuth);

            // Authorization 헤더가 없거나 "cos"가 아닌 경우 처리
            if (headerAuth == null || !headerAuth.equals("cos")) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = res.getWriter();
                out.println("인증안됨");
            } else {
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }

//            if(headerAuth.equals("cos")) {
//                chain.doFilter(req, res);
//            } else {
//                PrintWriter out = res.getWriter();
//                out.println("인증안됨 ");
//            }

    }
}



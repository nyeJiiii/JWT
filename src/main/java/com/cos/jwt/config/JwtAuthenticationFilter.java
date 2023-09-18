package com.cos.jwt.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 스크링 시큐리티의 아래 필터 상속
// /login 요청해서 Username, password 전송(post)시
// UsernamePasswordAuthenticationFilter가 동작 함
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // /login 요청하면 로그인 시도를 위해 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JWTAuthenticationFilter: 로그인 시도중");

        // 1. username, password를 받아서

        // 2. 정상인지 로그인 시도함. authenticationManager로 로그인 시도를 하면
        // PrincipalDetailsService가 호출, loadUserByUsername() 실행

        // 3. PrincipalDetails를 세션에 담고

        // 4. JWT 토큰을 만들어서 응답해주면 됨
        return super.attemptAuthentication(request, response);
    }
}

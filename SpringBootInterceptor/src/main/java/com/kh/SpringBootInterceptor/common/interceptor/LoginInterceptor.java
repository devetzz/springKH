package com.kh.SpringBootInterceptor.common.interceptor;

import java.lang.reflect.Method;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final String USER_INFO = "userInfo";

    // controller 시작하기 전에 진행
    // handler : url 요청했을때 실행되는 controller 와 그 해당되는 함수 정보가 있다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("1번 preHandle");
        String requestURI = request.getRequestURI();
        // URL => http://127.0.0.1:8080/login , URI => 포트번호 뒤부터
        log.info("requestURI : " + requestURI);
        
        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();
        
        // Bean : com.kh.controller.Logincontroller@13ed2e22
        log.info("1번 Bean: " + method.getBean());

        // Method : public void com.kh.controller.Logincontroller.login()
        log.info("1번 Method: " + methodObj);

        // 세션값을 가져온다
        HttpSession session = request.getSession();
        // 세션값에 로그인해서 성공한 사용자 정보가 들어있다
        if (session.getAttribute(USER_INFO) != null) {
            // 세션값에서 사용자 정보를 삭제한다
            session.removeAttribute(USER_INFO);
            // response.sendRedirect("/");
            // return false;
        }
        // 조건에 맞지 않으면 controller 진입 불가
        return true;
    }

    // controller 종료할때 진행
    // ModelAndView : 두가지 (Model, View Resolver 정보를 가지고 있는 객체)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        log.info("3번 postHandle");
        String requestURL = request.getRequestURI();
        // requestURL : /login
        log.info("3번 requestURL : " + requestURL);
        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();
        // Bean: com.zeus.controller.Logincontroller@13ed2e22
        log.info("3번 Bean: " + method.getBean());
        //Method: public void com.zeus.controller.Logincontroller.login()
        log.info("3번 Method: " + methodObj);

        // 세션값을 가져온다
        HttpSession session = request.getSession();
        // ModelMap => Model 과 같다
        ModelMap modelMap = modelAndView.getModelMap();

        // 컨트롤러에서 ModelAndView에 담은 user 객체를 가져온다
        Object member = modelMap.get("user");

        if (member != null) { 
            log.info("3번 member != null");
            session.setAttribute(USER_INFO, member);
            response.sendRedirect("/");
        }
    }

    // view resolver 실행하기 전에
    // @Override
    // public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    //         throws Exception {
    //     log.info("4번 afterCompletion");
    // }
}

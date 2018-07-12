package kr.aston.event.admin.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class DefaultInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {//컨트롤러 진입 전 인터셉터

//		// 로그인 페이지와 로그인 수행 페이지를 제외한 모든 경로에 대하여 수행
//		if (! "/".equals(request.getRequestURI()) && ! "/authorize".equals(request.getRequestURI())) {
//
//			HttpSession session = request.getSession(true) ;
//
//			Object admUserAccountObj = session.getAttribute("ADM_USER_ACCOUNT") ;
//			Object admUserNameObj = session.getAttribute("ADM_USER_NAME") ;
//
//			if (admUserAccountObj == null ||
//				"".equals(admUserAccountObj.toString().trim()) ||
//				admUserNameObj == null ||
//				"".equals(admUserNameObj.toString().trim())) {
//
//				response.sendRedirect("/") ;
//				return false ;
//
//			}
//
//		}
//
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws IOException {//컨트롤러가 불힌 후 사용
        if (modelAndView != null) {
            String cacheExpireParam = "";
            cacheExpireParam = "?" + new Date().getTime();

            request.setAttribute("resourcePath", "");
            request.setAttribute("cacheExpireParam", cacheExpireParam);
        }
    }

}

package kr.p.eye.platform.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// /signin 실행 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute(LOGIN) != null) {

			// 로그인 정보 있으면 기존 로그인 정보 제거
			httpSession.removeAttribute(LOGIN);
		}

		return true;
	}

	// /signin 실행 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		ModelMap modelMap = modelAndView.getModelMap();
		String memberId = (String) modelMap.get("memberId");

		// 로그인 성공시
		if (memberId != null) {

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(LOGIN, memberId);

			response.sendRedirect("./");

		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}

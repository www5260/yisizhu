package com.buba.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.buba.entity.Customer;
import com.buba.service.LogService;
import com.buba.util.JsonFormatUtil;
import com.buba.util.ReadUrlUtil;

/*
 * 用于对session用户信息的拦截
 */
public class InterceptorSession implements HandlerInterceptor {
	@Resource
	private LogService logService;

	/*
	 * 该方法需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束之后，
	 * 也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理。
	 */
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception e)
			throws Exception {
		
	}

	/*
	 * 该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
	 * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。 
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object ojbj, ModelAndView arg3)
			throws Exception {
		
	}

	/*
	 * 该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，
	 * 当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法； 
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		Customer customer = (Customer)req.getSession().getAttribute("userLogin");
		if (customer != null) {
			return true;
		}
		/** 获得请求的ServletPath 请求地址 */
		String servletPath = req.getServletPath();// 本项目内部请求的服务地址
		String requestURI = req.getRequestURI();// 请求地址带项目名/CDES/employee/findAllEmployee
		String token = (String)req.getParameter("token");
		System.out.println("拦截器中的token："+token);
		//验证令牌
		String url = "http://localhost:8080/SSO/ssoLogin/checkToken?token="+token;
		JSONArray jsonArray = ReadUrlUtil.readJsonFromUrl(url);
		//获取返回的json
		String json = jsonArray.get(0).toString();
//		System.out.println("拦截器中的json："+json);
		//判断json是否为空
		if ("{}".equals(json)) {
			//令牌未通过，传起始请求到jsp页面
			req.setAttribute("gotoURL", requestURI);
			req.setAttribute("message", "请您先登录再访问网站!");
//			req.getRequestDispatcher("/login.jsp").forward(req, res);
//			res.getWriter().print("<html><script>window.open ('"+req.getContextPath()+"/login.jsp','_top')</script></html>");
			res.sendRedirect(req.getContextPath()+"/login.jsp");
			return false;
		}else {
			customer = JsonFormatUtil.jsonToJava(json, Customer.class);
			//设置登录用户
			req.getSession().setAttribute("userLogin", customer);
			return true;
		}
		
		
	}

}

package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 登录过滤器
 * 除登录页面和主页面外，未登录的用户点击其他页面都会跳到登录页面
 */

@WebFilter(filterName = "LoginFilter", urlPatterns = "*.jsp", dispatcherTypes = {})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        System.out.println("LoginFilter doFilter");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String url = request.getRequestURI();
        System.out.println("请求的url：" + url);
        /*登录页面不需要过滤*/
        int idx = url.lastIndexOf("/");
        String endWith = url.substring(idx + 1);

        if (!endWith.equals("login.jsp") && !endWith.equals("index.jsp") && !endWith.equals("")&& !endWith.equals("register.jsp")) {
            /*不是登录页面或主页面  进行拦截处理*/
            //System.out.println("不是登录页面或主页面，进行拦截处理");
            if (!isLogin(request)) {
                //System.out.println("没有登录过或者账号密码错误，跳转到登录界面");
                response.sendRedirect("login.jsp");
            } else {
                //System.out.println("已经登录，进行下一步");
                chain.doFilter(req, resp);
            }
        } else {
            //System.out.println("是登录页面，不进行拦截处理");
            chain.doFilter(req, resp);
        }


    }


    private boolean isLogin(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String account = "";
        String pwd = "";
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("phone")) {
//                    account = cookie.getValue();
                    return true;
                }
//                else if (cookie.getName().equals("pwd")) {
////                    pwd = cookie.getValue();
//                }
            }
        }

//        if (account.equals("") || pwd.equals("")) {
//            return false;
//
//        } else if (account.equals("yzq") && pwd.equals("123")) {
//            return true;
//        }


        return false;
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter  init");
    }

}


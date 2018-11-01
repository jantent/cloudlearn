package com.filter;

import com.constant.WebConst;
import com.dao.AdminVoMapper;
import com.domain.vo.AdminVo;
import com.util.IpUtil;
import com.util.MapCache;
import com.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author: tangJ
 * @Date: 2018/11/1 16:48
 * @description:
 */

@Component
public class BaseInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String USER_AGENT = "user-agent";

    private MapCache cache = MapCache.getCache();

    @Autowired
    private AdminVoMapper adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 记录来路地址
        String uri = request.getRequestURI();
        logger.info("UserAgent: {}", request.getHeader(USER_AGENT));
        logger.info("用户访问地址: {}, 来路地址: {}", uri, IpUtil.getIpAddrByRequest(request));


        AdminVo adminVo = WebUtil.getLoginUser(request);
        // 如果session中不存在管理员信息
        if (null == adminVo) {
            Integer adminId = WebUtil.getCookieUid(request);
            if (null != adminId) {
                // 查询出管理信息
                adminVo = adminService.selectByPrimaryKey(adminId);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, adminVo);
            }
        }
        if (uri.startsWith("/admin") && !uri.startsWith("/admin/login") && null == adminVo ) {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }

        //设置get请求的token
        if ("GET".equals(request.getMethod())) {
            String csrf_token = UUID.randomUUID().toString();
            // 默认存储30分钟
            cache.set(csrf_token, uri);
            request.setAttribute("_csrf_token", csrf_token);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}

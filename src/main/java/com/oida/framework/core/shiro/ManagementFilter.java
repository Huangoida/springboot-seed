package com.oida.framework.core.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.UnauthorizedException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * preHandle -> isAccessAllowed -> isLoginAttempt -> executeLogin
 */
public class ManagementFilter extends JWTFilter {

    private final ManagementProperties managementProperties;

    public ManagementFilter(ManagementProperties managementProperties) {
        this.managementProperties = managementProperties;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        return false;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return true;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

        String method = ((HttpServletRequest)request).getMethod();

        if ("GET".equals(method)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            return managementProperties.getUsername().equals(username) && managementProperties.getPassword().equals(password);
        } else {
            // 读取请求内容
            BufferedReader br;
            try {
                br = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                //将json字符串转换为json对象
                JSONObject json = JSON.parseObject(sb.toString());
                String username = json.getString("username");
                String password = json.getString("password");
                if (managementProperties.getUsername().equals(username) && managementProperties.getPassword().equals(password)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new UnauthorizedException();
            }
        }
        return false;
    }
}

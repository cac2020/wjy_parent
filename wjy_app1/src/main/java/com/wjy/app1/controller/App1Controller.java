package com.wjy.app1.controller;

import com.wjy.app1.entity.ReturnEntity;
import com.wjy.app1.entity.UserContext;
import com.wjy.app1.util.HttpClient;
import com.wjy.app1.util.UserContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author wjy
 * @date 2019/3/1 14:08
 */
@RestController
public class App1Controller {

    @Value("${sso_server}")
    private String serverHost;

    @RequestMapping("/test")
    public ReturnEntity test() {
        return new ReturnEntity(1, "通过验证", null);
    }


    @RequestMapping("/logout")
    public ReturnEntity logout() throws Exception {
        UserContext context = UserContextHolder.get();
        HttpClient.get(serverHost + "/inValid?token=" + context.getToken());
        return null;
    }
}

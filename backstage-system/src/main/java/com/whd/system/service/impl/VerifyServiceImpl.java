package com.whd.system.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.whd.exception.BadRequestException;
import com.whd.system.domain.vo.EmailVo;
import com.whd.system.service.VerifyService;
import com.whd.utils.RedisUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class VerifyServiceImpl implements VerifyService {

    @Value("${code.expiration}")
    private Long expiration;
    private final RedisUtils redisUtils;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmailVo sendEmail(String email, String key) {
        EmailVo emailVo;
        String content;
        String redisKey = key + email;

        // 如果不存在有效的验证码，就创建一个新的
        Object oldCode = redisUtils.get(redisKey);
        if (oldCode == null) {
            String code = RandomUtil.randomNumbers(6);
            // 存入缓存
            if (!redisUtils.set(redisKey, code, expiration)) {
                throw new BadRequestException("服务异常，请联系网站负责人");
            }
            content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" " +
                    " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
                    "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>" +
                    "   <style>@page {margin: 0;}</style></head>" +
                    "<body style=\"margin: 0px;padding: 0px;font: 100% SimSun, Microsoft YaHei, Times New Roman, Verdana, Arial, Helvetica, sans-serif;" +
                    "color: #000;\"><div style=\"height: auto;width: 820px;min-width: 820px;margin: 0 auto;margin-top: 20px;" +
                    "border: 1px solid #eee;\"><div style=\"padding: 10px;padding-bottom: 0px;\">" +
                    "<p style=\"margin-bottom: 10px;padding-bottom: 0px;\">尊敬的用户，您好：</p>" +
                    "<p style=\"text-indent: 2em; margin-bottom: 10px;\">您正在申请邮箱验证，您的验证码为：</p>" +
                    "<p style=\"text-align: center;font-family: Times New Roman;font-size: 22px;color: #C60024;padding: 20px 0px;margin-bottom: 10px;" +
                    "font-weight: bold;background: #ebebeb;\"> " + code + " </p>" +
                    "<div class=\"foot-hr hr\" style=\"margin: 0 auto;" +
                    "z-index: 111;width: 800px;margin-top: 30px;border-top: 1px solid #DA251D;\"></div>" +
                    "</div></div></body></html>";
            emailVo = new EmailVo(Collections.singletonList(email), "后台管理系统", content);
            // 存在就再次发送原来的验证码
        } else {
            content = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" " +
                    " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
                    "<head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>" +
                    "   <style>@page {margin: 0;}</style></head>" +
                    "<body style=\"margin: 0px;padding: 0px;font: 100% SimSun, Microsoft YaHei, Times New Roman, Verdana, Arial, Helvetica, sans-serif;" +
                    "color: #000;\"><div style=\"height: auto;width: 820px;min-width: 820px;margin: 0 auto;margin-top: 20px;" +
                    "border: 1px solid #eee;\"><div style=\"padding: 10px;padding-bottom: 0px;\">" +
                    "<p style=\"margin-bottom: 10px;padding-bottom: 0px;\">尊敬的用户，您好：</p>" +
                    "<p style=\"text-indent: 2em; margin-bottom: 10px;\">您正在申请邮箱验证，您的验证码为：</p>" +
                    "<p style=\"text-align: center;font-family: Times New Roman;font-size: 22px;color: #C60024;padding: 20px 0px;margin-bottom: 10px;" +
                    "font-weight: bold;background: #ebebeb;\"> " + oldCode + " </p>" +
                    "<div class=\"foot-hr hr\" style=\"margin: 0 auto;" +
                    "z-index: 111;width: 800px;margin-top: 30px;border-top: 1px solid #DA251D;\"></div>" +
                    "</div></div></body></html>";
            emailVo = new EmailVo(Collections.singletonList(email), "后台管理系统", content);
        }
        return emailVo;
    }

    @Override
    public void validated(String key, String code) {
        Object value = redisUtils.get(key);
        if (value == null || !value.toString().equals(code)) {
            throw new BadRequestException("无效验证码");
        } else {
            redisUtils.del(key);
        }
    }
}

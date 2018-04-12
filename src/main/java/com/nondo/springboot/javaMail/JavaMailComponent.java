package com.nondo.springboot.javaMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Component
@EnableConfigurationProperties(MailProperties.class)
public class JavaMailComponent {

    private static final String template = "mail/mail.ftl";

    @Autowired
    private FreeMarkerConfig freeMarkerConfig;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailProperties mailProperties;

    public void sendMail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        try {
            //获取内容
            String text = this.getTextTemplate(template, map);
            //发送
            this.send(email, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTextTemplate(String template, Map<String, Object> model)throws Exception {
        return FreeMarkerTemplateUtils.processTemplateIntoString(this.freeMarkerConfig.getConfiguration().getTemplate(template),model);
    }

    public String send(String email,String text)throws MessagingException,UnsupportedEncodingException{
        MimeMessage message = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
        InternetAddress from = new InternetAddress();
        from.setAddress(this.mailProperties.getUsername());
        from.setPersonal("白菜","UTF-8");
        helper.setFrom(from);
        helper.setTo(email);
        helper.setSubject("springboot 发送的第一封邮件");
        helper.setText(text,true);
        this.javaMailSender.send(message);
        return text;
    }
}

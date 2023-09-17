package com.lbpf.captchaspringmvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Controller
@RequestMapping("captcha")
public class CaptchaController {

    @RequestMapping(method = RequestMethod.POST)
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpg");
        int iToTalChars = 6;
        int iHeight = 40;
        int iWidth = 150;

        Font fnStyle1 = new Font("Arial", Font.BOLD, 30);
        Random randomChars = new Random();
        String sImageCode = (Long.toString(Math.abs(randomChars.nextLong()), 36)).substring(0, iToTalChars);
        BufferedImage biImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) biImage.getGraphics();

        int iCircle = 15;
        for(int i=0; i< iCircle; i++) {
            graphics2D.setColor(new Color(randomChars.nextInt(255), randomChars.nextInt(255), randomChars.nextInt(255)));
        }
        graphics2D.setFont(fnStyle1);

        for(int i=0; i< iToTalChars; i++) {
            graphics2D.setColor(new Color(randomChars.nextInt(255), randomChars.nextInt(255), randomChars.nextInt(255)));
            if(i % 2 == 0) {
                graphics2D.drawString(sImageCode.substring(i, i + 1), 25 * i, 24);
            } else {
                graphics2D.drawString(sImageCode.substring(i, i + 1), 25 * i, 35);
            }
        }

        OutputStream osImage = response.getOutputStream();
        ImageIO.write(biImage, "jpeg", osImage);
        graphics2D.dispose();
        HttpSession session = request.getSession();
        session.setAttribute("captcha_security", sImageCode);
    }
}

package com.jarvis.servlet;

import com.jarvis.dao.User;
import com.jarvis.dao.UserDao;
import org.apache.commons.codec.digest.DigestUtils;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserCodeLogin  extends HttpServlet {
    private String number=null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String method=req.getParameter("method");
        if(method.equals("code")){
            postCode(req,resp);
        }else if(method.equals("codeLogin")){
            codeLogin(req,resp);
        }
    }

    protected void codeLogin(HttpServletRequest req,HttpServletResponse resp){
        int inputCode=Integer.parseInt(req.getParameter("code"));

        String phone=number;
        if(inputCode==1){
            UserDao userDao=new UserDao();
            User user=null;
            List<User> list=userDao.getUser();
            for(int i=0;i<list.size();i++){
                if(list.get(i).getPhone().equals(phone)){
                    user=list.get(i);
                }
            }
            try{
                if(user!=null){
                    resp.sendRedirect(req.getContextPath()+"/homepage.jsp?userId="+user.getId());
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else {
            try{
                resp.sendRedirect(req.getContextPath()+"/error.html");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    protected int postCode(HttpServletRequest req, HttpServletResponse resp){
        int code=0;
        String result=null;
        String str="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
        Date time=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        String phone=req.getParameter("phone");
        String smsContent="【唐辉博客】尊敬的用户，您的验证码为{1}";
        String timestamp=format.format(time);
        String sig= DigestUtils.md5Hex("d0c116c1ab514055a6cc67d018698982b4b9692ed14c47d3a9785c6734557de7"+timestamp);
        String body="accountSid=d0c116c1ab514055a6cc67d018698982&smsContent="+smsContent+"&to="+phone+"&timestamp="+timestamp+"&sig="+sig+"&respDataType=JSON";
        try{
            URL url=new URL(str);

            URLConnection conn=url.openConnection();
            //设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            OutputStreamWriter out = null;
            BufferedReader in = null;

            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
            out.write(body);
            out.flush();

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null)
            {
                if (firstLine)
                {
                    firstLine = false;
                } else
                {
                    result += System.lineSeparator();
                }
                result += line;
            }
            number=phone;
            code=1;
            System.out.println(result);
            resp.sendRedirect(req.getContextPath()+"/codeLogin.jsp?phone="+phone);
        }catch (Exception e){
            e.printStackTrace();
        }
        return code;
    }
}

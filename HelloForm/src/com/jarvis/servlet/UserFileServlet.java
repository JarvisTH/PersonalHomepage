package com.jarvis.servlet;

import com.jarvis.dao.User;
import com.jarvis.dao.UserDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String filePath="D:";
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.setCharacterEncoding("utf-8");
        String method=req.getParameter("method");
        if(method.equals("modify")){
            modify(req,resp);
        }else if(method.equals("add")){
            add(req,resp);
        }
//        else if(method.equals("upload")){
//            upload(req,resp);
//        }
    }

    protected void add(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        User user=new User();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setSex(req.getParameter("sex"));
        user.setHobbies(req.getParameter("hobby"));
        user.setPhone(req.getParameter("phone"));
        user.setBirthday(req.getParameter("birthday"));
        user.setEdu(req.getParameter("edu"));
        user.setPassword(req.getParameter("password"));
        user.setImage(filePath);
        int status=new UserDao().save(user);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    protected void modify(HttpServletRequest req,HttpServletResponse resp)throws  IOException{
        req.setCharacterEncoding("utf-8");
        UserDao userDao=new UserDao();
        List<User> list=userDao.getUser();
        User user=null;
        for(int i=0;i<list.size();i++){
            if(Integer.toString(list.get(i).getId()).equals(req.getParameter("userId"))){
                user=list.get(i);
            }
        }
        user.setName(req.getParameter("user-name"));
        user.setSex(req.getParameter("user-sex"));
        user.setEmail(req.getParameter("user-email"));
        user.setPhone(req.getParameter("user-phone"));
        user.setBirthday(req.getParameter("user-birthday"));
        user.setHobbies(req.getParameter("hobby-txt"));
        user.setEdu(req.getParameter("edu-txt"));

        int status=userDao.update(user);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/management.jsp?userId="+req.getParameter("userId"));
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    public void upload(HttpServletRequest request,HttpServletResponse response) throws IOException{
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            return;
        }
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 保存文件到硬盘
                        //item.write(storeFile);

                        System.out.println(filePath);
                        response.sendRedirect(request.getContextPath()+"/register.jsp");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }

    }

}


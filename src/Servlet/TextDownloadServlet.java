package Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Servlet implementation class TextDownloadServlet
 */
public class TextDownloadServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	        //1.��ȡ�����ļ�������
	        String filename=request.getParameter("filename");
	        System.out.println(filename);
	        //*���߿ͻ�������ļ����ǽ��� �����Ը�������ʽ����
	        response.setHeader("Content-Disposition", "attachment;filename="+filename);
	        //2.��ȡ�ļ��ľ���·��
	        String path = getServletContext().getRealPath("/") + "/";
	        //3.��ø��ļ���������
	        FileInputStream in=new FileInputStream("/usr/java/tomcat/apache-tomcat-8.5.41/webapps/text/"+filename);
	        //��������---ͨ��response��õ������  ������ͻ���д����
	        ServletOutputStream out=response.getOutputStream();
	        //�����ļ�
	        int len=0;
	        byte [] buffer=new byte[1024];
	        
	        while((len=in.read(buffer))>0) {
	            out.write(buffer, 0, len);
	        }
	        in.close();
	        out.close();
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

}

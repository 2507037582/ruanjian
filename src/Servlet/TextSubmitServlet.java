package Servlet;

import dao.FileDao;
import domain.Text;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


/**
 * Servlet implementation class TextSubmitServlet
 */
public class TextSubmitServlet extends HttpServlet {
	FileDao fileDao=new FileDao();
	private static final long serialVersionUID = -4187075130535308117L;
    private boolean isMultipart;
    private int maxFileSize = 1024 * 1024 * 10;
    private int maxMemSize = 100 * 1024;
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	// ����Ƿ���һ���ļ��ϴ�����
    			request.setCharacterEncoding("UTF-8");
    	        isMultipart = ServletFileUpload.isMultipartContent(request);
    	        String result = "";
    	        response.setContentType("text/html;charset=utf-8");
    	        if (!isMultipart) {
    	            result = "δ��ȡ���ļ�";
    	            response.getWriter().println(result);
    	            return;
    	        }
    	        DiskFileItemFactory factory = new DiskFileItemFactory();
    	        // �ļ���С�����ֵ�����洢���ڴ���
    	        factory.setSizeThreshold(maxMemSize);
    	        // Location to save data that is larger than maxMemSize.
    	        String path = getServletContext().getRealPath("/");
    	        factory.setRepository(new File(path));
    	        System.out.println(path);
    	        // System.out.println(path);
    	        // ����һ���µ��ļ��ϴ��������
    	        ServletFileUpload upload = new ServletFileUpload(factory);
    	        // �����ϴ����ļ���С�����ֵ
    	        upload.setSizeMax(maxFileSize);

    	        try {
    	            // �������󣬻�ȡ�ļ���
    	        	String fileName=null;
    	            List fileItems = upload.parseRequest(request);
    	            // �����ϴ����ļ���
    	            Iterator i = fileItems.iterator();
    	            while (i.hasNext()) {
    	                FileItem fi = (FileItem) i.next();
    	                if (!fi.isFormField()) {
    	                    // ��ȡ�ϴ��ļ��Ĳ���
    	                	File f = new File(fi.getName());
    	                    String fieldName = fi.getFieldName();
    	                    fileName = fi.getName();
    	                    String contentType = fi.getContentType();
    	                    boolean isInMemory = fi.isInMemory();
    	                    long sizeInBytes = fi.getSize();
    	                    // д���ļ�
    	                    System.out.println();
    	                    fileName=f.getName();
    	                    File file = new File("/usr/java/tomcat/apache-tomcat-8.5.41/webapps/text/"+f.getName());
    	                    
    	                    fi.write(file);
    	                }
    	            }
    	            result = "�ϴ��ɹ�";
    	            Text text=new Text();
        	        text.setFilename(fileName);
        	        try {
        				fileDao.insert(text);
        			} catch (SQLException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
    	        } catch (Exception ex) {
    	            System.out.println("ex:" + ex.getMessage());
    	            result = "�ϴ�ʧ��";
    	        }
    	        
    	     response.sendRedirect(request.getContextPath()+"/textindex");
    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

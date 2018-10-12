package com.deloitte;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.bean.UserObj;
import com.deloitte.service.MyServiceImpl;


@WebServlet(urlPatterns={"/hello","/login","/submit"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MyService mService;
   
    public MyServlet() {
    }
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()......");
		mService=new MyServiceImpl();
	}
	
	public void destroy() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()...");
		String path=request.getServletPath();
		System.out.println("Path: "+path);
		switch(path) {	
		
		case "/hello":	String name=request.getParameter("name");
		System.out.println(name);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Welcome Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Welcome to home page,"+name+"</h1>");
		out.println("<a href=\"login\">Go to Login</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		break;
		case "/login":
			request.getRequestDispatcher("login.jsp")
			 .forward(request, response);
			break;
		case "/display":
			List<String> ulist=mService.getUserList();
			request.setAttribute("list",);
			request.get
		case "/submit":
			String login=request.getParameter("login");
			String password=request.getParameter("password");
//			System.out.println(login);			
//			System.out.println(password);	
			UserObj userObj=new UserObj(login,password);
			boolean success=mService.authenticate(userObj);
			if(success) {
			request.getRequestDispatcher("success.jsp")
			 .forward(request, response);
			}
			else {
				request.getRequestDispatcher("fail.jsp")
				 .forward(request, response);
			}
			break;
			
		default:
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()...");
		doGet(request, response);
	}

}

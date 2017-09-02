package src.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.dao.LoginDao;
import src.dao.imp.LoginDaoImp;
import src.entity.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LoginDao dao = new LoginDaoImp();
		// 获得客户端请求参数
		String username = request.getParameter("account");
		String password = request.getParameter("password");
		
		User u = dao.login(username, password);
		if(u!=null){
			// 响应客户端内容，登录成功
			out.print(build(u));
		}else{
			// 响应客户端内容，登录失败
			out.print("0");
		}
		out.flush();
		out.close();
	}
	
	
	private String build(User u){
		String userMsg = "";
		userMsg+="id="+u.getId();
		userMsg+=";";
		userMsg+="name="+u.getName();
		return userMsg;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	public void init() throws ServletException {
	}
	
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}

package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private IuserService service;
	
	@Override
	public void init() throws ServletException {
		service = new UserService();
	}
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("uesrController doget");
		//사용자 id를 request객체로 부터 사용자 아이디 파라미터 확득
		String userId = request.getParameter("userId");
		//사용자 아이디로 사용자 정보를 조회
		UserVo vo = service.getUser(userId);
		
		//조회결과를 request객체에 속성으로 저장
		request.setAttribute("vo", vo);
		
		//화면을 담당하는 /user/user.jsp로 forward
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
	
	}


}

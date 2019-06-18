package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	private IuserService service;
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		service = new UserService();
		boardService = new BoardService();
	}
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("boardList", boardService.boardList());
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String encryptPassword = KISA_SHA256.encrypt(password);
		logger.debug(encryptPassword);
		
		
		UserVo vo = service.getUser(userId);
		if(vo!=null && encryptPassword.equals(vo.getPass())){
			HttpSession session = request.getSession();
			session.setAttribute("USER_INFO", new UserVo(vo.getUserId(), vo.getName(), vo.getAlias()));
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	}

}

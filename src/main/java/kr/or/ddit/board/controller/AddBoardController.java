package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;

/**
 * Servlet implementation class AddBoardController
 */
@WebServlet("/addBoard")
public class AddBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(AddBoardController.class);

	private IBoardService boardService;

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("boardList", boardService.boardList());

		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		UserVo vo = (UserVo) session.getAttribute("USER_INFO");

		String userId =  vo.getUserId(); 
		String name = request.getParameter("name");
		String use_yn = request.getParameter("selectBox");

		if(use_yn.equals("사용")){
			use_yn = "y";
		}else{
			use_yn = "n";
		}

		BoardVo boardVo = new BoardVo(userId, name, use_yn);
		int boardInsert = boardService.insertBoard(boardVo);

		if(boardInsert ==1){
			response.sendRedirect(request.getContextPath() + "/addBoard");
		}
	}
}

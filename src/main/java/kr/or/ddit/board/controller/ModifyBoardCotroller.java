package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ModifyBoardCotroller
 */
@WebServlet("/modifyBoard")
public class ModifyBoardCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ModifyBoardCotroller.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String boardId = request.getParameter("boardId");
		String use_yn = request.getParameter("selectBox");
		String name = request.getParameter("name");
		
		logger.debug("boardId : {}", boardId);
		logger.debug("use_yn : {}", use_yn);
		logger.debug("name : {}", name);
		
		BoardVo vo = new BoardVo(boardId, name);
		
		
		if(use_yn.equals("사용")){
			boardService.updateBoard(vo);
		}else{
			boardService.deleteBoard(vo);
		}
		
		response.sendRedirect(request.getContextPath() + "/addBoard");
	}

}

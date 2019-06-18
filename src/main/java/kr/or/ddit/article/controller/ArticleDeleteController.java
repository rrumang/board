package kr.or.ddit.article.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ArticleDeleteController
 */
@WebServlet("/articleDelete")
public class ArticleDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleDeleteController.class);
	
	private IArticleService articleService;
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleId = request.getParameter("articleId3");
		String boardId = request.getParameter("boardId2");
		
		int deleteCnt = articleService.deleteArticle(articleId);
		
		List<BoardVo> boardList = boardService.boardList();
		
		request.setAttribute("boardLIst", boardList);
		
		if(deleteCnt == 1){
			response.sendRedirect(request.getContextPath() + "/goBoard?boardId="+ boardId);
		}
	}
}

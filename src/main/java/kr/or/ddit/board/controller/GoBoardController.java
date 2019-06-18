package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.paging.model.PageVo;

/**
 * Servlet implementation class GoBoardController
 */
@WebServlet("/goBoard")
public class GoBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(GoBoardController.class);
	
	private IBoardService boardService;
	private IArticleService articleService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		articleService = new ArticleService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId = request.getParameter("boardId");
		
		int page = 0;
		int pageSize = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}else{
			page =1;
		}
		
		if(request.getParameter("pageSize") != null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}else{
			pageSize = 10;
		}
		
		PageVo pageVo = new PageVo();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("page", page);
		resultMap.put("pageSize", pageSize);
		resultMap.put("boardId", boardId);
		
		Map<String, Object> result = articleService.articlePagingList(resultMap);
		request.setAttribute("articleList", result.get("articlePagingList"));
		request.setAttribute("paginationSize", result.get("paginationSize"));
		request.setAttribute("pageVo", pageVo);
		request.setAttribute("boardList", boardService.boardList());
		request.setAttribute("board", boardService.getBoard(boardId));
		
		request.getRequestDispatcher("article/article.jsp").forward(request, response);
		
	}
}

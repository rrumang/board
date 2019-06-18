package kr.or.ddit.article.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.addfile.model.AddfileVo;
import kr.or.ddit.addfile.service.AddfileService;
import kr.or.ddit.addfile.service.IAddfileService;
import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ArticleDetailController
 */
@WebServlet("/articleDetail")
public class ArticleDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleDetailController.class);
	
	private IBoardService boardService;
	private IArticleService articleService;
	private IReplyService replyService;
	private IAddfileService addfileService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		articleService = new ArticleService();
		replyService = new ReplyService();
		addfileService = new AddfileService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserVo userVo = (UserVo) session.getAttribute("USER_INFO");
		String userId = userVo.getUserId();
		request.setAttribute("userId", userId);
		
		String articleId = request.getParameter("articleId");
		
		ArticleVo vo = articleService.getArticle(articleId);
		
		List<ReplyVo> replyList = replyService.replyLIst(articleId);
		
		List<AddfileVo> fileList = addfileService.fileList(articleId);
		
		
		request.setAttribute("vo", vo);
		request.setAttribute("boardList", boardService.boardList());
		request.setAttribute("replyList", replyList);
		request.setAttribute("fileList", fileList);
		
		request.getRequestDispatcher("/article/articleDetail.jsp").forward(request, response);
		
	}

}

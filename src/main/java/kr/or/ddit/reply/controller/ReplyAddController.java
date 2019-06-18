package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

/**
 * Servlet implementation class ReplyAddController
 */
@WebServlet("/replyAdd")
public class ReplyAddController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyAddController.class);
	
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyId = replyService.getReplyId();
		String articleId = request.getParameter("articleId4");
		String userId = request.getParameter("userId");
		String content = request.getParameter("content");
		
		ReplyVo replyVo = new ReplyVo(replyId, articleId, userId, content);
		
		int insertCnt = replyService.insertReply(replyVo);
		
		if(insertCnt == 1){
			response.sendRedirect(request.getContextPath() + "/articleDetail?articleId="+articleId);
		}
	}
}

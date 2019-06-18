package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

/**
 * Servlet implementation class ReplyDeleteController
 */
@WebServlet("/replyDelete")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IReplyService replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleId = request.getParameter("articleId");
		String replyId = request.getParameter("replyId");
		int deleteCnt = replyService.deleteReply(replyId);
		if(deleteCnt == 1){
			response.sendRedirect(request.getContextPath() + "/articleDetail?articleId="+articleId);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

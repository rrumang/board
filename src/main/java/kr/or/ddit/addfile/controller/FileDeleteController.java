package kr.or.ddit.addfile.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.addfile.service.AddfileService;
import kr.or.ddit.addfile.service.IAddfileService;
import kr.or.ddit.reply.service.IReplyService;
import kr.or.ddit.reply.service.ReplyService;

/**
 * Servlet implementation class ReplyDeleteController
 */
@WebServlet("/fileDelete")
public class FileDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IAddfileService addfileService;
	
	@Override
	public void init() throws ServletException {
		addfileService = new AddfileService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileId = request.getParameter("fileId");
		String articleId = request.getParameter("articleId");
		
		int deleteCnt = addfileService.deleteFile(fileId);
		if(deleteCnt == 1){
			response.sendRedirect(request.getContextPath() + "/articleModify?articleId="+articleId);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

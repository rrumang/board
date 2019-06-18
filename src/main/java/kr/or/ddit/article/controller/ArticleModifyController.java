package kr.or.ddit.article.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.addfile.model.AddfileVo;
import kr.or.ddit.addfile.service.AddfileService;
import kr.or.ddit.addfile.service.IAddfileService;
import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.article.service.ArticleService;
import kr.or.ddit.article.service.IArticleService;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class ArticleModifyController
 */
@WebServlet("/articleModify")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class ArticleModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleModifyController.class);
	
	private IArticleService articleService;
	private IBoardService boardService;
	private IAddfileService addfileService;
	
	@Override
	public void init() throws ServletException {
		articleService = new ArticleService();
		boardService = new BoardService();
		addfileService = new AddfileService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserVo userVo = (UserVo) session.getAttribute("USER_INFO");
		String userId = userVo.getUserId();
		request.setAttribute("userId", userId);
		
		String articleId = request.getParameter("articleId");
		
		ArticleVo vo = new ArticleVo();
		vo = articleService.getArticle(articleId);
		List<AddfileVo> fileList = addfileService.fileList(articleId);
		
		int size = fileList.size();
		request.setAttribute("size", size);
		
		List<BoardVo> boardList = boardService.boardList();
		
		request.setAttribute("articleId", articleId);
		request.setAttribute("vo", vo);
		request.setAttribute("fileList", fileList);
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/SE2/articleModify.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String articleId = request.getParameter("articleId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ArticleVo vo = new ArticleVo(articleId, title, content);
		
		int updateCnt = articleService.updateArticle(vo);
		
		//file 파일 업로드 처리
		List<Part> parts = (List<Part>) request.getParts();
		for(Part part : request.getParts()){
			if(part.getName().equals("file")){
				int fileInserCnt = fileUpload(part, articleId);
			}
		}
		
		if(updateCnt == 1){
			response.sendRedirect(request.getContextPath() + "/articleDetail?articleId="+articleId);
		}
	}
	
	private int fileUpload(Part part, String articleId)throws IOException{
		AddfileVo addfileVo = new AddfileVo();
		int fileInsertCnt = 0;
		
		if(part.getSize() > 0){
			String contentDisposition = part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(fileName);
			
			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			
			if(uploadFolder.exists()){
				String path = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				
				String fileId = addfileService.getFileId();
				
				addfileVo.setFileId(fileId);
				addfileVo.setArticleId(articleId);
				addfileVo.setPath(path);
				addfileVo.setFileName(fileName);
				
				part.write(path);
				part.delete();
			}
			fileInsertCnt = addfileService.insertFile(addfileVo);
		}
		return fileInsertCnt;
	}
}

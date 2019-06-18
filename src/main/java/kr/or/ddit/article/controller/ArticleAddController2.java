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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ArticleAddController
 */
@WebServlet("/articleAdd2")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class ArticleAddController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBoardService boardService;
	private IArticleService articleService;
	private IAddfileService addfileService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		articleService = new ArticleService();
		addfileService = new AddfileService();
	}
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleAddController2.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardId = request.getParameter("boardId3");
		String parentId = request.getParameter("parentId2");
		String article_group = request.getParameter("article_group2");
		logger.debug("*******************boardId : {}", boardId);
		logger.debug("*******************parentId : {}", parentId);
		logger.debug("*******************article_group : {}", article_group);
		
		HttpSession session = request.getSession();
		
		UserVo vo = (UserVo) session.getAttribute("USER_INFO");
		String userId = vo.getUserId();
		
		List<BoardVo> boardList = boardService.boardList();
		
		request.setAttribute("boardId", boardId);
		request.setAttribute("userId", userId);
		request.setAttribute("boardList", boardList);
		request.setAttribute("parentId", parentId);
		request.setAttribute("article_group", article_group);
		
		
		request.getRequestDispatcher("/SE2/articleAdd2.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//String parentId = null;
		String articleId = articleService.getArticleId();
		String boardId = request.getParameter("boardId");
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		String parentId = request.getParameter("parentId");
		String article_group = request.getParameter("article_group");

		ArticleVo vo = new ArticleVo(articleId, boardId, userId, title, content);
		vo.setArticle_group(article_group);
		vo.setParentId(parentId);

		logger.debug("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ vo : {}",vo);

		int insertCnt = articleService.insertArticle(vo);

		String fileId = addfileService.getFileId();

		AddfileVo addfileVo = new AddfileVo(fileId, articleId);

		//file 파일 업로드 처리
		List<Part> parts = (List<Part>) request.getParts();
		for(Part part : request.getParts()){
			if(part.getName().equals("file")){
				int fileInserCnt = fileUpload(part, articleId);
			}
		}


		if(insertCnt == 1){
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
			
			//업로드할 폴더확인
			//년도안에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지
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

package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/userModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1021 * 1024 * 15)
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IuserService service;

	@Override
	public void init() throws ServletException {
		service = new UserService();
	}

	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserVo vo = service.getUser(userId);
		request.setAttribute("vo", vo);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String birth = sdf.format(vo.getBirth());

		request.setAttribute("birth", birth);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.debug("dopost실행");
		request.setCharacterEncoding("utf-8"); // 설정하지않으면 한글깨짐
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		
		//사용자가 보낸 평문 비밀번호 데이터
		String pass = request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
		
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		logger.debug(userId);
		logger.debug(name);
		logger.debug(alias);
		logger.debug(addr1);
		logger.debug(addr2);
		logger.debug(zipcd);
		logger.debug(birth);
		logger.debug(pass);

		UserVo vo = null;


		try {
			vo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd,
					sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Part profile = request.getPart("profile");
		
		if (profile.getSize() > 0) {
			String contentDisposition = profile.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);
			
			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			
			if(uploadFolder.exists()){
				//파일 디스크에 쓰기
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				
				vo.setPath(filePath);
				vo.setFilename(filename);
				
				profile.write(filePath);
				profile.delete();
			}
		}

		int updateCnt = service.updateUser(vo);
		if (updateCnt == 1)
			response.sendRedirect(request.getContextPath() + "/userPagingList");

	}

}

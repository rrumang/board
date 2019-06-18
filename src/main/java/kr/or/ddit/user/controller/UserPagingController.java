package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * UserPagingController.java
 *
 * @author PC08
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정자 수정내용
 * ------ ------------------------
 * PC08 최초 생성
 *
 * </pre>
 */
@WebServlet("/userPagingList")
public class UserPagingController extends HttpServlet {

	private IuserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//page, pageSize 파라미터 받기
		//page, pageSize 파라미터가 없을 경우, page=1, pageSize=10;
		
//		int page = Integer.parseInt(request.getParameter("page"));
//		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int page = 0;
		int pageSize = 0;
		
		//삼항연산도 가능
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}else{
			page = 1;
		}
		
		if(request.getParameter("pageSize") != null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}else{
			pageSize = 10;
		}
		
		PageVo pageVo = new PageVo();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		// userList객체를 userList.jsp에서 참고할 수 있도록 request객체에 속성으로 넣어준다.
		Map<String , Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		

		// userList객체를 이용하여 사용자 화면을 생성하는 jsp
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}

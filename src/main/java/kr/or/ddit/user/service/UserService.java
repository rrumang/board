package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService implements IuserService{
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	
	private IuserDao dao;
	
	public UserService(){
		dao = new UserDao();
	}
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
		//db에서 데이터를 조회했다고 사정
		List<UserVo> userList = new ArrayList<UserVo>();
		userList = dao.userList();
		return userList;
	}
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자정보 조회
	 */
	@Override
	public UserVo getUser(String userId) {
		UserVo userVo = new UserVo();
		userVo = dao.getUser(userId);
		return userVo;
	}
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		//1. List<UserVo>, userCnt를 필드로 하는 vo
		
		//2. List<Object> resultList = new ArrayList<Object>();
		//resultList.add(userList);
		//resultList.add(usersCnt);
		
		//3.Map<String, Object> resultMap = new HashMap<String, Object>();
		//resultMap.put("userList", userList);
		//resultMap.put("usersCnt", usersCnt)
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", dao.userPagingList(pageVo));
		// usersCnt ==> paginationSize로 변경
		//resultMap.put("usersCnt", dao.usersCnt());
		int usersCnt = dao.usersCnt();
		//pageSize ==> pageVo.getPageSize();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	
	@Override
	public int insertUser(UserVo vo) {
		int insertCnt = dao.insertUser(vo);
		return insertCnt;
	}
	
	public int deleteUser(String userId) {
		int deleteCnt = dao.deleteUser(userId);
		return deleteCnt;
	}
	@Override
	public int updateUser(UserVo vo) {
		int updateCnt = dao.updateUser(vo);
		return updateCnt;
	}
	/**
	 * 
	* Method : encryptPassAllUSser
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	*           : 재적용 하지 마!!! 
	 */
	@Override
	public int encryptPassAllUSser() {
		//사용하지 마세요 이미 암호화 적용되었습니다.
		if(1==1)
			return 0;
//		//0.sql 실행에 필요한 sqlSession 객체를 생성
//		SqlSession sqlSession = MyBatisUtil.getSqlSession();
//		
//		//1.모든 사용자 조회 (단, 기존 암호화 적용 사용자 조회)
//		List<UserVo> userList = dao.userListForPassEncrypt(sqlSession);
//		
//		//2. 조회된 사용자의 비밀번호를 암호화 적용후 사용자 업데이트
//		int updateCntSum = 0;
//		for(UserVo userVo : userList){
//			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
//			userVo.setPass(encryptPass);
//			
//			int updateCnt = dao.updateUserEncryptPass(sqlSession, userVo);
//			updateCntSum += updateCnt;
//			
//			//비정상
//			if(updateCnt != 1){
//				sqlSession.rollback();
//				break;
//			}
//		}
//		//3. sqlSession객체를 commit, close
//		sqlSession.commit();
//		sqlSession.close();
//		
		return 0;
	}
//	
//	public static void main(String[] args){
//		IuserService userService = new UserService();
//		int updateCnt = userService.encryptPassAllUSser();
//		logger.debug("updateCnt : {}", updateCnt);
//	}
	
}

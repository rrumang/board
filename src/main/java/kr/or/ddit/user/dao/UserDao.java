package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IuserDao {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	//@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	private IuserService userService;
	
	//@Before
	public void setup(){
		userService = new UserService();
		logger.debug("setup");
	}
	
	//@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	//@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	public static void main(String[] args) {
		
		/***Given***/
		IuserDao userDao = new UserDao();
		/***When***/
		List<UserVo> userList = userDao.userList();
		/***Then***/
		logger.debug("userList : {}", userList);
		
		
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVo vo = userDao.getUser(userId);
		/***Then***/
		logger.debug("getUser : {}", vo);
	}
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	@Override
	public List<UserVo> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userList");
		sqlSession.close();
		return userList;
	}

	/**
	 * 
	* Method : getUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 특정 사용자정보 조회
	 */
	@Override
	public UserVo getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVo vo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		return vo;
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
	public List<UserVo> userPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userPagingList", pageVo);
		sqlSession.close();
		return userList;
	}
	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :사용자 전체수 조회
	 */
	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int usersCnt = (Integer)sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return usersCnt;
	}
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC08
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 :사용자 등록
	 */
	@Override
	public int insertUser(UserVo vo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("user.insertUser", vo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("user.deleteUser", userId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateUser(UserVo vo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("user.updateUser", vo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}
	
	/**
	 * 
	* Method : userListForPassEncrypt
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 람호화 적용대산 사용자 전체 조회
	 */
	@Override
	public List<UserVo> userListForPassEncrypt(SqlSession sqlSession) {
		return sqlSession.selectList("user.userListForPassEncrypt");
	}
	
	/**
	 * 
	* Method : updateUserEncryptPass
	* 작성자 : PC08
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 적용
	 */
	@Override
	public int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo) {
		return sqlSession.update("user.updateUserEncryptPass", userVo);
	}
	

}

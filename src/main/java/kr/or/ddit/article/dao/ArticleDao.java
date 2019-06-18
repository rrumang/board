package kr.or.ddit.article.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleDao implements IArticleDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleDao.class);
	/**
	 * 
	* Method : articleList
	* 작성자 : PC08
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 해당 게시판 전체 게시글 조회
	 */
	@Override
	public List<ArticleVo> articleList(String boardId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ArticleVo> articleList = sqlSession.selectList("article.articleList", boardId);
		sqlSession.close();
		return articleList;
	}
	
	/**
	 * 
	* Method : getArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleId
	* @return
	* Method 설명 : 특정 게시글 조회
	 */
	@Override
	public ArticleVo getArticle(String articleId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		ArticleVo vo = sqlSession.selectOne("article.getArticle", articleId);
		sqlSession.close();
		return vo;
	}
	
	/**
	 * 
	* Method : articlePagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param resultMap
	* @return
	* Method 설명 : 게시글 페이징, 계층구조 리스트 조회
	 */
	@Override
	public List<ArticleVo> articlePagingList(Map<String, Object> resultMap) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ArticleVo> articleList = sqlSession.selectList("article.articlePagingList", resultMap);
		sqlSession.close();
		return articleList;
	}
	
	/**
	 * 
	* Method : articleCnt
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :게시글 전체수 조회
	 */
	@Override
	public int articleCnt(String boardId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int articleCnt = (Integer)sqlSession.selectOne("article.articleCnt", boardId);
		sqlSession.close();
		return articleCnt;
	}

	/**
	 * 
	* Method : insertArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 등록
	 */
	@Override
	public int insertArticle(ArticleVo articleVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("article.insertArticle", articleVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}
	
	/**
	 * 
	* Method : deleteArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleId
	* @return
	* Method 설명 : 게시글 삭제
	 */
	@Override
	public int deleteArticle(String articleId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.update("article.deleteArticle", articleId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	/**
	 * 
	* Method : updateArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	 */
	@Override
	public int updateArticle(ArticleVo articleVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("article.updateArticle", articleVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}
	
	
	/**
	 * 
	* Method : getArticleId
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :articleId를 가져오는 메서드
	 */
	@Override
	public String getArticleId() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String articleId = sqlSession.selectOne("article.getArticleId");
		return articleId;
	}
	
	

}

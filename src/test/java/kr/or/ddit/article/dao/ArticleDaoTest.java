package kr.or.ddit.article.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.article.model.ArticleVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleDaoTest.class);
	
	private IArticleDao dao;
	
	@Before
	public void setup(){
		dao = new ArticleDao();
		logger.debug("setup");
	}

	@Test
	public void articleListTest() {
		/***Given***/
		String boardId = "1";
		/***When***/
		List<ArticleVo> articleList = dao.articleList(boardId);

		/***Then***/
		assertEquals("1", articleList.get(0).getArticleId());

	}
	
	@Test
	public void getArticleTest(){
		/***Given***/
		String articleId = "1";

		/***When***/
		ArticleVo vo = dao.getArticle(articleId);

		/***Then***/
		assertEquals("brown", vo.getUserId());

	}
	
	@Test
	public void articlePagingListTest(){
		/***Given***/
//		int page =1;
//		int pageSize = 10;
//		String boardId = "1";
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boardId", "1");
		resultMap.put("page", 1);
		resultMap.put("pageSize", 10);
		logger.debug("resultMap : {}", resultMap);

		/***When***/
		List<ArticleVo> articleList = dao.articlePagingList(resultMap);
		logger.debug("ArticleList : {}", articleList);
		logger.debug("ArticleList : {}", articleList.size());
		
		/***Then***/
		assertNotNull(articleList);
		assertEquals(4, articleList.size());

	}
	
	@Test
	public void articleCnt(){
		/***Given***/
		String boardId = "1";

		/***When***/
		int articleCnt = dao.articleCnt(boardId);

		/***Then***/
		assertEquals(10, articleCnt);

	}
	
	@Test
	public void insertArticle(){
		/***Given***/
		ArticleVo vo = new ArticleVo("","1", "cony", "아오진짜", "좀되라");
		
		/***When***/
		int insertCnt = dao.insertArticle(vo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		

	}
	
	@Test
	public void deleteArticle(){
		/***Given***/
		String articleId = "7";

		/***When***/
		int deleteCnt = dao.deleteArticle(articleId);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
	
	@Test
	public void updateArticleTest(){
		/***Given***/
		ArticleVo vo = new ArticleVo("7", "우와!", "좀되라");
		
		/***When***/
		int updateCnt = dao.updateArticle(vo);
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	

}

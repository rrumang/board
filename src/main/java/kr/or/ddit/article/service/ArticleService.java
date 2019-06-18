package kr.or.ddit.article.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.article.dao.ArticleDao;
import kr.or.ddit.article.dao.IArticleDao;
import kr.or.ddit.article.model.ArticleVo;
import kr.or.ddit.paging.model.PageVo;

public class ArticleService implements IArticleService {
	private static final Logger logger = LoggerFactory
			.getLogger(ArticleService.class);
	
	private IArticleDao dao;
	
	public ArticleService() {
		dao = new ArticleDao();
	}

	@Override
	public List<ArticleVo> articleList(String boardId) {
		List<ArticleVo> articleList = new ArrayList<ArticleVo>();
		articleList = dao.articleList(boardId);
		return articleList;
	}

	@Override
	public ArticleVo getArticle(String articleId) {
		ArticleVo vo = new ArticleVo();
		vo = dao.getArticle(articleId);
		return vo;
	}

	@Override
	public Map<String, Object> articlePagingList(Map<String, Object> resultMap) {
		
		Map<String , Object> result = new HashMap<String, Object>();
		result.put("articlePagingList", dao.articlePagingList(resultMap));
		
		String boardId = (String) resultMap.get("boardId");
		int page = (int) resultMap.get("page");
		int pageSize = (int) resultMap.get("pageSize");
		
		int articleCnt = dao.articleCnt(boardId);
		int paginationSize = (int)Math.ceil((double)articleCnt/pageSize);
		
		result.put("paginationSize", paginationSize);
		
		return result;
	}

	@Override
	public int insertArticle(ArticleVo articleVo) {
		int insertCnt = dao.insertArticle(articleVo);
		return insertCnt;
	}

	@Override
	public int deleteArticle(String articleId) {
		int deleteCnt = dao.deleteArticle(articleId);
		return deleteCnt;
	}

	@Override
	public int updateArticle(ArticleVo articleVo) {
		int updateCnt = dao.updateArticle(articleVo);
		return updateCnt;
	}

	@Override
	public String getArticleId() {
		String articleId = dao.getArticleId();
		return articleId;
	}
	
}

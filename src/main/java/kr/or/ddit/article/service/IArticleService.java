package kr.or.ddit.article.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.article.model.ArticleVo;

public interface IArticleService {
	/**
	 * 
	* Method : articleList
	* 작성자 : PC08
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 해당 게시판 전체 게시글 조회
	 */
	List<ArticleVo> articleList(String boardId);
	
	/**
	 * 
	* Method : getArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleId
	* @return
	* Method 설명 : 특정 게시글 조회
	 */
	ArticleVo getArticle(String articleId);
	
	/**
	 * 
	* Method : articlePagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param resultMap
	* @return
	* Method 설명 : 게시글 페이징, 계층구조 리스트 조회
	 */
	Map<String, Object> articlePagingList(Map<String, Object> resultMap);
	
	/**
	 * 
	* Method : insertArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 등록
	 */
	int insertArticle(ArticleVo articleVo);
	
	/**
	 * 
	* Method : deleteArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleId
	* @return
	* Method 설명 : 게시글 삭제
	 */
	int deleteArticle(String articleId);
	
	/**
	 * 
	* Method : updateArticle
	* 작성자 : PC08
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	 */
	int updateArticle(ArticleVo articleVo);
	
	/**
	 * 
	* Method : getArticleId
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :articleId를 가져오는 메서드
	 */
	String getArticleId();
}

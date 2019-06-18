package kr.or.ddit.article.model;

import java.util.Date;

public class ArticleVo {
	private String articleId;
	private String parentId;
	private String boardId;
	private String userId;
	private String title;
	private String content;
	private Date add_dt;
	private String article_use;
	private int lv;
	private String article_group;
	
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAdd_dt() {
		return add_dt;
	}
	public void setAdd_dt(Date add_dt) {
		this.add_dt = add_dt;
	}
	public String getArticle_use() {
		return article_use;
	}
	public void setArticle_use(String article_use) {
		this.article_use = article_use;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getArticle_group() {
		return article_group;
	}
	public void setArticle_group(String article_group) {
		this.article_group = article_group;
	}
	
	//게시글 수정
	public ArticleVo(String articleId, String title, String content) {
		this.articleId = articleId;
		this.title = title;
		this.content = content;
	}
	
	//게시글 등록
	public ArticleVo(String articleId, String parentId, String boardId, String userId, String title, String content) {
		this.articleId = articleId;
		this.parentId = parentId;
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	
	public ArticleVo(String articleId, String boardId, String userId, String title, String content) {
		this.articleId = articleId;
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	
	public ArticleVo() {
	}
	@Override
	public String toString() {
		return "ArticleVo [articleId=" + articleId + ", parentId=" + parentId
				+ ", boardId=" + boardId + ", userId=" + userId + ", title="
				+ title + ", content=" + content + ", add_dt=" + add_dt
				+ ", article_use=" + article_use + ", lv=" + lv
				+ ", article_group=" + article_group + "]";
	}
	
	
}

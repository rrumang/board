package kr.or.ddit.reply.model;

import java.util.Date;


public class ReplyVo {
	private String replyId;
	private String articleId;
	private String userId;
	private String content;
	private Date add_dt;
	private String reply_use;
	
	public String getReply_use() {
		return reply_use;
	}
	public void setReply_use(String reply_use) {
		this.reply_use = reply_use;
	}
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
	public ReplyVo(String replyId, String articleId, String userId,
			String content/*, DATE add_dt, String reply_use*/) {
		this.replyId = replyId;
		this.articleId = articleId;
		this.userId = userId;
		this.content = content;
	}
	
	public ReplyVo() {
		
	}
	
	@Override
	public String toString() {
		return "ReplyVo [replyId=" + replyId + ", articleId=" + articleId
				+ ", userId=" + userId + ", content=" + content + ", add_dt="
				+ add_dt + "]";
	}
	
	
	
	
	
	
	
	
}

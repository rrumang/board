package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface IReplyDao {
	/**
	 * 
	* Method : replyLIst
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 해당 게시글의 대한 전체 댓글 조회
	 */
	List<ReplyVo> replyLIst(String articleId);
	
	/**
	 * 
	* Method : insertReply
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 등록
	 */
	int insertReply(ReplyVo replyVo);
	
	/**
	 * 
	* Method : deleteReply
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 댓글 삭제
	 */
	int deleteReply(String replyId);
	
	/**
	 * 
	* Method : getReplyId
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :replyId가져오기
	 */
	String getReplyId();

}

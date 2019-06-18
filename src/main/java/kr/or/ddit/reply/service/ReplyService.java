package kr.or.ddit.reply.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyService implements IReplyService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyService.class);
	
	private IReplyDao dao;
	
	public ReplyService() {
		dao = new ReplyDao();
	}

	@Override
	public List<ReplyVo> replyLIst(String articleId) {
		List<ReplyVo> replyList = new ArrayList<ReplyVo>();
		replyList = dao.replyLIst(articleId);
		return replyList;
	}

	@Override
	public int insertReply(ReplyVo replyVo) {
		int insertCnt = dao.insertReply(replyVo);
		return insertCnt;
	}

	@Override
	public int deleteReply(String replyId) {
		int deleteCnt = dao.deleteReply(replyId);
		return deleteCnt;
	}

	@Override
	public String getReplyId() {
		String getReplyId  = dao.getReplyId();
		return getReplyId;
	}

}

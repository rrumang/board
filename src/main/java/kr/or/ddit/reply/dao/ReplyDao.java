package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements IReplyDao {

	@Override
	public List<ReplyVo> replyLIst(String articleId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ReplyVo> replyList = sqlSession.selectList("reply.replyList", articleId);
		return replyList;
	}

	@Override
	public int insertReply(ReplyVo replyVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("reply.insertReply", replyVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteReply(String replyId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.update("reply.deleteReply", replyId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public String getReplyId() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String getReplyId = sqlSession.selectOne("reply.getReplyId");
		return getReplyId;
	}

}

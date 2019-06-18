package kr.or.ddit.reply.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplyDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyDaoTest.class);
	
	private IReplyDao dao;
	
	@Before
	public void setup(){
		dao = new ReplyDao();
	}

	@Test
	public void replyListTest() {
		/***Given***/
		String articleId = "6";

		/***When***/
		List<ReplyVo> replyList = dao.replyLIst(articleId);

		/***Then***/
		assertEquals("1", replyList.get(0).getReplyId());

	}
	
	@Test
	public void insertReplyTest(){
		/***Given***/
		ReplyVo vo = new  ReplyVo("2", "6", "brown", "반가워요");

		/***When***/
		int insertCnt = dao.insertReply(vo);

		/***Then***/
		assertEquals(1, insertCnt);

	}
	
	@Test
	public void deleteReplytest(){
		/***Given***/
		String replyId = "2";

		/***When***/
		int deleteCnt = dao.deleteReply(replyId);

		/***Then***/
		assertEquals(1, deleteCnt);

	}

}

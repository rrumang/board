package kr.or.ddit.reply.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.reply.dao.IReplyDao;
import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoTest;
import kr.or.ddit.reply.model.ReplyVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplyServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(ReplyDaoTest.class);
	
	private IReplyService service;
	
	@Before
	public void setup(){
		service = new  ReplyService();
	}

	@Test
	public void replyListTest() {
		/***Given***/
		String articleId = "6";

		/***When***/
		List<ReplyVo> replyList = service.replyLIst(articleId);

		/***Then***/
		assertEquals("1", replyList.get(0).getReplyId());

	}
	
	@Test
	public void insertReplyTest(){
		/***Given***/
		ReplyVo vo = new  ReplyVo("2", "6", "brown", "반가워요");

		/***When***/
		int insertCnt = service.insertReply(vo);

		/***Then***/
		assertEquals(1, insertCnt);

	}
	
	@Test
	public void deleteReplytest(){
		/***Given***/
		String replyId = "2";

		/***When***/
		int deleteCnt = service.deleteReply(replyId);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
}

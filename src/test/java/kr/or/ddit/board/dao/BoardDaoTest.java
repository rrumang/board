package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	private IBoardDao dao;
	
	@Before
	public void setup(){
		dao = new BoardDao();
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}

	@Test
	public void boardListTest() {
		/***Given***/
		/***When***/
		List<BoardVo> boardList = dao.boardList();
		logger.debug("boardList : {}", boardList);

		/***Then***/
		assertEquals("brown", boardList.get(0).getUserId());

	}
	
	@Test
	public void getBoardTest(){
		/***Given***/
		String boardId = "1";

		/***When***/
		BoardVo vo = dao.getBoard(boardId);

		/***Then***/
		assertEquals("자유게시판", vo.getName());
	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		Date dt = new Date(); 
		BoardVo vo = new BoardVo("brown", "질문게시판", "y");

		/***When***/
		int insertCnt = dao.insertBoard(vo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteBoardTest(){
		/***Given***/
		String boardId = "2";

		/***When***/
		//int deleteCnt = dao.deleteBoard(boardId);

		/***Then***/
		//assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateBoardTest(){
		/***Given***/
		String boardId = "2";

		/***When***/
		//int updateCnt = dao.updateBoard(boardId);

		/***Then***/
		//assertEquals(1, updateCnt);
	}

}

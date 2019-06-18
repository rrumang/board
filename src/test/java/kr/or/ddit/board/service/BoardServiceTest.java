package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(BoardServiceTest.class);
	
	private IBoardService service = new BoardService();

	@Test
	public void boardListTest() {
		/***Given***/
		/***When***/
		List<BoardVo> boardList = service.boardList();
		logger.debug("boardList : {}", boardList);

		/***Then***/
		assertEquals("brown", boardList.get(0).getUserId());

	}
	
	@Test
	public void getBoardTest(){
		/***Given***/
		String boardId = "1";

		/***When***/
		BoardVo vo = service.getBoard(boardId);

		/***Then***/
		assertEquals("자유게시판", vo.getName());
	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		Date dt = new Date(); 
		BoardVo vo = new BoardVo("brown", "질문게시판", "y");

		/***When***/
		int insertCnt = service.insertBoard(vo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteBoardTest(){
		/***Given***/
		String boardId = "2";

		/***When***/
		//int deleteCnt = service.deleteBoard(boardId);

		/***Then***/
		//assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateBoardTest(){
		/***Given***/
		String boardId = "2";

		/***When***/
		//int updateCnt = service.updateBoard(boardId);

		/***Then***/
		//assertEquals(1, updateCnt);
	}

}

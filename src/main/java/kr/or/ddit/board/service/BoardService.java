package kr.or.ddit.board.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements IBoardService {
	private static final Logger logger = LoggerFactory
			.getLogger(BoardService.class);
	
	private IBoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}
	
	@Override
	public List<BoardVo> boardList() {
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		boardList = dao.boardList();
		return boardList;
	}

	@Override
	public BoardVo getBoard(String boardId) {
		BoardVo vo = new BoardVo();
		vo = dao.getBoard(boardId);
		return vo;
	}

	@Override
	public int insertBoard(BoardVo vo) {
		int insertCnt = dao.insertBoard(vo);
		return insertCnt;
	}

	@Override
	public int deleteBoard(BoardVo vo) {
		int deleteCnt = dao.deleteBoard(vo);
		return deleteCnt;
	}

	@Override
	public int updateBoard(BoardVo vo) {
		int updateCnt = dao.updateBoard(vo);
		return updateCnt;
	}

}

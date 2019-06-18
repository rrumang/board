package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class BoardDao implements IBoardDao {

	@Override
	public List<BoardVo> boardList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardList");
		sqlSession.close();
		return boardList;
	}

	@Override
	public BoardVo getBoard(String boardId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BoardVo vo = sqlSession.selectOne("board.getBoard", boardId);
		sqlSession.close();
		return vo;
	}

	@Override
	public int insertBoard(BoardVo vo) {
		SqlSession sqlSession  = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("board.insertBoard", vo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteBoard(BoardVo vo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.update("board.deleteBoard", vo);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateBoard(BoardVo vo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("board.updateBoard", vo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

}

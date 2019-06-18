package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface IBoardService {
	
	/**
	 * 
	* Method : boardList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 전체 조회
	 */
	List<BoardVo> boardList();
	
	/**
	 * 
	* Method : getBoard
	* 작성자 : PC08
	* 변경이력 :
	* @param boardId
	* @return
	* Method 설명 : 특정 게시판 조회
	 */
	BoardVo getBoard(String boardId);
	
	/**
	 * 
	* Method : insertBoard
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 생성
	 */
	int insertBoard(BoardVo vo);
	
	/**
	 * 
	* Method : deleteBoard
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 삭제(미사용)
	 */
	int deleteBoard(BoardVo vo);
	
	/**
	 * 
	* Method : updateBoard
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 수정(사용)
	 */
	int updateBoard(BoardVo vo);
}

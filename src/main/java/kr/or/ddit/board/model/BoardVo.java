package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	private String boardId; // 게시판 아이디
	private String userId;  // 생성자
	private String name;    // 게시판 이름
	private String use_yn;  // 사용여부
	private Date reg_dt;  // 생성일시
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardid) {
		this.boardId = boardid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userid) {
		this.userId = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	public BoardVo() {
	}
	
	public BoardVo(/*String boardId,*/ String userId, String name, String use_yn/*,
			Date reg_dt*/) {
		this.boardId = boardId;
		this.userId = userId;
		this.name = name;
		this.use_yn = use_yn;
		this.reg_dt = reg_dt;
	}
	
	public BoardVo(String boardId, String name) {
		this.boardId = boardId;
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "BoardVo [boardid=" + boardId + ", userid=" + userId + ", name="
				+ name + ", use_yn=" + use_yn + ", reg_dt=" + reg_dt + "]";
	}
	
	
	
	
	
	
	
}

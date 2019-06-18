package kr.or.ddit.addfile.dao;

import java.util.List;

import kr.or.ddit.addfile.model.AddfileVo;

public interface IAddfileDao {
	
	/**
	 * 
	* Method : fileList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 해당 게시글의 전체 파일 리스트조회
	 */
	List<AddfileVo> fileList(String articleId);
	
	AddfileVo getFile(String fileId);
	
	/**
	 * 
	* Method : insertFile
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 파일 추가
	 */
	int insertFile(AddfileVo vo);
	
	/**
	 * 
	* Method : deleteFile
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 파일 삭제
	 */
	int deleteFile(String fileId);
	
	/**
	 * 
	* Method : getFileId
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 :파일아이디 가져오기
	 */
	String getFileId();
}

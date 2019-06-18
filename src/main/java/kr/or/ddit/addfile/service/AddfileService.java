package kr.or.ddit.addfile.service;

import java.util.List;

import kr.or.ddit.addfile.dao.AddfileDao;
import kr.or.ddit.addfile.dao.IAddfileDao;
import kr.or.ddit.addfile.model.AddfileVo;

public class AddfileService implements IAddfileService {
	
	private IAddfileDao dao;
	
	public AddfileService() {
		dao = new AddfileDao();
	}

	@Override
	public List<AddfileVo> fileList(String articleId) {
		List<AddfileVo> fileList = dao.fileList(articleId);
		return fileList;
	}

	@Override
	public int insertFile(AddfileVo vo) {
		int insertCnt = dao.insertFile(vo);
		return insertCnt;
	}

	@Override
	public int deleteFile(String fileId) {
		int deleteCnt = dao.deleteFile(fileId);
		return deleteCnt;
	}

	@Override
	public String getFileId() {
		String getFileId = dao.getFileId();
		return getFileId;
	}

	@Override
	public AddfileVo getFile(String fileId) {
		AddfileVo getFile = dao.getFile(fileId);
		return getFile;
	}

}

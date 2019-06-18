package kr.or.ddit.addfile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.addfile.model.AddfileVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class AddfileDao implements IAddfileDao{

	@Override
	public List<AddfileVo> fileList(String articleId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<AddfileVo> fileList = sqlSession.selectList("addfile.fileList", articleId);
		sqlSession.close();
		return fileList;
	}

	@Override
	public int insertFile(AddfileVo vo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("addfile.insertFile", vo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteFile(String fileId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("addfile.deleteFile", fileId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public String getFileId() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String getFileId = sqlSession.selectOne("addfile.getFileId");
		return getFileId;
	}

	@Override
	public AddfileVo getFile(String fileId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AddfileVo getFile = sqlSession.selectOne("addfile.getfile",fileId);
		return getFile;
	}

}

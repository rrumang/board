package kr.or.ddit.addfile.model;

public class AddfileVo {
	
	private String fileId;
	private String articleId;
	private String path;
	private String fileName;
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public AddfileVo(String fileId, String articleId, String path,
			String fileName) {
		this.fileId = fileId;
		this.articleId = articleId;
		this.path = path;
		this.fileName = fileName;
	}
	
	public AddfileVo(String fileId, String articleId) {
		this.fileId = fileId;
		this.articleId = articleId;
	}
	
	public AddfileVo() {
	}
	
	@Override
	public String toString() {
		return "AddfileVo [fileId=" + fileId + ", articleId=" + articleId
				+ ", path=" + path + ", fileName=" + fileName + "]";
	}
	
	
	
	
	
}

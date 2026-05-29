package com.ordersprocessing.model;

import java.time.LocalDateTime;

public class FileMetadata {

	 private String fileName;

	    private LocalDateTime uploadTime;

	    private String status;

		public FileMetadata(String fileName, LocalDateTime uploadTime, String status) {
			super();
			this.fileName = fileName;
			this.uploadTime = uploadTime;
			this.status = status;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public LocalDateTime getUploadTime() {
			return uploadTime;
		}

		public void setUploadTime(LocalDateTime uploadTime) {
			this.uploadTime = uploadTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "FileMetadata [fileName=" + fileName + ", uploadTime=" + uploadTime + ", status=" + status + "]";
		}

		public FileMetadata() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}

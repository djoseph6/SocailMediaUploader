package services;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import util.FileUploadUtil;

public class FileUploadServiceImpl implements FileUploadService{
	private static File videoFile;
	
	@Autowired
	FileUploadUtil uploadUtil = new FileUploadUtil();


	@Override
	public void uploadFileToAllSM() {
		// TODO Auto-generated method stub
		
	}

}

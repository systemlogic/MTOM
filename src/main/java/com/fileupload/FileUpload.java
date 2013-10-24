package com.fileupload;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="fileUploadService" ,targetNamespace="fileupload.com" , portName="fileuploadPort")
public class FileUpload {

	@WebMethod
	public void upload(DataHandler dh) {
		DataSource ds = dh.getDataSource();
		try{
		InputStream is = ds.getInputStream();
		FileOutputStream fos = new FileOutputStream("/home/arorah1/File.txt");
		int data = 0;
		while((data=is.read())!=-1) fos.write(data);
		fos.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

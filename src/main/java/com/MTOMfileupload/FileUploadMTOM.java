package com.MTOMfileupload;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;


@WebService(name="MTOMfileUploadService" ,targetNamespace="MTOMfileupload.com" , portName="MTOMfileuploadPort")
@MTOM
public class FileUploadMTOM {
	@WebMethod
	public void uploadMTOMWay(@XmlMimeType("application/octet-stream") DataHandler dh) {
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

package com.imagr.uploading.api.FileController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imagr.uploading.api.FilePayload.FileResponse;
import com.imagr.uploading.apiServices.FileServices;

@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private  FileServices fileServices; 
	@Value("{project.image}")
	 private String path;
	@PostMapping("/upload")
	public ResponseEntity<FileResponse>fileUpload(@RequestParam("image") MultipartFile image){
		
		
		try {
			String uploadImage = this.fileServices.uploadImage(path, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<> (new FileResponse(null, "image is not uploaded due to erroe on server!!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<> (new FileResponse(null, "image is uploaded successfully!!"),HttpStatus.OK);
	}

}

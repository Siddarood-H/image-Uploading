package com.imagr.uploading.apiServices;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileServices {
	String uploadImage(String peth,MultipartFile file)throws IOException;

}

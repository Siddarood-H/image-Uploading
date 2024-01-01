package com.imagr.uploading.apiServices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileServices {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		//File name
		
				String name=file.getOriginalFilename();
				//abc.png
				
				//random name generate file
				String randomID=UUID.randomUUID().toString();
				String fileName=randomID.concat(name.substring(name.lastIndexOf(",")));
				
				//Fullpath
				String filePath =path+File.separator+fileName;
				
				
				//create folder if not created
				File f=new File(path);
				if(!f.exists()) {
					f.mkdir();
				}
				//File copy
				Files.copy(file.getInputStream(), Paths.get(filePath));
				
				return name;
		
	}

}

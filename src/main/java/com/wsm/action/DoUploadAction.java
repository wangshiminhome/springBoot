package com.wsm.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DoUploadAction {
	@RequestMapping("/upload.do")
	public String upload(HttpServletRequest request,MultipartFile photo[]) throws IllegalStateException, IOException{
		String path=request.getRealPath("//files//");
		for(int i=0;i<photo.length;i++){
			String name=photo[i].getOriginalFilename();//获取的名称为绝对路径  所以需要截取
			name=name.substring(name.lastIndexOf("\\")+1);
			photo[i].transferTo(new File(path+"//"+name));
		}
		return "上传成功";
	}
}

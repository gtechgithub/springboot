package com.javapoint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

	private static String UPLOADED_FOLDER = "C://Users//gocothakotai//";
	
	@GetMapping("/")
	public String index() {
		System.out.println("inside index");
		return "upload";
	}
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile multiPart,RedirectAttributes redirectAttributes) {
		
		//add flash attribute will redirect attribute between 2 controller view, but addAttribute is just set the variable which can be accessed using get_attribute
		if(multiPart.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","Please select the file to upload");
			return "redirect:uploadStatus";
		}
		
		try {
			byte[] bytes =  multiPart.getBytes();
			Path path =  Paths.get(UPLOADED_FOLDER + multiPart.getOriginalFilename());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message","File uploaded Successfully filename:" + multiPart.getOriginalFilename());
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:uploadStatus";
	}
		
	@GetMapping("uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
}

package com.zz.HttpClient.modules.demo.web;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zz.HttpClient.common.utils.FileUtil;
import com.zz.HttpClient.common.web.BaseController;
import com.zz.HttpClient.modules.demo.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController {
	
	@Autowired
	private TestService testService;
	
	/***
	 * 
	 * @Title：foldLineDiagram
	 * @Description: TODO(图片分类)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/screen", method = RequestMethod.GET)
	public void foldLineDiagram(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<String> type = Arrays.asList("jpg", "jpeg", "JPG", "JPEG");
			
			File[] files = FileUtil.listAll(new File("D:/AIData/train"), new FileFilter() {
								@Override
								public String getDescription() {
									return null;
								}
								
								@Override
								public boolean accept(File f) {
									if (type.contains(FileUtil.getFileType(f))) {
										return Boolean.TRUE;
									}
									return Boolean.FALSE;
								}
							});
			for(File file : files) {
				String fileId = FileUtil.getNamePart(file);
				FileUtil.CopyFile(file, new File("D:/AIData/test/" + testService.getFileType(fileId) + "/" + file.getName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

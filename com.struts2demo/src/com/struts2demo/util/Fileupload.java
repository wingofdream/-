package com.struts2demo.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class Fileupload {

	/**
	 * struts文件上传
	 * 
	 * @param image
	 *            上传的文件
	 * @param imageFileName
	 *            文件名
	 * @param savefloder
	 *            文件要保存的文件夹名
	 * @return 成功返回文件路径，失败返回空串
	 */
	public static String flieupload(File image, String imageFileName, String savefloder) {

		HttpServletRequest request = ServletActionContext.getRequest();
		// 保存到根目录下的uploadImages文件夹下
		String realPath = ServletActionContext.getServletContext().getRealPath("/" + savefloder);// 取得真实路径
		//自动改名
		if (imageFileName != null && imageFileName.length() != 0) {
			Random random = new Random(999);
			int tempint = random.nextInt();
			Date datenew = new Date();
			SimpleDateFormat simpleDateFormatnew = new SimpleDateFormat("yyyyMMddhhmmss");
			int last = imageFileName.lastIndexOf(".");
			// String head = imageFileName.substring(0,last);
			String type = imageFileName.substring(last);
			imageFileName = simpleDateFormatnew.format(datenew) + tempint + type;
			// 创建父文件夹
			if (image != null) {
				File saveFile = new File(new File(realPath), imageFileName);
				if (!saveFile.getParentFile().exists()) {// 如果文件夹不存在
					saveFile.getParentFile().mkdirs(); // 则创建新的多级文件夹
				}
				try {
					FileUtils.copyFile(image, saveFile); // 保存文件
					// ActionContext.getContext().put("message", "上传成功！");

					String path = request.getContextPath();
					String basePath = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + path + "/";
					String picturePath = basePath + savefloder + "/" + imageFileName;//绝对路径
					String RelativePath = savefloder + "/" + imageFileName;//相对路径
					System.out.println(picturePath);
					System.out.println(RelativePath);
					return RelativePath;
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return "";
	}
	
	/**
	 * 文件上传
	 * @param image 文件
	 * @param imageFileName 文件名
	 * @param savefloder 文件夹
	 * @param savename 保存文件名
	 * @return 成功返回文件相对路径，失败返回空串
	 */
	public static String fileuploadCustomName(File image, String imageFileName, String savefloder,String savename){
		HttpServletRequest request = ServletActionContext.getRequest();
		// 保存到根目录下的uploadImages文件夹下
		String realPath = ServletActionContext.getServletContext().getRealPath("/" + savefloder);// 取得真实路径
		//自动改名
		if (imageFileName != null && imageFileName.length() != 0) {
			int last = imageFileName.lastIndexOf(".");
			// String head = imageFileName.substring(0,last);
			String type = imageFileName.substring(last);
			imageFileName = savename + type;
			// 创建父文件夹
			if (image != null) {
				File saveFile = new File(new File(realPath), imageFileName);
				if (!saveFile.getParentFile().exists()) {// 如果文件夹不存在
					saveFile.getParentFile().mkdirs(); // 则创建新的多级文件夹
				}
				try {
					FileUtils.copyFile(image, saveFile); // 保存文件
					// ActionContext.getContext().put("message", "上传成功！");

					String path = request.getContextPath();
					String basePath = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + path + "/";
					String picturePath = basePath + savefloder + "/" + imageFileName;//绝对路径
					String RelativePath = savefloder + "/" + imageFileName;//相对路径
					System.out.println(picturePath);
					System.out.println(RelativePath);
					return RelativePath;
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return "";
	}

}

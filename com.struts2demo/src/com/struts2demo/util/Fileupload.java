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
	 * struts�ļ��ϴ�
	 * 
	 * @param image
	 *            �ϴ����ļ�
	 * @param imageFileName
	 *            �ļ���
	 * @param savefloder
	 *            �ļ�Ҫ������ļ�����
	 * @return �ɹ������ļ�·����ʧ�ܷ��ؿմ�
	 */
	public static String flieupload(File image, String imageFileName, String savefloder) {

		HttpServletRequest request = ServletActionContext.getRequest();
		// ���浽��Ŀ¼�µ�uploadImages�ļ�����
		String realPath = ServletActionContext.getServletContext().getRealPath("/" + savefloder);// ȡ����ʵ·��
		//�Զ�����
		if (imageFileName != null && imageFileName.length() != 0) {
			Random random = new Random(999);
			int tempint = random.nextInt();
			Date datenew = new Date();
			SimpleDateFormat simpleDateFormatnew = new SimpleDateFormat("yyyyMMddhhmmss");
			int last = imageFileName.lastIndexOf(".");
			// String head = imageFileName.substring(0,last);
			String type = imageFileName.substring(last);
			imageFileName = simpleDateFormatnew.format(datenew) + tempint + type;
			// �������ļ���
			if (image != null) {
				File saveFile = new File(new File(realPath), imageFileName);
				if (!saveFile.getParentFile().exists()) {// ����ļ��в�����
					saveFile.getParentFile().mkdirs(); // �򴴽��µĶ༶�ļ���
				}
				try {
					FileUtils.copyFile(image, saveFile); // �����ļ�
					// ActionContext.getContext().put("message", "�ϴ��ɹ���");

					String path = request.getContextPath();
					String basePath = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + path + "/";
					String picturePath = basePath + savefloder + "/" + imageFileName;//����·��
					String RelativePath = savefloder + "/" + imageFileName;//���·��
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
	 * �ļ��ϴ�
	 * @param image �ļ�
	 * @param imageFileName �ļ���
	 * @param savefloder �ļ���
	 * @param savename �����ļ���
	 * @return �ɹ������ļ����·����ʧ�ܷ��ؿմ�
	 */
	public static String fileuploadCustomName(File image, String imageFileName, String savefloder,String savename){
		HttpServletRequest request = ServletActionContext.getRequest();
		// ���浽��Ŀ¼�µ�uploadImages�ļ�����
		String realPath = ServletActionContext.getServletContext().getRealPath("/" + savefloder);// ȡ����ʵ·��
		//�Զ�����
		if (imageFileName != null && imageFileName.length() != 0) {
			int last = imageFileName.lastIndexOf(".");
			// String head = imageFileName.substring(0,last);
			String type = imageFileName.substring(last);
			imageFileName = savename + type;
			// �������ļ���
			if (image != null) {
				File saveFile = new File(new File(realPath), imageFileName);
				if (!saveFile.getParentFile().exists()) {// ����ļ��в�����
					saveFile.getParentFile().mkdirs(); // �򴴽��µĶ༶�ļ���
				}
				try {
					FileUtils.copyFile(image, saveFile); // �����ļ�
					// ActionContext.getContext().put("message", "�ϴ��ɹ���");

					String path = request.getContextPath();
					String basePath = request.getScheme() + "://" + request.getServerName() + ":"
							+ request.getServerPort() + path + "/";
					String picturePath = basePath + savefloder + "/" + imageFileName;//����·��
					String RelativePath = savefloder + "/" + imageFileName;//���·��
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

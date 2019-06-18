package com.struts2demo.action;

import java.io.File;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.struts2demo.util.Fileupload;

public class userLogin extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File image;
	private String imageFileName;

	public String execute() {
		String path = Fileupload.fileuploadCustomName(image, imageFileName, "admin", "1101");
		if (!path.equals("")) {
			System.out.println(path);
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}

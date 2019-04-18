package org.dreamtech.o2o.dto;

import java.io.InputStream;

/**
 * 封装图片信息
 * 
 * @author Xu Yiqing
 *
 */
public class ImageHolder {
	// 图片名
	private String imageName;
	// 图片流对象
	private InputStream image;

	public ImageHolder(String imageName, InputStream image) {
		this.imageName = imageName;
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}
}

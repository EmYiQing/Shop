package org.dreamtech.o2o.util;

import java.io.File;

/**
 * 路径处理工具
 * 
 * @author Xu Yiqing
 *
 */
public class PathUtil {
	// WINDOWS系统默认路径
	private static final String WIN_IMAGE_PATH = "D:/temp/image";
	// 分隔符
	private static final String SEPERATOR = File.separator;

	/**
	 * 获得图片根路径
	 * 
	 * @return
	 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = WIN_IMAGE_PATH;
		}
		return basePath.replace("/", SEPERATOR);
	}

	/**
	 * 获得店铺图片路径
	 * 
	 * @param shopId
	 *            店铺ID
	 * @return String
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", SEPERATOR);
	}
}

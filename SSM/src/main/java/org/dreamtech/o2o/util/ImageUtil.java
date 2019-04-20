package org.dreamtech.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.dreamtech.o2o.dto.ImageHolder;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片处理工具
 * 
 * @author Xu Yiqing
 *
 */
public class ImageUtil {
	// 根路径
	private static final String BASE_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	// 日期格式
	private static final SimpleDateFormat DATE_FORMET = new SimpleDateFormat("yyyyMMddHHmmss");
	// 随机数生成
	private static final Random RANDOM = new Random();

	/**
	 * 类型转换
	 * 
	 * @param file
	 *            CommonsMultipartFile类型
	 * @return File
	 */
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile file) {
		File newFile = new File(file.getOriginalFilename());
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile;
	}

	/**
	 * 生成图片
	 * 
	 * @param thumbnail
	 *            图片封装
	 * @param targetAddr
	 *            目标地址
	 * @return String
	 */
	public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());

		makeDirPath(targetAddr);

		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);

		try {

			Thumbnails.of(thumbnail.getImage()).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT,
							ImageIO.read(new File(BASE_PATH + File.separator + "watermark.jpg")), 0.25f)
					.outputQuality(0.8f).toFile(dest);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}

	/**
	 * 生成目录
	 * 
	 * @param targetAddr
	 *            目标路径
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * 获得文件扩展名
	 * 
	 * @param fileName
	 *            文件名
	 * @return String
	 */
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 获得随机文件名
	 * 
	 * @return
	 */
	public static String getRandomFileName() {
		int ranNum = RANDOM.nextInt(89999) + 10000;
		String nowTimeStr = DATE_FORMET.format(new Date());
		return nowTimeStr + ranNum;
	}

	/**
	 * 删除文件或路径
	 * 
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if (fileOrPath.exists()) {
			if (fileOrPath.isDirectory()) {
				File files[] = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}

	/**
	 * 生成图片（337*640）
	 * 
	 * @param thumbnail
	 *            图片封装
	 * @param targetAddr
	 *            目录路径
	 * @return String
	 */
	public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {

		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());

		makeDirPath(targetAddr);

		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);

		try {

			Thumbnails.of(thumbnail.getImage()).size(337, 640)
					.watermark(Positions.BOTTOM_RIGHT,
							ImageIO.read(new File(BASE_PATH + File.separator + "watermark.jpg")), 0.25f)
					.outputQuality(0.9f).toFile(dest);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}
}

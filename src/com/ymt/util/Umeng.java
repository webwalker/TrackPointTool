package com.ymt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xujian on 2015/11/5.
 */
public class Umeng {
	public static int itemCount = 0;
	
	private static File getUmengFilePath() {
		File directory = new File("");
		return new File(directory.getAbsolutePath()
				+ "/lib/build/libs/umeng.txt");
	}

	public static String getCurrentPath() {
		File directory = new File("");
		return directory.getAbsolutePath();
	}

	public static boolean formatData(String fileName, String outFileName) {
		itemCount = 0;
		if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
			return formatExcelData(fileName);
		} else {
			return formatTextData(fileName, outFileName);
		}
	}

	public static boolean formatTextData(String fileName, String outFileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.print("file not existed!");
			return false;
		}
		FileInputStream fis = null;
		BufferedReader buf = null;
		try {
			fis = new FileInputStream(file.getAbsolutePath());
			String line = null;
			buf = new BufferedReader(new InputStreamReader(fis, "GB2312"));
			StringBuilder sb = new StringBuilder();
			while ((line = buf.readLine()) != null) {
				Matcher matcher = regexs.matcher(line);
				if (matcher.find()) {
					sb.append("public static final String "
							+ matcher.group(1).toUpperCase() + " = "
							+ matcher.group(1) + ";//" + matcher.group(2)
							+ "\r\n");
					itemCount++;
				}
			}
			FileUtils.writeFile(sb.toString(), outFileName, false);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return true;
	}

	public static boolean formatExcelData(String path) {
		return true;
	}

	private final static Pattern regexs = Pattern.compile("(\\w+)\\s+(.+)");

	private final static String format = "public static final $1 = $1;//$2";
}

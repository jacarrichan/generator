package cn.org.rapid_framework.generator.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class FileHelper {
	/**
	 * 得到相对路径
	 */
	public static String getRelativePath(File baseDir, File file) {
		if (baseDir.equals(file))
			return "";
		if (baseDir.getParentFile() == null)
			return file.getAbsolutePath().substring(
					baseDir.getAbsolutePath().length());
		return file.getAbsolutePath().substring(
				baseDir.getAbsolutePath().length() + 1);
	}
}

package second;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileProcess {

	/**
	 * read all file in folder
	 * 
	 * @param path
	 */
	public static void readFolder(String path) {
		int fileNum = 0, folderNum = 0;
		File file = new File(path);
		if (file.exists()) {
			LinkedList<File> list = new LinkedList<File>();
			File[] files = file.listFiles();
			for (File file2 : files) {
				if (file2.isDirectory()) {// System.out.println("DIR : " +
											// file2.getAbsolutePath());
					list.add(file2);
					folderNum++;
				} else {
					System.out.println("FILE: " + file2.getAbsolutePath());
					WordProcess.pruneText(file2.getAbsolutePath());
					fileNum++;
				}
			}
			File temp_file;
			while (!list.isEmpty()) {
				temp_file = list.removeFirst();
				files = temp_file.listFiles();
				for (File file2 : files) {
					if (file2.isDirectory()) {// System.out.println("DIR : " +
												// file2.getAbsolutePath());
						list.add(file2);
						folderNum++;
					} else {
						System.out.println("FILE: " + file2.getAbsolutePath());
						fileNum++;
						WordProcess.pruneText(file2.getAbsolutePath());
					}
				}
			}
		} else {
			System.out.println("File is not exist!");
		}
		System.out.println("    num dir is: " + folderNum
				+ "\n    num file is: " + fileNum);
	}

	/**
	 * read content from filePath and return content
	 * 
	 * @param filePath
	 */
	public static String readFile(String filePath) {
		File file = new File(filePath);
		StringBuffer result = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				result.append(" ");
				result.append(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return result.toString();
	}

	/**
	 * write content into filePath
	 * 
	 * @param dataList
	 */
	public static void writeFile(List<Map.Entry<String, Integer>> dataList) {
		System.out.println("start write word and frequency");
		int size = dataList.size();
		File file = null;
		FileWriter fileWrite = null;
		PrintWriter pw = null;
		int count = 1;
		try {
			// if file exist ,append ; if not, create
			file = new File(WordProcess.RESULTPATH);
			fileWrite = new FileWriter(file, true);
			pw = new PrintWriter(fileWrite);
			for (int i = 0; i < size; i++) {
				String word = dataList.get(i).getKey();
				int frequency = dataList.get(i).getValue();
				// System.out.println(word + " : " + frequency);
				pw.print(word);
				pw.print(" ");
				pw.print(count++);
				pw.print(" ");
				pw.print(frequency);
				pw.println();
			}
			pw.flush();
			fileWrite.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				fileWrite.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("end write word and frequency");
		}
	}
}

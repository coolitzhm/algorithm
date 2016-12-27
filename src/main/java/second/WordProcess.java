package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordProcess {

	private static final String DATASOURCEPATH = "D://mallet_data//0DataSource//Watches_Child//Sports_Watches";
	private static final String STOPWORDSPATH = "C://mallet-2.0.7//stoplists//en.txt";
	public static final String RESULTPATH = "D://automotives//result.txt";
	private static Map<String, Integer> dataHash = new HashMap<String, Integer>();
	private static Set<String> stopWordsSet = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		loadStopWords();// we could get what words in the text
		FileProcess.readFolder(DATASOURCEPATH);
		List<Map.Entry<String, Integer>> dataList = hashSort();
		FileProcess.writeFile(dataList);
	}

	public static void pruneText(String textPath) {
		String text = FileProcess.readFile(textPath).toLowerCase();// 将所有字母化为小写
		text = text.replaceAll("^[a-zA-Z0-9']|\\s+|\t|\r", " "); // 将非字母字符、多个空格回车换行均化为一个空格,正则表达式
		String words[] = text.split("\\s+");// 取出单词，并将单词存入数组中
		getFrequency(words);
	}

	public static void getFrequency(String[] words) {
		for (int i = 0; i < words.length; i++) {
			String key = words[i]; // key对应单词
			if ((dataHash.get(key) != null) && (!stopWordsSet.contains(key))) {
				int value = ((Integer) dataHash.get(key)).intValue(); // value对应单词出现的频率，单词已在map中存在则value+1
				value++;
				dataHash.put(key, new Integer(value));
			} else {
				dataHash.put(key, new Integer(1)); // 单词未在map中存在则value初始化为1
			}
		}
	}

	// according to the words number ,sort
	public static List<Map.Entry<String, Integer>> hashSort() {
		List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String, Integer>>(
				dataHash.entrySet());
		Collections.sort(list_Data,
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Map.Entry<String, Integer> o1,
							Map.Entry<String, Integer> o2) {
						if (o2.getValue() != null && o1.getValue() != null
								&& o2.getValue().compareTo(o1.getValue()) > 0) {
							return 1;
						} else {
							return -1;
						}
					}
				});
		return list_Data;
	}

	public static void loadStopWords() {
		String stopWordsText = FileProcess.readFile(STOPWORDSPATH);
		// System.out.println(stopWordsText);
		String words[] = stopWordsText.split("\\s+|\\t|\\r|\\n");// 取出单词，并将单词存入数组中?
		System.out.println(words.length);
		for (String word : words) {
			stopWordsSet.add(word);
		}
	}
}

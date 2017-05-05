package tongji;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Check {

	static HashMap<String, Integer> has = new HashMap<String, Integer>();

	public static void search(String str) {

		if (str == null || str == " ") {
			System.out.print("读取文件为空");
			return;
		}
		String[] target = str.split("[^a-zA-Z0-9_]+");

		for (int i = 0; i < target.length; i++) {
			if (!has.containsKey(target[i])) {
				has.put(target[i], 1);
			} else {
				has.put(target[i], has.get(target[i]) + 1);
			}
		}
	}

	public static void sortMap() {

		List<Map.Entry<String, Integer>> List_Data = new ArrayList<Map.Entry<String, Integer>>(has.entrySet());
		Collections.sort(List_Data, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o2.getValue() != null && o1.getValue() != null && o2.getValue().compareTo(o1.getValue()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		System.out.println("单词出现频率最高统计");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");// 设置日期格式
		System.out.println("----------" + df.format(new Date()) + "----------");// new
																				// Date()为获取当前系统时间
		FileUtil.write("----------" + df.format(new Date()) + "----------" + " ");
		FileUtil.write("\r\n");
		try {
			for (int i = 0; i < 10; i++) {
				String word = List_Data.get(i).getKey();
				String fre = List_Data.get(i).getValue().toString();
				System.out.println(word + ":" + fre);
				FileUtil.write(word + ":");
				FileUtil.write(fre + "\r\n" + " ");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("排序时传入集合为空,程序结束");
			return;
		}
	}
	
	//根据用户的需求查找
	public static void mySearch(String str){
		if(has.get(str) != null){
			System.out.println(str + "出现的频率: " + has.get(str));  
		}else{
			System.out.println( str + " Not Find");  			
		}
		
	}

	public static void main(String[] args) {

		/* 读取上次保存的数据 */
		String str = FileUtil.read("F:\\log.txt");
		String[] str1 = str.split(" ");
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}

		FileUtil.clear();// 清空原文件
		search(FileUtil.read("F:\\11.txt"));// 将所有的数据进行统计
		sortMap();// 排序取前十个频率最高的单词

		Scanner in = new Scanner(System.in);
		
		Scanner scanner = new Scanner(System.in);

		boolean flag = true;

		String string = " ";

		System.out.println();
		System.out.println("请输入要执行的操作， clear-初始化 search-查找某一单词 exit-退出 restart-再次统计");
		while (flag && in.hasNext()) {			
			string = in.next();
			switch (string) {
			case "clear":
				FileUtil.clear();
				System.out.println("已完成初始化log");
				break;
			case "search":
				System.out.println("请输入要查找的单词");
				mySearch(scanner.nextLine());
				break;
			case "exit":
				System.out.println("程序退出");
				flag = false;
				break;
			case "restart":				
				search(FileUtil.read("F:\\11.txt"));// 将所有的数据进行统计
				sortMap();// 排序取前十个频率最高的单词
				break;
			default:
				System.out.println("输入参数有问题");
			}
		}
	}
}

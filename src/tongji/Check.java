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
			System.out.print("��ȡ�ļ�Ϊ��");
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
		System.out.println("���ʳ���Ƶ�����ͳ��");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");// �������ڸ�ʽ
		System.out.println("----------" + df.format(new Date()) + "----------");// new
																				// Date()Ϊ��ȡ��ǰϵͳʱ��
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
			System.out.println("����ʱ���뼯��Ϊ��,�������");
			return;
		}
	}
	
	//�����û����������
	public static void mySearch(String str){
		if(has.get(str) != null){
			System.out.println(str + "���ֵ�Ƶ��: " + has.get(str));  
		}else{
			System.out.println( str + " Not Find");  			
		}
		
	}

	public static void main(String[] args) {

		/* ��ȡ�ϴα�������� */
		String str = FileUtil.read("F:\\log.txt");
		String[] str1 = str.split(" ");
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}

		FileUtil.clear();// ���ԭ�ļ�
		search(FileUtil.read("F:\\11.txt"));// �����е����ݽ���ͳ��
		sortMap();// ����ȡǰʮ��Ƶ����ߵĵ���

		Scanner in = new Scanner(System.in);
		
		Scanner scanner = new Scanner(System.in);

		boolean flag = true;

		String string = " ";

		System.out.println();
		System.out.println("������Ҫִ�еĲ����� clear-��ʼ�� search-����ĳһ���� exit-�˳� restart-�ٴ�ͳ��");
		while (flag && in.hasNext()) {			
			string = in.next();
			switch (string) {
			case "clear":
				FileUtil.clear();
				System.out.println("����ɳ�ʼ��log");
				break;
			case "search":
				System.out.println("������Ҫ���ҵĵ���");
				mySearch(scanner.nextLine());
				break;
			case "exit":
				System.out.println("�����˳�");
				flag = false;
				break;
			case "restart":				
				search(FileUtil.read("F:\\11.txt"));// �����е����ݽ���ͳ��
				sortMap();// ����ȡǰʮ��Ƶ����ߵĵ���
				break;
			default:
				System.out.println("�������������");
			}
		}
	}
}

package tongji;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class FileUtil {
	
	public static String read(final String filePath){
		
		File file = new File(filePath);
		
		String temp = "";
				
		StringBuffer string = new StringBuffer();
		
		if(!file.exists() || !file.canRead()){
			System.out.println("�ļ�·��������߲��ɶ�ȡ");
			return null;
		}
		
		BufferedReader br = null;
		FileReader fb = null;
		try{
		fb = new FileReader(file);
		br = new BufferedReader(fb);
		while( (temp = br.readLine()) != null){
			string.append(temp);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fb != null){
				try {
					fb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return string.toString();
	}
	
	//���ļ���д������
	public static void write(String content){
		try {
			FileWriter wr = new FileWriter("F:/ans.txt", true);
			wr.write(content);
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException...");
			e.printStackTrace();
		}				
	}
	
	//����ļ�
	public static void clear(){
		try{FileWriter wr = new FileWriter("F:/ans.txt",false);
		wr.write("");
		}catch(IOException e){
			System.out.println("Clear Error");
			e.printStackTrace();
		}
	}
	/*
	 * 1.����ļ�
	 * 2.��ȡ֮ǰ���ļ�
	 * */
}

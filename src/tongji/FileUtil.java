package tongji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileUtil {
	
	public static String read(final String filePath){
		
		File file = new File(filePath);
		
		String temp = "";
				
		StringBuffer string = new StringBuffer();
		
		if(!file.exists() || !file.canRead()){
			System.out.println("文件路径有误或者不可读取");
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
		}
		return string.toString();
	}
		
}

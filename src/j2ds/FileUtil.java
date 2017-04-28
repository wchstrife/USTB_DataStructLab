package j2ds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class FileUtil {
	
	/*
	 * 读取文件并按行输出
	 * @param 	filePath 文件读入的路径
	 * @param 	spec 允许解析的最大行数，spec==null 的时候全部解析
	 * @return 	按行输出
	 * @author 	wchstrife
	 * @since 	2017-4-25
	 * */
	public static String read(final String filePath, final Integer spec){
		File file = new File(filePath);
		//当文件不存在或者不可读的时候
		if ( (!isFileExists(file)) || (!file.canRead()) ){
			System.out.println("file [" + filePath +  "] is not exist or cannot read");
			return null;
		}
		
		BufferedReader br = null;
		FileReader fb = null;
		StringBuffer sb = new StringBuffer();
		try{
			fb = new FileReader(file);
			br = new BufferedReader(fb);
			
			String str = null;
			int index = 0;
			while ( (spec == null || index++ <spec) &&  (str = br.readLine()) != null ){
				sb.append(str + "/n");
System.out.println(str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			closeQuietly(br);
			closeQuietly(fb);
		}
		return sb.toString();
	}

	/*
	 * 写文件
	 * @param 	filePath 	输出文件路径
	 * @param	content		要写入的内容
	 * @param	append		是否追加
	 * @return
	 * @author 	wchstrife
	 * @since 	2017-4-28
	 * */
	public static int write(final String filePath, final String content, final boolean append){
		File file = new File(filePath);
		//没有内容的时候
		if(content == null){
			System.out.println("file ["+ filePath +"] invalid");
			return 0;
		}
		//当文件存在但是不可写
		if( isFileExists(file) && (!file.canRead()) ){
			return 0;
		}
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
			if(!isFileExists(file)){
				file.createNewFile();
			}
			
			fw = new FileWriter(file, append);
			bw = new BufferedWriter(fw);
			
			bw.write(content);
		}catch(IOException e){
			e.printStackTrace();
			return 0;
		}finally{
			closeQuietly(bw);
			closeQuietly(fw);
		}
		return 1;
	}
	
	
	private static void closeQuietly(Closeable closeable) {
		try{
			if(closeable != null){
				closeable.close();
			}
		}catch(IOException e){
			System.out.println("关闭流文件失败");
		}
	}

	private static boolean isFileExists(final File file) {
		
		if(file.exists() && file.isFile()){
			return true;
		}
		
		return false;
	}
}

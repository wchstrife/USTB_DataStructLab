package tongji;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Check {
	
	static HashMap<String, Integer> has = new HashMap<String, Integer>();

		public static void search(String str){
			
			if(str == null || str == " "){
				System.out.print("读取文件为空");
				return ;
			}
			String[] target = str.split("[^a-zA-Z0-9_]+");
						
			
			for(int i=0; i< target.length; i++){
				if( !has.containsKey(target[i]) ){
					has.put(target[i], 1);
				}else{
					has.put( target[i], has.get(target[i])+1 );
				}
			}			
		}
		
		public static void sortMap(){
			
			List<Map.Entry<String, Integer>> List_Data = new ArrayList<Map.Entry<String, Integer>>(has.entrySet());
			Collections.sort(List_Data, new Comparator<Map.Entry<String, Integer>>(){				
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					if( o2.getValue()!=null && o1.getValue()!=null && o2.getValue().compareTo(o1.getValue())>0 ){
						return 1;
					}else{
						return -1;
					}
				}
			}); 
			System.out.println("排序后");
			try{
			for(int i=0; i<10; i++){
				String word = List_Data.get(i).getKey();
				String fre = List_Data.get(i).getValue().toString();
				System.out.println(word + ":" + fre);
				FileUtil.write(word + ":");
				FileUtil.write(fre + "\r\n");
			}
			}catch(IndexOutOfBoundsException e){
				System.out.println("排序时传入集合为空,程序结束");
				return;
			}
		}
		
		public static void main(String[] args){
			search( FileUtil.read("F:\\11.txt") );
			sortMap();
		}
}

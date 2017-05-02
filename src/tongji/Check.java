package tongji;

import java.util.HashMap;

public class Check {

		public static void search(String str){
			
			String[] target = str.split("[^a-zA-Z0-9_]+");
			
			HashMap<String, Integer> has = new HashMap<String, Integer>();
			
			for(int i=0; i< target.length; i++){
				if( !has.containsKey(target[i]) ){
					has.put(target[i], 1);
				}else{
					has.put( target[i], has.get(target[i])+1 );
				}
			}
		}
}

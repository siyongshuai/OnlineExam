package haue.edu.cn.util;

import java.util.HashSet;
import java.util.Random;
public class RandomGet {

	public Object[] getQuesIds(Integer count){
		
		Object[] questionIds = new Integer[count];
		Random random = new Random();
		HashSet<Integer> hashSet = new HashSet<Integer>();
		while(hashSet.size()< questionIds.length){
			hashSet.add(random.nextInt(100)+1);
			
		}
		questionIds =   hashSet.toArray();
		for (int i = 0; i < questionIds.length; i++) {
			System.out.print(questionIds[i]+"\t");
			if (i>0) {
				if (i % 10 ==0 ) {
					System.out.println();
				}
			}
			
		}
		return questionIds;
		
	}
	
	public static void main(String[] args) {
		RandomGet randomGet = new RandomGet();
		randomGet.getQuesIds(16);
	}
 	
	
}

package haue.edu.cn.test;

import java.util.HashSet;
import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		Object[] value = new Object[20];
		
		Random random = new Random();
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		 
		while(hashSet.size()< value.length){
			hashSet.add(random.nextInt(100)+1);
			
		}
		
	    value = hashSet.toArray();
//	    循环输出
	    for (int i = 0; i < value.length; i++) {
			System.out.print(value[i]+"\t");
			if((i+1)%10==0){
				System.out.println();
			}
		}
		
	    System.out.println("循环结束");
	}
	
	
}

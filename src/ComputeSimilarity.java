

import java.util.ArrayList;
import java.util.List;

/**
 * 计算相似度的算法的程序
 * @author LiCunzhi
 *
 */
public class ComputeSimilarity {
	
	//该方法返回值类型是double类型的数据  返回数据相似度计算出的最终的结果
	//把用户i  j 对电影的不同的评价装进list中   注意：list不限制数组的大小  动态增加
	/**
	 * 计算相似度的数值
	 * @param item1   集合对象1
	 * @param item2   集合对象2
	 * @return
	 */
	public double computeSimilarity(int[] item1,int[] item2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < item1.length; i++) {
			if(item1[i] != 0 && item2[i] !=0) {
				list1.add(new Integer(item1[i]));
				list2.add(new Integer(item2[i]));
			}
			j++;
		}
		//研究计算相似度的方法具体的实现   返回的是相似度的参数 
		return new PearsonCorrelation().pearsonCorrelation(list1,list2);
	}

}

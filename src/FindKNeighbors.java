

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKNeighbors implements Base{
	/**
	 * This method is used to find the nearest K neighbors to the un_scored item 
	 * 方法的目的就是找出最相近的是 K个邻居
	 * @param score ： 评分
	 * @param i ： 项目的序号  就是用户的id
	 * @param similarityMatrix ： 相似值 I - J 之间的相似度
	 * @return
	 */
	//该方法有三个参数，score表示某一用户对所有项目的评分；i表示某个项目的序号
	public  List<Integer> findKNeighbors(int[] score,int i,double[][] similarityMatrix) {	
		List<Integer> neighborSerial = new ArrayList<Integer>();
		double[] similarity = new double[similarityMatrix.length];//项目数
		for (int j = 0; j < similarityMatrix.length; j++) {
			//分数存在的情况之下  用户J和I的相似度是    计算出来的的皮尔逊相关系数值   否则在分数不存在的情况之下  设置相似的度值的是0
			if(score[j] != 0) {
				similarity[j] = similarityMatrix[j][i];
			} 
			else {
				similarity[j] = 0;
			}
		}
		//计算出相似度的值之后   存储在temp的集合之中
		double[] temp = new double[similarity.length];
		for (int j = 0; j < temp.length; j++) {
			temp[j] = similarity[j];
		}
		//按照相关系数的值进行排序
		Arrays.sort(temp);
		//抽选出最大的K个值然后加到neighborSerial
		for(int j = 0; j < similarity.length; j++) {
			for (int m = temp.length - 1; m >= temp.length - KNEIGHBOUR; m--) {
				if (similarity[j] == temp[m] && similarity[j] != 0.0)
					neighborSerial.add(new Integer(j));/*添加一个整型数据对象   存储的不是相似度的具体的值   而是相当于存储的是用户的名字*/
			}	
		}
		return neighborSerial; 
	}

}

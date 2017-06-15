

import java.util.ArrayList;
import java.util.List;

public class GetScore implements Base {
	/**
	 * 使用了参数基础测试集  和  相似系数  就是皮尔逊相关系数
	 * @param user_movie_base  ：  基础测试集
	 * @param combineMatrix   ： 皮尔逊相关系数
	 * @return
	 */
	public static double[][] getScore(int[][] user_movie_base,double[][] combineMatrix ){
	
	double[][] matrix = new double[PREFROWCOUNT][PREFROWCOUNT];
//	double[][] matrix = new double[PREFROWCOUNT][COLUMNCOUNT];
	// 进行评分预测
	List<Integer> neighborSerial = new ArrayList<Integer>();
	for (int i = 0; i < KNEIGHBOUR; i++) {//k近邻   这里定义的取临近的十个KNEIGHBOUR在base中定义
		neighborSerial.clear();
		double max = 0;
		int j = 0;
		int itemSerial = 0;
		int itemId = 0;
		for (; j < PREFROWCOUNT; j++) {
			if (user_movie_base[i][j] == 0) {
				double similaritySum = 0;
				double sum = 0;
				double score = 0;
				// 该方法有三个参数，score表示某一用户对所有项目的评分；i表示某个项目的序号combineMatrix表示项目间的相似性
				neighborSerial = new FindKNeighbors().findKNeighbors(user_movie_base[i], j, combineMatrix);
				//假设就是十个   那么十个人的名字就出来了 是和J最相似的十个
				
				for (int m = 0; m < neighborSerial.size(); m++) {
					sum += combineMatrix[j][neighborSerial.get(m)]* user_movie_base[i][neighborSerial.get(m)];//预测分数的算法：不同的相关系数*同一用户的不同电影的分数之和
					similaritySum += combineMatrix[j][neighborSerial.get(m)];//相似度值和
				}
				
				if (similaritySum == 0)
					score = 0;
				else
					score = sum / similaritySum;
				itemId = j;
				matrix[i][itemId] = score;
			}
			
		}
		

	}
	return matrix;
	}
}

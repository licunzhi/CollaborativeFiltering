

/**
 * 类的作用是计算用户的相似矩阵
 *
 */
public class ProduceSimilarityMatrix implements Base{
		/**
		 * 计算相似矩阵
		 * 计算如果要是比较的两个信息的是同一个数据的话  就让他命名为1 
		 * 如果要是不是的话 就去计算相似度---就是一个用户对应的所评价的电影的批评分的比较（可以参考图）
		 * @param preference ： 参数的是base存储的二维矩阵
		 * @return
		 */
		public double[][] produceSimilarityMatrix(int[][] preference) {//传入的参数是base训练集的数据
			//PREFROWCOUNT   训练集用户的数目
			double[][] similarityMatrix = new double[PREFROWCOUNT][PREFROWCOUNT];
			
				for (int i = 0; i < PREFROWCOUNT; i++) {
					for (int j = 0; j < PREFROWCOUNT; j++) {
						if (i == j) {
							similarityMatrix[i][j] = 1;
						}
						else {
							similarityMatrix[i][j] = 
									new ComputeSimilarity().computeSimilarity(preference[i], preference[j]);
						}			
					}
				}
				return similarityMatrix;
			}

}

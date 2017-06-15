import java.util.LinkedList;
import java.util.List;

public class Application extends PrintArray implements Base {

	public static void main(String[] args) {
		System.out.println("程序运行中   请稍后：");
		
		List<Double> x=new LinkedList<Double>();//LinkedList按照对象加入的顺序存储
		List<Double> y=new LinkedList<Double>();//x原始  y预测
		/*
		 * 读取的数据是base数据集的数据
		 * 和test的数据集的数据
		 * */
		int[][] user_movie_base = new int[PREFROWCOUNT][COLUMNCOUNT];
		user_movie_base = new ReadFile().readFile(BASE_LINE, BASE); // base中有943个用户对1682个项目的评分
																	// */
		int[][] test = new ReadFile().readFile(TEST_LINE, TEST); // 462个用户的实际评分
		
		/*计算的产品相似矩阵  本质计算出的数据是皮尔逊相关系数*/   
		double[][] similarityMatrix = new ProduceSimilarityMatrix()
										  .produceSimilarityMatrix(user_movie_base);//计算产品类似矩阵
		
		//mjc添加输出代码参数的部分--lcz 2017 4 12
		//PrintArray.myPrint(similarityMatrix);
		
		//评分预测
		double[][] matrix = GetScore
				.getScore(user_movie_base, similarityMatrix);//计算出预测的分数
		
		//mjc添加输出代码参数的部分--lcz 2017 4 12
		//PrintArray.myPrint(matrix);
		System.out.println(user_movie_base.length);
		///////////////////////////计算RMSE
	/*	for(int n = 0;n < PREFROWCOUNT;n++){
			for(int m = 0;m < COLUMNCOUNT;m++){
				x.add((double)user_movie_base[n][m]);
				y.add((double)matrix[n][m]);
			}
		}
		
		CalculateRMSE calRmse = new CalculateRMSE();
		
		System.out.println("计算出RMSE的结果是： " + calRmse.analyse(x, y));*/

		
		double[] mae = new ProduceMAE().produceMAE(matrix, test);
		double Mae = 0.0, MAE = 0.0;
		for (int k = 0; k < mae.length; k++) {
			Mae += mae[k];
		}
		MAE = Mae / TESTROWCOUNT;//平均误差之和/测试集项目数----平均绝对偏差   变异系数越小越稳定
		
		System.out.println("MAE=:" + MAE);
	}

}

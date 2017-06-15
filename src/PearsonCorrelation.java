

import java.util.List;

public class PearsonCorrelation implements Base {
	/**
	 * 计算相似度算法的具体实现过程和原理和
	 * @param a ： 集合1
	 * @param b ： 集合2
	 * @return  返回就是相似度参数的值
	 */
	public double pearsonCorrelation(List<Integer> a,List<Integer> b) {
		int num = a.size();//集合a作为参照集  用户i
		int sum_prefOne = 0;
		int sum_prefTwo = 0;
		int sum_squareOne = 0;
		int sum_squareTwo = 0;
		int sum_product = 0;
		for (int i = 0; i < num; i++) {
			sum_prefOne += a.get(i);//∑xi
			sum_prefTwo += b.get(i);//∑yi
			sum_squareOne += Math.pow(a.get(i), 2);//∑xi2
			sum_squareTwo += Math.pow(b.get(i), 2);//∑yi2
			sum_product += a.get(i) * b.get(i);//∑xiyi
		}
		double sum = num * sum_product - sum_prefOne * sum_prefTwo;//n∑xiyi-∑xi∑yi
		double den = Math.sqrt((num * sum_squareOne - Math.pow(sum_squareOne, 2)) * (num * sum_squareTwo - Math.pow(sum_squareTwo, 2)));
		//√((n∑xi-(∑xi2)2)*(n∑yi-(∑yi2)2))------这就是皮尔逊相关系数
		double result;
		if(den==0) result=0;
		else result = sum / den;
	   //n∑xiyi-∑xi∑yi/√((n∑xi-(∑xi2)2)*(n∑yi-(∑yi2)2))
		return result;
	}

}

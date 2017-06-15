import java.util.List;

public class CalculateRMSE {
	
	
	public double analyse(List<Double>x,List<Double>y){
		int lenx=x.size();
		int leny=y.size();
		int len=lenx;//小容错
		if(lenx<leny) len=lenx;
		else len=leny;
		//System.out.println(len);
		double[] tmpX=new double[len];
		double[] tmpY=new double[len];
		for(int i=0;i<len;i++){
			tmpX[i]=x.get(i);
			tmpY[i]=y.get(i);
		}
		return RMSE(tmpX,tmpY);
		//System.out.println(tmpY[1]);
	}
	
	//以u1.test的userID，itemID为输入，用以上运算再给出一组打分，与u1.test中进行比较
	//部分测试已在main函数中做好，这里实现均方差公式RMSE
	//它是观测值与真值偏差的平方和 与 观测次数n比值的平方根
	public double RMSE(double[] x, double[] y){
		double rmse=0;
		int lenx=x.length;
		int leny=y.length;
		int len=lenx;//小容错
		if(lenx<leny) len=lenx;
		else len=leny;
		
		double diffSum=0;
		double diffMutipl;
		for(int i=0;i<len;i++){
			diffMutipl=Math.pow((x[i]-y[i]), 2);
			diffSum+=diffMutipl;
		}
		rmse=Math.sqrt(diffSum/len);
		System.out.println("产生数据的条目数： " + len);
		//System.out.println(diff);
		return rmse;
	}

}


/**
 * 定义接口   该接口中定义的是相关的常量
 * @author LiCunzhi
 *
 */
public interface Base {
	
	public static final int KNEIGHBOUR = 10;	//number of neighbors最近邻个数
	public static final int COLUMNCOUNT = 1682;	//number of items 项目总数
	public static final int PREFROWCOUNT = 943;	//number of users in base训练集上的用户数目
	public static final int TESTROWCOUNT = 462;	//number of users in test测试集上的用户数目
	public static final String BASE = "u1.base"; //训练集
	public static final int BASE_LINE = 80000; //base 数据集的行数
	public static final String TEST = "u1.test"; //测试集
	public static final int TEST_LINE = 20000; //test 数据集的行数
	
}

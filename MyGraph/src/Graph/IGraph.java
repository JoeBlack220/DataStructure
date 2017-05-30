package Graph;

public interface IGraph<AnyType> {
	void createGraph(); //创建图
	int getVexNum(); //图中的顶点数
	int getArcNum(); //图中的边数
	Object getVex( int v ) throws Exception; //给定位置v，返回其对应的顶点值
	int locateVex(AnyType vex);	//给定顶点的值vex，返回其在图中的位置
	int firstAdjVex( int v ) throws Exception; //返回v的第一个邻接点
	int nextAdjVex( int v, int w ) throws Exception; //返回v相对于w的下一个邻接点
}

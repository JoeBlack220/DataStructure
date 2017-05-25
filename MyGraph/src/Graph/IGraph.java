package Graph;

public interface IGraph<AnyType> {
	void createGraph();
	int getVexNum();
	int getArcNum();
	Object getVex( int v ) throws Exception;
	int locateVex(AnyType vex);
	int firstAdjVex( int v ) throws Exception;
	int nextAdjVex( int v, int w ) throws Exception;
}

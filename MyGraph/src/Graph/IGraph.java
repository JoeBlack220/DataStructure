package Graph;

public interface IGraph<AnyType> {
	void createGraph(); //����ͼ
	int getVexNum(); //ͼ�еĶ�����
	int getArcNum(); //ͼ�еı���
	Object getVex( int v ) throws Exception; //����λ��v���������Ӧ�Ķ���ֵ
	int locateVex(AnyType vex);	//���������ֵvex����������ͼ�е�λ��
	int firstAdjVex( int v ) throws Exception; //����v�ĵ�һ���ڽӵ�
	int nextAdjVex( int v, int w ) throws Exception; //����v�����w����һ���ڽӵ�
}

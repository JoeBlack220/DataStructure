package Graph;
import java.util.*;
public class ALGraph<AnyType> implements IGraph<AnyType> {
	private GraphKind kind;
	private int vexNum, arcNum;
	private VNode[] vexs;
	public ALGraph(){
		this(null, 0, 0, null);
	}
	public GraphKind getKind(){
		return kind;
	}
	public VNode[] getVexs(){
		return vexs;
	}
    public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs) {
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
    }
    public void createGraph() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the kind of the graph：（UDG、DG、UDN、DN）");
        GraphKind kind = GraphKind.valueOf(sc.next());
        switch (kind) {
        case UDG:
            createUDG();
            break;
        case DG:
            createDG();
            break;
        case UDN:
            createUDN();
            break;
        case DN:
            createDN();
            break;
        default:
            break;
        }
    }
    private void createDN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = new VNode[vexNum];
        System.out.println("请分别输入图的各个顶点：");
        for(int i = 0; i < vexNum; i++){
            vexs[i] = new VNode(sc.next());
        } 
        System.out.println("请输入各个边的两个顶点及其权值");
        for(int k = 0; k < arcNum; k++){
            int v = locateVex((AnyType)sc.next()); 
            int u = locateVex((AnyType)sc.next()); 
            int value = sc.nextInt();
            addArc(v, u, value);
        }
    }
    private void createUDN() { 
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = new VNode[vexNum];
        System.out.println("请分别输入图的各个顶点：");
        for(int i = 0; i < vexNum; i++){
            vexs[i] = new VNode(sc.next());
        } 
        System.out.println("请输入各个边的两个顶点及其权值");
        for(int k = 0; k < arcNum; k++){
            int v = locateVex((AnyType)sc.next()); //弧尾 指出的点
            int u = locateVex((AnyType)sc.next()); //弧头 被指入的点
            int value = sc.nextInt();
            addArc(v, u, value);
            addArc(u, v, value);
        }
    }
    private void addArc(int v, int u, int value) {
        ArcNode arc = new ArcNode(u,value);
        arc.setNextArc(vexs[v].getFirstArc());
        vexs[v].setFirstArc(arc); 
    }
    private void createUDG() { 
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = new VNode[vexNum];
        System.out.println("请分别输入图的各个顶点：");
        for(int i = 0; i < vexNum; i++){
            vexs[i] = new VNode(sc.next());
        } 
        System.out.println("请输入各个边的两个顶点及其权值");
        for(int k = 0; k < arcNum; k++){
            int v = locateVex((AnyType)sc.next()); //弧尾 指出的点
            int u = locateVex((AnyType)sc.next()); //弧头 被指入的点
            int value = sc.nextInt();
            addArc(v, u, 1);
            addArc(u, v, 1);
        }
    }
    private void createDG() { 
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = new VNode[vexNum];
        System.out.println("请分别输入图的各个顶点：");
        for(int i = 0; i < vexNum; i++){
            vexs[i] = new VNode(sc.next());
        } 
        System.out.println("请输入各个边的两个顶点及其权值");
        for(int k = 0; k < arcNum; k++){
            int v = locateVex((AnyType)sc.next()); //弧尾 指出的点
            int u = locateVex((AnyType)sc.next()); //弧头 被指入的点
            int value = sc.nextInt();
            addArc(v, u, 1);
        }
    }
    public int getVexNum() {
        return vexNum;
    }

    public int getArcNum() { 
        return arcNum;
    }
    public AnyType getVex(int v) throws Exception {        
        if(v < 0 && v >= vexNum)
            throw new Exception("第" + v + "个顶点不存在");
        return (AnyType)vexs[v].getData();
    }
    public int locateVex(AnyType vex) {  
        for(int v = 0; v < vexNum; v++){
            if(vexs[v].getData().equals(vex))
                return v;
        }
        return -1;
    }
    public int firstAdjVex(int v) throws Exception { 
        if(v < 0 && v >= vexNum)
            throw new Exception("第" + v + "个顶点不存在");

        VNode vex = vexs[v]; 
        if(vex.getFirstArc() != null)
            return vex.getFirstArc().getAdjVex();
        else 
            return -1; 
    }
    public int nextAdjVex(int v, int w) throws Exception { 
        if(v < 0 && v >= vexNum)
            throw new Exception("第" + v + "个顶点不存在");

        VNode vex = vexs[v];
        ArcNode arcvw = null;
        for(ArcNode arc = vex.getFirstArc(); arc != null; arc = arc.getNextArc()){
            if(arc.getAdjVex() == w){
                arcvw = arc;
                break;
            }
        }
        if(arcvw != null && arcvw.getNextArc() != null)
            return arcvw.getNextArc().getAdjVex();
        else
            return -1;
    }   

    public void display() throws Exception{
        for(int i = 0; i < vexNum; i++){
            VNode vex = vexs[i];
            System.out.print(vex.getData());
            for(ArcNode arc = vex.getFirstArc(); arc != null; arc = arc.getNextArc()){
                System.out.print("->" + getVex(arc.getAdjVex()) +  arc.getValue());
            }
            System.out.println();
        }
    }

}

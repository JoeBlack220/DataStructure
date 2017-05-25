package Graph;
import java.util.Scanner;
public class MGraph<AnyType> implements IGraph{
	public final static int INFINITY = Integer.MAX_VALUE;
	private static final String AnyType[] = null;
	private GraphKind kind;
	private int vexNum, arcNum;
	private AnyType[] vexs;
	private int[][] arcs;
	
	public MGraph(){
		this( null, 0, 0, null, null );
	}
	public MGraph(GraphKind kind, int vexNum, int arcNum, AnyType[] vexs, int[][] arcs){
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}
	public void createGraph(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the kind of the graph: (UDG, DG, UDN, DN).");
		GraphKind kind = GraphKind.valueOf(sc.next());
		switch(kind){
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
	private void createDN(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数和图的边数：");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = (AnyType[]) new Object [vexNum]; 
		System.out.println("请分别输入图的各个顶点：");
		for(int i = 0; i < vexNum; i++){
			vexs[i] = (AnyType)sc.next();
		}
		arcs = new int [vexNum][vexNum];
		for(int i = 0; i < vexNum; i++){
			for(int j = 0; j< vexNum; j++){
				arcs[i][j] = INFINITY;
			}
		}
		System.out.println("请输入各个边的两个顶点及其权值：");
		for(int i = 0; i < arcNum; i++){
			int v = locateVex((AnyType)sc.next());
			int u = locateVex((AnyType)sc.next());
			arcs[v][u] = sc.nextInt();
		}
	}
	private void createUDN(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = (AnyType[])new Object[vexNum];
        System.out.println("请分别输出图的各个顶点：");
        for(int i = 0; i < vexNum; i++){
            vexs[i] = (AnyType)sc.next();
        }
        arcs = new int[vexNum][vexNum];
        for(int i = 0; i < vexNum; i++){
            for(int j = 0; j < vexNum; j++){
                arcs[i][j] = INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点及其权值");
        for(int k = 0; k < arcNum; k++){
            int v = locateVex((AnyType)sc.next());
            int u = locateVex((AnyType)sc.next());
            arcs[v][u] = arcs[u][v] = sc.nextInt();
        }
	}
	private void createDG(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = (AnyType[])new Object[vexNum];
        System.out.println("请分别输入图的各个顶点：");
        for(int i = 0; i < vexNum; i++){
            vexs[i] = (AnyType)sc.next();
        }
        arcs = new int[vexNum][vexNum];
        for(int i = 0; i < vexNum; i++){
            for(int j = 0; j < vexNum; j++){
                arcs[i][j] = INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点:");
        for(int k = 0; k < arcNum; k++){
            int v = locateVex((AnyType)sc.next());
            int u = locateVex((AnyType)sc.next());
            arcs[v][u] = 1;
        }
	}
	private void createUDG(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入图的顶点数、图的边数：");
        vexNum = sc.nextInt();
        arcNum = sc.nextInt();
        vexs = (AnyType[])new Object[vexNum];
        System.out.println("请分别输入图的各个顶点：");
        for(int i = 0; i < vexNum; i++){
            vexs[i] = (AnyType)sc.next();
        }
        arcs = new int[vexNum][vexNum];
        for(int i = 0; i < vexNum; i++){
            for(int j = 0; j < vexNum; j++){
                arcs[i][j] = INFINITY;
            }
        }
        System.out.println("请输入各个边的两个顶点:");
        for(int k = 0; k < arcNum; k++){
            int v = locateVex((AnyType)sc.next());
            int u = locateVex((AnyType)sc.next());
            arcs[v][u] = arcs[u][v] = 1;
        }
	}
	public int getVexNum(){
		return vexNum;
	}
	public int getArcNum(){
		return arcNum;
	}
	public AnyType getVex(int v) throws Exception{
		if(v < 0 && v >= vexNum){
			throw new Exception("第"+v+"个顶点不存在");
		}
		return vexs[v];
	}
	public int locateVex(Object vex){
		for(int v = 0; v< vexNum; v++){
			if(vexs[v].equals(vex)){
				return v;
			}
		}
		return -1;
	}
	public int firstAdjVex(int v) throws Exception{
		if(v < 0 && v >= vexNum){
			throw new Exception("第"+v+"个顶点不存在");
		}
		
		for(int j = 0; j < vexNum; j++){
			if(arcs[v][j] != 0 && arcs[v][j] < INFINITY){
				return j;
			}
		}
		return -1;
	}
	public int nextAdjVex(int v, int w) throws Exception{
		if(v < 0 && v >= vexNum){
			throw new Exception("第"+v+"个顶点不存在");
		}
		for(int j = w + 1; j < vexNum; j++){
			if(arcs[v][j] != 0 && arcs[v][j] < INFINITY){
				return j;
			}
		}
		return -1;
	}
	public void display(){
		for(int i = 0; i < vexNum; i++){
			for(int j = 0; j < vexNum; j++){
				if(arcs[i][j]==INFINITY){
					System.out.print(0+" ");
				}
				else{
					System.out.print(arcs[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
        
}

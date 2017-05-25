package Graph;

public class ArcNode {
	private int adjVex;
	private int value;
	private ArcNode nextArc;
	public ArcNode(){
		this(-1, 0, null);
	}
	public ArcNode(int adjVex){
		this(adjVex, 0, null);
	}
	public ArcNode(int adjVex, int value){
		this(adjVex, value, null);
	}
	public ArcNode(int adjVex, int value, ArcNode nextArc){
		this.adjVex = adjVex;
		this.value = value;
		this.nextArc = nextArc;
	}
    public int getAdjVex() {
        return adjVex;
    }

    public void setAdjVex(int adjVex) {
        this.adjVex = adjVex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArcNode getNextArc() {
        return nextArc;
    }

    public void setNextArc(ArcNode nextArc) {
        this.nextArc = nextArc;
    }
	
}

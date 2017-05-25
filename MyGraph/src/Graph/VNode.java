package Graph;

public class VNode<AnyType> {
	private AnyType data;
	private ArcNode firstArc;
	public VNode(){
		this(null, null);
	}
	public VNode(AnyType data){
		this(data, null);
	}
	public VNode(AnyType data, ArcNode firstArc){
		this.data = data;
		this.firstArc = firstArc;
		
	}
	public AnyType getData(){
		return data;
	}
	public void setData(AnyType data){
		this.data = data;
	}
	public ArcNode getFirstArc(){
		return firstArc;
	}
	public void setFirstArc(ArcNode firstArc){
		this.firstArc = firstArc;
	}
	
	
}

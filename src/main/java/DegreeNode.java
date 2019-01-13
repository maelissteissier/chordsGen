import java.util.ArrayList;

/**
 * Node in degree progression graph.
 */
public class DegreeNode {

	// Degree is between 1 and 7
	private int degree;
	//Edges correspond to next possible degrees that makes sense in tonal music
	ArrayList<DegreeNode> edges;
	
	public DegreeNode(int degree) {
		this.degree = degree;
		edges = new ArrayList<DegreeNode>();
	}

	public int getDegree() {
		return degree;
	}

	public ArrayList<DegreeNode> getEdges() {
		return edges;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public void setEdges(ArrayList<DegreeNode> edges) {
		this.edges = edges;
	}

	public void addEdges(DegreeNode degree){
		this.edges.add(degree);
	}



	public void connectDegree(DegreeNode degreeToConnect) {
		edges.add(degreeToConnect);
	}
	
	public DegreeNode getRandomConnectedDegree() {
		int idx = (int)(Math.random()*(edges.size()));
		return edges.get(idx);
	}

}

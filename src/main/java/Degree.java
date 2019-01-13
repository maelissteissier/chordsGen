import java.util.ArrayList;

public class Degree {

	public int degree;
	ArrayList<Degree> nextDegree;
	
	public Degree(int degree) {
		this.degree = degree;
		nextDegree = new ArrayList<Degree>();
	}
	
	public void connectDegree(Degree degreeToConnect) {
		nextDegree.add(degreeToConnect);
	}
	
	public Degree getRandomConnectedDegree() {
		int idx = (int)(Math.random()*(nextDegree.size()));
		return nextDegree.get(idx);
	}
	
}

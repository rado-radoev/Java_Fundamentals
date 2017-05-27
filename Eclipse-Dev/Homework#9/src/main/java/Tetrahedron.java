import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

public class Tetrahedron extends ThreeDimensionalShape {

	private double side;
	
	public Tetrahedron(double base, double height, double side) {
		super(base, height);
		this.side = side;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}

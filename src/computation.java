
public class computation {
	static double pi = Math.PI;
	
	public static double computeSurfaceArea(double r){
		double surfaceArea = (pi * Math.pow(r, 2));
		
		return surfaceArea;
	}
	
	public static double computeVolume(double r){
		double volume = ((double)4/3) * pi * Math.pow(r, 3);
		
		return volume;
	}
}

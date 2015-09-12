/* 
* Programmer's name: Tyler Stickler
* Email address:     Stickler@csu.fullerton.edu
* Course:            CPSC223J
* Assignment number: 1
* Due date:          Sept 14, 2015
* Title:             Spheres
* Purpose:           Find the surface area and volume of any sphere
* This file name:    SpheresComputation.java
*/

public class SpheresComputation {
	static double pi = Math.PI;
	
	public static double computeSurfaceArea(double r){
		// Surface area of a sphere is 4πr^2
		
		double surfaceArea = ( 4 * (pi * Math.pow(r, 2)));
		
		return surfaceArea;
	}
	
	public static double computeVolume(double r){
		// Volume of a sphere is (4/3)πr^3
		
		double volume = ((double)4/3) * pi * Math.pow(r, 3);
		
		return volume;
	}
}

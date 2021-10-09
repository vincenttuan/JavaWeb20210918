package service;

public class BmiService {
	public double getBmi(String height, String weight) {
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		double bmi = getBmi(h, w);
		return bmi;
	}
	
	public double getBmi(double h, double w) {
		double bmi = w / Math.pow(h/100, 2);
		return bmi;
	}
	
}

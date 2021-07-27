package Enums;
public enum Simbolo {

	X, O;

	
	public static Simbolo getEnum(String text) {
		Simbolo sim = O;
		
		if ("x".equalsIgnoreCase(text)) {
			sim = X;
		}

		return sim;

	}
}

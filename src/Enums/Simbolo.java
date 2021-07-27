package Enums;
public enum Simbolo {

	X, O;

		//Método apenas para não diferenciar maiusculo/minusculo
	public static Simbolo getEnum(String text) {
		Simbolo sim = O;
		
		if ("x".equalsIgnoreCase(text)) {
			sim = X;
		}

		return sim;

	}
}

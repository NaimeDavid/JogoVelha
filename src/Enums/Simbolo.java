package Enums;
public enum Simbolo {

	X, O;

		//M�todo apenas para n�o diferenciar maiusculo/minusculo
	public static Simbolo getEnum(String text) {
		Simbolo sim = O;
		
		if ("x".equalsIgnoreCase(text)) {
			sim = X;
		}

		return sim;

	}
}

package hk.blogspot.javatoybox.ValidateXml;

public class InputXsdAndXml {

	public static void main(String[] args) {
		try {
			//args[0] is XSD location and args[1] is XML location
			new PraseXml(args[0], args[1]);
			String str = "XML valid";
			System.out.format("%s", str);
		} catch (Exception e) {
			String str = "XML Not valid";
			System.out.format("%n%s%n%n%s", str, e.getMessage());
		}
	}

}

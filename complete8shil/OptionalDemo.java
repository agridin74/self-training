import java.util.*;
class OptionalDemo {
	public static void main(String args[]){
		Optional<String> noVal = Optional.empty();
		Optional<String> hasVal = Optional.of("ABCDEFG");
		if(noVal.isPresent()) System.out.println("not output");
		else System.out.println(" noVal value");

		if(hasVal.isPresent()) System.out.println("+++=> " + hasVal.get());

		String defStr = noVal.orElse("default");
		System.out.println(defStr);
	}
}

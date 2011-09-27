
public class StringLong {
		
	long StringToLong(String s)
	{
		long output=0;
		int length = s.length();
		
		for (int x=0; x< length; x++ ){
			if (((int)s.charAt(x) > 48) && ((int)s.charAt(x) < 57)){
				output += Math.pow(10, length -1 -x) * (((int)s.charAt(x) - 48)  );
			}else if((int)s.charAt(x) == 45){	
			}else{
				throw new RuntimeException();
			}
		}
		
		if ((int)s.charAt(0) == 45){
			output *= -1;
		}
		
		return output;
	}
	 
}

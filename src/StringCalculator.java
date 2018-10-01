import java.util.StringTokenizer;

public class StringCalculator {
	

	public int getnumber(String nb1) {
		
		int i1 = Integer.parseInt(nb1);
		return i1;
		
		}

	public StringTokenizer decoupe (String nb) {
		String delim = ",";
		StringTokenizer s = new StringTokenizer(nb, delim);
		return s;
	}
	public StringTokenizer decoupevirg (String nb) {
		String delim = "/n";
		StringTokenizer s = new StringTokenizer(nb, delim);
		return s;
		
	}
	public StringTokenizer decoupeeception1 (String nb) {
		boolean Value=true;
		String delim = ",/n";
		StringTokenizer s = new StringTokenizer(nb, delim,Value);
		return s;
		
	}
	public StringTokenizer decoupeeception2 (String nb) {
		boolean Value=true;
		String delim = "/n,";
		StringTokenizer s = new StringTokenizer(nb, delim, Value);
		return s;
		
	}
	public String identification(StringTokenizer s1) {
		String n1 = s1.nextToken();
		return n1;
	}
	public int add(String numbersStr) {
		StringTokenizer s = decoupe(numbersStr);
		int tokennb= s.countTokens();
		String n1="0";
		String n2="0";
		if (tokennb==0){
			n1="0";
			n2="0";
			}
		if (tokennb==1){
			n1=identification(s);
			n2="0";
			}
		if (tokennb==2){
			n1=identification(s);
			n2=identification(s);
		}
		int sum = getnumber(n1) + getnumber(n2);
		return sum;
	}
	public int add2(String numbersStr) {
		StringTokenizer s = decoupe(numbersStr);
		int tokennb= s.countTokens();
		int sum=0;
		if (tokennb==0) {
			sum = 0;
		}
		else {
		for (int i=1;i<=tokennb;i++) {
			int num = getnumber(identification(s));
			sum = sum +num;
		}
		
		}
		return sum;
	}
	public int add3(String numbersStr) {
		StringTokenizer s1 = decoupeeception1(numbersStr);
		StringTokenizer s2 = decoupeeception2(numbersStr);
		int tokennb1= s1.countTokens();
		int tokennb2= s2.countTokens();
		boolean OK=true;
		String n1="0";
		String n2="0";
		for (int i=1;i<=tokennb1;i++) {
		n1 = identification(s1);
		if (n1==",/n"){
			OK= false;
		}	
		}
		for (int i=1;i<=tokennb2;i++) {
			n2 = identification(s2);
		if (n2=="/n,") {
			OK=false;
		}
		}
		if (OK=true) {
		StringTokenizer s = decoupe(numbersStr);
		int tokennb= s.countTokens();
		int sum=0;
		if (tokennb==0) {
			sum = 0;
		}
		else {
		for (int i=1;i<=tokennb;i++) {
			StringTokenizer s3= decoupevirg(identification(s));
			int tokennb3= s3.countTokens();
			for (int j=1;j<=tokennb3;j++) {
			int num = getnumber(identification(s3));
			sum = sum +num;
			}
		}
		}
		return sum;
		}
		else {
			return 0;
		}
		
	}

}

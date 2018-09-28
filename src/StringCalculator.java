
public class StringCalculator {
	public int add(String numbersStr) throws StringCalculatorException {
	
		PrintRows(SplitString(",|/n",numbersStr));
		return CalculateSum(SplitString(",|/n",numbersStr));
	}
	
public String[] SplitString(String splitter, String row) {
	String[] rows = row.split(splitter);
	return rows;
	}

public int CalculateSum(String[] rows) throws StringCalculatorException  {
	int summa = 0;
	for(int i=0;i<rows.length;i++) {
		int luku = StringCheck(rows[i]);
		summa += luku;
		}
	System.out.println("\n Summa is : "+summa);
	return summa;
	}

public void PrintRows(String[] rows) {
	
	for(int i=0;i<rows.length;i++) {
		System.out.println("Row["+i+"] : "+rows[i]);
		}
	}

public int StringCheck(String row) throws StringCalculatorException{
	if(row.length()<=0) {
		throw new StringCalculatorException("There was , and / n ");
	}
	try {

		int luku = 0;
		luku = Integer.parseInt(row);
		if(luku<0) {
			throw new StringCalculatorException("number was negative");
		}
		else {
			return luku;
		}
	} catch(Exception e) {
		throw new StringCalculatorException("does not compute");
	}
	}
}

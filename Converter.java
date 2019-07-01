import java.io.*;
import java.util.Scanner;

public class Converter{
    public static void main(String[] args) {

	// US, Euro, Canadian Dollar, Costa R. Colon, Japan Yen, Peso
	double[][] currency = new double[6][6];
	int currentCurrency, exchangeCurrency;
	double exchangeAmount, newAmount;

	try
	{
	    File file = new File("currency_values.txt");
	    Scanner input = new Scanner(file);
	    while(input.hasNext()){
	    	for(int a = 0; a < 6; a++){
		    for(int b = 0; b < 6; b++){
			currency[a][b] = input.nextDouble();
		    }
		}
     	    }
	    input.close();
	}
	catch (Exception e)
	{
	    System.err.format("Exception occurred trying to read '%s'.", "currency_values.txt");
	    e.printStackTrace();
	}

	Scanner sc = new Scanner(System.in);

	System.out.println("What currency are you starting out with?");
	System.out.println("1) U.S.\n2) Euro\n3) Canadian Dollar\n4) Costa Rican Colon\n5) Japan Yen\n6) Peso");
	currentCurrency = sc.nextInt() - 1;

	System.out.println("What currency are you exchanging to?");
	System.out.println("1) U.S.\n2) Euro\n3) Canadian Dollar\n4) Costa Rican Colon\n5) Japan Yen\n6) Peso");
	exchangeCurrency = sc.nextInt() - 1;

	System.out.println("How much currency do you want to exchange?");
	exchangeAmount = sc.nextDouble();

	newAmount = exchangeAmount * currency[currentCurrency][exchangeCurrency];

	System.out.println("This is how much you will have: " + newAmount);

	sc.close();

    }
}

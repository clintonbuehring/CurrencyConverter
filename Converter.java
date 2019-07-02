import java.io.*;
import java.util.Scanner;

public class Converter{

    public static void main(String[] args) {

	// Currnecy: US, Euro, Canadian Dollar, Costa R. Colon, Japan Yen, Peso
	double[][] currency = new double[6][6];	// 2-D Array to hold currency values
	int currentCurrency, exchangeCurrency;	// Currency to be utilized
	double exchangeAmount, newAmount;	// Amount to be exchanged

	try
	{
	    // Get currency values from txt file
	    File file = new File("currency_values.txt");
	    Scanner input = new Scanner(file);
	    while(input.hasNext()){
	    	for(int a = 0; a < 6; a++){
		    for(int b = 0; b < 6; b++){
			currency[a][b] = input.nextDouble(); 	// Put values into 2D array
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

	// Get the currency the user currently has
	System.out.println("What currency are you starting out with?");
	System.out.println("1) U.S.\n2) Euro\n3) Canadian Dollar\n4) Costa Rican Colon\n5) Japan Yen\n6) Peso");
	currentCurrency = sc.nextInt() - 1;

	// Get the currency that the user wishes to convert to
	System.out.println("What currency are you exchanging to?");
	System.out.println("1) U.S.\n2) Euro\n3) Canadian Dollar\n4) Costa Rican Colon\n5) Japan Yen\n6) Peso");
	exchangeCurrency = sc.nextInt() - 1;

	// Get the amount that the user wants to exchange
	System.out.println("How much currency do you want to exchange?");
	exchangeAmount = sc.nextDouble();

	newAmount = exchangeAmount * currency[currentCurrency][exchangeCurrency];

	System.out.println("This is how much you will have: " + newAmount);

	sc.close();

    }
}

import java.io.*;
import java.util.*;

// V = 1/3 * Math.PI * Math.pow(r, 2) * h

public class Group1c {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		FileWriter fw = new FileWriter("Group1cOutput.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuilder builder = new StringBuilder();

		double pi;
		double[][] r = new double[5][4];
		double[][] h = new double[5][4];
		double[][] V = new double[5][4];

		System.out.print("Enter value for pi: ");
		pi = input.nextDouble();

		int count = 1;
		System.out.println("Enter values for r and h");
		for (int row=0; row < V.length; row++){
			for (int col = 0; col < V[row].length; col++){
				System.out.print("r" + count + " = ");
				r[row][col] = input.nextDouble();
				System.out.print("h" + count + " = ");
				h[row][col] = input.nextDouble();
				System.out.println();
				count++;
			}
		}

		// calculate and display the value of V
		count = 1;
		for (int row = 0; row < V.length; row++){
			for (int col = 0; col < V[row].length; col++){
				V[row][col] = (pi * Math.pow(r[row][col], 2) * h[row][col]) / 3;
				System.out.println("V_"+count+" = " + V[row][col]);
				count++;
			}
			System.out.println();
		}

		// write data to file
		count = 1;
		try {
			for (int row = 0; row < V.length; row++){
				for (int col = 0; col < V[row].length; col++){
					builder.append("V_"+count+" = " + V[row][col]);
					count++;
					if (col < V.length - 1){
						builder.append("\n");
					}
				}
				builder.append("\n");
			}
			bw.write(builder.toString());
			bw.close();
		}
		catch (IOException err){
			System.out.println("Cannot write to file: ");
			err.printStackTrace();
		}
		catch (Exception err){
			System.out.println("An error occured: ");
			err.printStackTrace();
		}
	}
}
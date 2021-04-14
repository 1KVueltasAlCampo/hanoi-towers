package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Hanoi{
	private static String initialString;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    int tries= Integer.parseInt(br.readLine());
	    int number = 0;
	    FileOutputStream os = new FileOutputStream("output/results.txt");
	    PrintStream ps = new PrintStream(os);
	    String answer = "";
	    
	    for(int i=0;i<tries;i++){
	    	number = Integer.parseInt(br.readLine());
	    	int[] towers= {number,0,0};
	    	initialString = towers[0]+" "+towers[1]+" "+towers[2]+"\n";
	    	resolveTowerOfHanoi(number,towers, 0, 2, 1);
	    	answer += initialString+"\n";
	    }
	    answer = answer.substring(0,answer.length()-1);
	    bw.write("The results are in the file results.txt");
	    ps.print(answer);
	    
	    
	    br.close();
	    bw.close();
	}
	
	public static void resolveTowerOfHanoi(int n,int[] towerOfHanoi,int startTower,int finalTower,int auxTower) {
		if(n==1) {
			towerOfHanoi[startTower]--;
			towerOfHanoi[finalTower]++;
			initialString += towerOfHanoi[0]+" "+towerOfHanoi[1]+" "+towerOfHanoi[2]+"\n";
			return;
		}
		resolveTowerOfHanoi(n-1,towerOfHanoi,startTower,auxTower,finalTower);
		towerOfHanoi[startTower]--;
		towerOfHanoi[finalTower]++;
		initialString += towerOfHanoi[0]+" "+towerOfHanoi[1]+" "+towerOfHanoi[2]+"\n";
		resolveTowerOfHanoi(n-1,towerOfHanoi,auxTower, finalTower,startTower);
	}
}
package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	private static String initialString;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	    int tries= Integer.parseInt(br.readLine());
	    int number = 0;
	    
	    String answer = "";
	    
	    for(int i=0;i<tries;i++){
	    	number = Integer.parseInt(br.readLine());
	    	int[] towers= {number,0,0};
	    	initialString = towers[0]+" "+towers[1]+" "+towers[2]+"\n";
	    	resolveTowerOfHanoi(number,towers, 0, 2, 1);
	    	answer += initialString+"\n";
	    }
	    bw.write(answer);
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
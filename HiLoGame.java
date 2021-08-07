import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HiLoGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		Scanner sc=new Scanner(System.in); 
		Map<Integer, String> map = new HashMap<>();
		
		System.out.println("!!!Welcome to Hi Lo!!!");
		System.out.println("\nEnter a number range: ");
		System.out.println("Min:");
		Integer minRange=sc.nextInt();
		System.out.println("Max:");
		Integer maxRange=sc.nextInt();
		System.out.println("\nThe number range is between "+minRange+" to "+maxRange);
		System.out.println("Choose a number between the range:");
		Integer number = sc.nextInt();
		int[] arr = new int[maxRange];
		
		int minRange1=minRange;
		for(int i=0; i<arr.length-1; i++) {
			arr[i]=minRange1;
			minRange1++;
		}
		
		System.out.println("\nDifferent Hi Lo guess methods:");
		System.out.println("1. Random Guess");
		System.out.println("2. Linear Search Guess");
		System.out.println("3. Binary Search Guess");
		System.out.println("4. All of the above");
		
		System.out.println("\nEnter the corresponding guess method number you want to choose:");
		Integer mthd=sc.nextInt();
		
		if(mthd==1) {//Random guess method
			RandomSearch(number, maxRange);
			
		}else if(mthd==2) {//Linear search method
			LinearSearch(number, arr);
			
		}else if(mthd==3) {//Binary search method
			BinarySearch(number, 0, maxRange-1, arr, 0);
			
		}else {//All the above
			Integer randomCount=RandomSearch(number, maxRange);//guess count from Random guess
			Integer linearCount=LinearSearch(number, arr);//guess count from Linear guess
			Integer binaryCount=BinarySearch(number, 0, maxRange-1, arr, 0);//guess count from Binary guess
			
			map.put(randomCount, "Random Guess");//storing the values in map<Integer, String> 
			map.put(linearCount, "Linear Search Guess");//to get the guess method based on the least guess count
			map.put(binaryCount, "Binary Search Guess");			
			
			Integer allCount=randomCount+linearCount+binaryCount;//sum of all guess counts
			System.out.println("\nTotal number of guesses by All of them together: "+allCount);
			
			int less= randomCount<linearCount?randomCount:linearCount;//to find the least guess count
			int least = binaryCount<less?binaryCount:less;
			System.out.println("The least number of guess was made by "+map.get(least)+ " by "+least+" guesses.");
		}
		
		System.out.println("\nThe End.");
	}
	
	public static Integer RandomSearch(Integer number, Integer maxRange) {
		System.out.println("\n*********Random Search Guess*********");
		Random random = new Random();
		List<Integer>list = new ArrayList<>();
	    int n = -1;// in order to pass in to the loop first time
	    int count=0;//guess counter
	       
	      while (n!=number) {// until the random generated number matches the guessed number
	    	n = random.nextInt(maxRange);
	    	
	    	if(list.isEmpty() || !list.contains(n)) {//to avoid repeating random numbers
	    		list.add(n);
	    		count++;
	    	}else {
	    		if(list.contains(n))
	    		continue;
	    	}
	    	
	    	
	         if (n<number) {
	            System.out.println(n+" is low, making next guess...");
	         } else if (n>number) {
	            System.out.println(n+" is high, making next guess...");
	         } else {
	            System.out.println(n+" - It is a match!!!");
	         }
	      }
	    System.out.println("\nTotal number of guesses by Random Search: "+count);
		return count;
	}
	
	public static Integer LinearSearch(Integer number, int[] arr) {
		System.out.println("\n*********Linear Search Guess*********");
			boolean flg=false;
			int count=0;
			for(int i=0; i<arr.length; i++) {
				count++;
				if(arr[i]<number) {
					System.out.println(arr[i]+" is low, making next guess...");
				}else if(arr[i]>number){
					System.out.println(arr[i]+" is high, making next guess...");
				}else {
					System.out.println(arr[i]+" - It is a match!!!");
					flg=true;
				}
				
				if(flg) {
					break;
				}
			}
			System.out.println("\nTotal number of guesses by Linear Search: "+count);
			return count;
		}
	
	public static Integer BinarySearch(Integer number, Integer first, Integer last, int[] arr, Integer count) {	
		
		if(count==0)
		System.out.println("\n*********Binary Search Guess*********");
		if (last>=first){			
			count++;
			
            int mid = first + (last - first)/2;  
            	if (arr[mid] < number){  
            		System.out.println(arr[mid]+" is low, making next guess...");
            		return BinarySearch(number, mid+1, last, arr, count);//recursion - search in second half of array
            	}  
            	else if (arr[mid] > number){ 
            		System.out.println(arr[mid]+" is high, making next guess...");
            		return BinarySearch(number, first, mid-1, arr, count);//recursion search in first half of array
            	}else{  
            		System.out.println(arr[mid]+" - It is a match!!!"); 
            		System.out.println("\nTotal number of guesses by Binary Search: "+count);
            		return count;
            	}  
        }  	
		
		return count;
		}

}

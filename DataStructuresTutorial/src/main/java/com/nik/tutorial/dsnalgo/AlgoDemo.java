package com.nik.tutorial.dsnalgo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author nikhil.bhide
 *
 */
public class AlgoDemo {
	public static int getSignOfInt(int num) {
		return (num>0)? 1:-1; 
	}
	public int reverseInt(int numToReverese) {
		String reversed = new String("");
		for(String s:(String.valueOf(numToReverese*getSignOfInt(numToReverese)).split(""))) {
			reversed = s + reversed;	
		}

		System.out.println(reversed);
		return Integer.parseInt(reversed)*getSignOfInt(numToReverese);
	}

	public Boolean isPalindrome(String str) {
		for(int counter=0;counter<str.length()/2;counter++) {
			if(str.charAt(counter)!=str.charAt(str.length()-counter-1)) {
				return false;
			}				
		}
		return true;
	}

	public int calFactorial(int num) {
		if(num==1 || num<=0) {
			return 1;
		}
		else return num*calFactorial(num-1);
	}

	public HashMap<String,Integer> getCharacterCountMap(String str) {
		HashMap<String,Integer> characterCountMapInstance = new HashMap();

		for(String element:str.split("")) {
			if(characterCountMapInstance.get(element)==null) {
				characterCountMapInstance.put(element, 1);
			}
			else {
				characterCountMapInstance.put(element,characterCountMapInstance.get(element)+1);
			}
		}

		return characterCountMapInstance;
	}

	/*ublic isAnagram(String s1,String s2) {

}*/

	public static void main(String[] args) {
		AlgoDemo instance = new AlgoDemo();
		instance.reverseInt(100);
		instance.isPalindrome("ABBA");
	}

	public static boolean isLengthOfStringsSame(String str1, String str2) {
		return str1.length()==str2.length();
	}

	public boolean isAnagram(String str1, String str2) {
		if(!isLengthOfStringsSame(str1, str2)) 
			return false;

		HashMap<String,Integer> characterCountMapStr1 = getCharacterCountMap(str1.toLowerCase());
		HashMap<String,Integer> characterCountMapStr2 = getCharacterCountMap(str2.toLowerCase());
		for(Entry<String, Integer> s:characterCountMapStr1.entrySet()) {
			if(s.getValue()!=characterCountMapStr2.get(s.getKey())) {
				return false;
			}
		}
		return true;
	}

	public int getNthSmallestInteger(List<Integer> list, int left, int right, int k) {
		int split = partition(left,right,list);
		int length = split-left+1;
		if(length==k) {
			return list.get(split);
		}
		else if (k<length) {
			return getNthSmallestInteger(list,left,split-1,k);
		}
		else {
			return getNthSmallestInteger(list,split+1,right,k-length);
		}
	}

	public List<Integer> quickSort(List<Integer> list, int left, int right) {
		if(left<right) {
			int pivote = partition(left,right,list);
			quickSort(list,left,pivote-1);
			quickSort(list,pivote+1,right);
		}
		return list;
	}


	public int[][] createChunkedArrayAlgo1(int[] array, int chunkSize) {
		int totalBuckets = (int) Math.round(Math.ceil(Double.parseDouble(String.valueOf(array.length))/Double.parseDouble(String.valueOf(chunkSize))));
		int[][] chunckedArray = new int[totalBuckets][chunkSize];

		int bucket = 0;
		int counter=0;
		for(int num:array) {
			chunckedArray[bucket][counter]=num;
			counter++;
			if(counter==chunkSize) {
				bucket++;
				counter=0;
			}
		}

		return chunckedArray;
	}

	public int[][] createChunkedArrayAlgo2(int[] array, int chunkSize) {
		int totalBuckets = (int) Math.round(Math.ceil(Double.parseDouble(String.valueOf(array.length))/Double.parseDouble(String.valueOf(chunkSize))));
		int[][] chunckedArray = new int[totalBuckets][chunkSize];
		int bucket = 0;
		int startIndex=0;
		int endIndex = 0;
		while(bucket<=totalBuckets) {
			startIndex = endIndex;
			endIndex = startIndex + chunkSize;

			if(endIndex<array.length) {
				int[] slicedArray = Arrays.copyOfRange(array, startIndex, endIndex);
				chunckedArray[bucket]=slicedArray;
				bucket++;
			}
			else {
				if(bucket<totalBuckets) {
					int[] slicedArray = Arrays.copyOfRange(array, startIndex, array.length);
					chunckedArray[bucket]=slicedArray;
					break;
				}
			}
		}

		return chunckedArray;
	}

	private int partition(int left,int right,List<Integer> list) {
		int leftMark = left+1;
		int rightMark=right;
		int pivote = list.get(left);
		
		while(true && left < right) {
			while(leftMark<right && list.get(leftMark)<pivote) {
				leftMark++;
			}

			while(rightMark>left && list.get(rightMark)>pivote) {
				rightMark--;
			}

			if(leftMark>=rightMark) {
				break;
			} 
			else {
				swap(list,leftMark,rightMark);
			}
		}
		swap(list,left,rightMark);
		return rightMark;
	}

	private void swap(List<Integer> list, int index1, int index2) {
		int temp = list.get(index1);
		list.set(index1,list.get(index2));
		list.set(index2, temp);
	}

	public String[] getHashesBySteps(int i) {
		String[] stringIfHashes = new String[i];
		String value = new String(new char[i]).replace('\0', ' ');
		IntStream.range(1, i+1).forEach(
				n -> {

					String newValue = new String(new char[n]).replace('\0', '#');
					stringIfHashes[n-1]=newValue.concat(value.substring(n, value.length()));
				});
		return stringIfHashes;
	}

	public void printHashesRecursion(int n, int steps) {
		if(n<=steps) {
			IntStream.range(1, n+1).forEach(x-> {
				System.out.print("#");
			});
			IntStream.range(n, steps+1).forEach(x-> {
				System.out.print(" ");
			});
			if(n+1>steps) {
				return;
			}
			else {
				System.out.print("\n");
			}
			printHashesRecursion(n+1,steps);
		}		
	}
	public String[] getPyramidMatrix(int steps) {
		String[] pyramidMatrix = new String[steps];
		return createPyramidMatrix(1,steps,pyramidMatrix);
	}

	private String[] createPyramidMatrix(int i, int steps, String[] pyramidMatrix) {
		if(i<=steps) {
			int mid = steps;
			String defaultValue = new String(new char[steps*2-1]).replace('\0', ' ');
			char[] charArray = defaultValue.toCharArray();
			charArray[mid-1]='#';
			IntStream.range(1, i).forEach(n-> {
				charArray[mid-n-1]='#';
				charArray[mid+n-1]='#';
			});
			pyramidMatrix[i-1]=String.valueOf(charArray);
			createPyramidMatrix(i+1,steps,pyramidMatrix);
		}
		return pyramidMatrix;
	}

	public int[][] getSpiralArray(int steps) {
		int [][] results = new int[steps][steps];
		int startRow=0, startColumn=0;
		int endRow=steps-1,endColumn=steps-1;
		int counter = 1;
		while(counter<=steps*steps) {
			for(int i=startColumn; i<=endColumn;i++) {
				results[startRow][i]=counter;
				counter++;
			}

			for(int i=startRow+1; i<=endRow;i++) {
				results[i][endColumn]=counter;
				counter++;
			}

			for (int i=endColumn-1;i>=startColumn;i--) {
				results[endRow][i]=counter;
				counter++;
			}

			for (int i=endRow-1;i>startRow;i--) {
				results[i][startColumn]=counter;
				counter++;
			}
			startColumn++;
			endColumn--;
			startRow++;
			endRow--;
		}

		return results;
	}
}
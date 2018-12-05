package com.nik.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.nik.tutorial.dsnalgo.AlgoDemo;

class AlgoDemoTest {

	@Test
	void testPositiveNumReversal() {
		AlgoDemo instance = new AlgoDemo();
		assertEquals(1, instance.reverseInt(100));
	}

	@Test
	void testNegativeNumReversal() {
		AlgoDemo instance = new AlgoDemo();
		assertEquals(-1, instance.reverseInt(-100));
	}

	@Test
	void testZeroNumReversal() {
		AlgoDemo instance = new AlgoDemo();
		assertEquals(0, instance.reverseInt(0));
	}

	@Test
	void testPalindromeSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertTrue(instance.isPalindrome("ABBA"));
	}

	@Test
	void testPalindromeFailure() {
		AlgoDemo instance = new AlgoDemo();
		assertFalse(instance.isPalindrome("HJKLJH"));
	}

	@Test
	void testPalindromeWithSpecialCharsSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertTrue(instance.isPalindrome("$$%HJKKJH%$$"));
	}

	@Test
	void testCharacterMapCountMatches() {
		AlgoDemo instance = new AlgoDemo();
		HashMap<String,Integer> charCountMap = instance.getCharacterCountMap("Hello");
		assertEquals(charCountMap.get("H").intValue(),1);
		assertEquals(charCountMap.get("e").intValue(),1);
		assertEquals(charCountMap.get("l").intValue(),2);
		assertEquals(charCountMap.get("o").intValue(),1);
		assertEquals(charCountMap.keySet().size(),4);
	}

	@Test
	void testAnagramSameCaseSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertTrue(instance.isAnagram("Hello","loelH"));
	}

	@Test
	void testAnagramDifferentCaseSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertTrue(instance.isAnagram("Hello","loelh"));
	}

	@Test
	void testAnagramEdgeCaseAdditionalCharacterFailure() {
		AlgoDemo instance = new AlgoDemo();
		assertFalse(instance.isAnagram("Hello","lsoelh"));
	}

	@Test
	void testAnagramEdgeCaseCharMisMatchFailure() {
		AlgoDemo instance = new AlgoDemo();
		assertFalse(instance.isAnagram("Hello","hoelh"));
	}

	@Test
	void testAnagramIdenticalStringsSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertTrue(instance.isAnagram("Hello","Hello"));
	}

	@Test
	void testCalFactorialSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertEquals(instance.calFactorial(3),6);
	}

	@Test
	void testCalFactorialHigherNumberSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertEquals(instance.calFactorial(10),3628800);
	}

	@Test
	void testCalFactorialZeroSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertEquals(instance.calFactorial(0),1);
	}

	@Test
	void testCalFactorialOneSuccess() {
		AlgoDemo instance = new AlgoDemo();
		assertEquals(instance.calFactorial(1),1);
	}

//	@Test 
//	void testGetNthSmallestPivoteCase() {
//		AlgoDemo instance = new AlgoDemo();
//		List<Integer> list = Arrays.asList(10,4,2,50,60);
//		assertEquals(instance.getNthSmallestInteger(list, 0, list.size()-1,3),10);
//	}
	
	@Test 
	void testGetNthSmallestPivoteLeftCase() {
		AlgoDemo instance = new AlgoDemo();
		List<Integer> list = Arrays.asList(10,4,2,50,60);
		assertEquals(instance.getNthSmallestInteger(list, 0, list.size()-1,2),4);
	}
	
	@Test 
	void testGetNthSmallestPivoteRightCase() {
		AlgoDemo instance = new AlgoDemo();
		List<Integer> list = Arrays.asList(10,4,2,60,50);
		assertEquals(instance.getNthSmallestInteger(list, 0, list.size()-1,4),50);
	}
	
	@Test 
	void testChunkedArrayAlgo1EqualSizedChunksSuccess() {
		AlgoDemo instance = new AlgoDemo();
		int[] array = {10,40,40,30,100,20};
		int[][] expected = {{10,40},{40,30},{100,20}};
		assertTrue(Arrays.deepEquals(instance.createChunkedArrayAlgo1(array,2),expected));
	}
	
	@Test 
	void testChunkedArrayAlgo1UnEqualSizedChunksSuccess() {
		AlgoDemo instance = new AlgoDemo();
		int[] array = {10,40,40,30,100,20,90,-200,30,1000};
		int[][] expected = {{10,40,40},{30,100,20},{90,-200,30},{1000,0,0}};
		assertTrue(Arrays.deepEquals(instance.createChunkedArrayAlgo1(array,3),expected));
	}
	
	@Test 
	void testChunkedArrayAlgoSlicedEqualSizedChunksSuccess() {
		AlgoDemo instance = new AlgoDemo();
		int[] array = {10,40,40,30,100,20};
		int[][] expected = {{10,40},{40,30},{100,20}};
		assertTrue(Arrays.deepEquals(instance.createChunkedArrayAlgo2(array,2),expected));
	}
	
	@Test 
	void testChunkedArrayAlgoSlicedUnEqualSizedChunksSuccess() {
		AlgoDemo instance = new AlgoDemo();
		int[] array = {10,40,40,30,100,20,90,-200,30,1000};
		int[][] expected = {{10,40,40},{30,100,20},{90,-200,30},{1000}};
		assertTrue(Arrays.deepEquals(instance.createChunkedArrayAlgo2(array,3),expected));
	}
	
	@Test
	void testPrintHashesSuccess() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {"#  ","## ","###"};
		String[] output = instance.getHashesBySteps(3);
		assertTrue(Arrays.equals(output,expected));
	}
	
	@Test
	void testPrintHashesEdgeCaseSuccess() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {"#"};
		String[] output = instance.getHashesBySteps(1);
		assertTrue(Arrays.equals(output,expected));
	}
	
	@Test
	void testPrintHashesExtremeLeftEdgeCaseSuccess() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {};
		String[] output = instance.getHashesBySteps(0);
		assertTrue(Arrays.equals(output,expected));
	}
	
	@Test
	void testPrintHashesRecursive() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {};
		instance.printHashesRecursion(1,4);
	}
	
	@Test 
	void testPyramidPrintAlgoRecursive() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {" # ","###"};
		String [] actual = instance.getPyramidMatrix(2);
		assertArrayEquals(expected, actual);
	}
	

	@Test 
	void testPyramidPrintAlgoLeftEdgeCaseRecursive() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {"#"};
		String [] actual = instance.getPyramidMatrix(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test 
	void testPyramidPrintAlgoExtremeLeftEdgeCaseRecursive() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {};
		String [] actual = instance.getPyramidMatrix(0);
		assertArrayEquals(expected, actual);
	}
	
	@Test 
	void testPyramidPrintAlgoRightEdgeCaseRecursive() {
		AlgoDemo instance = new AlgoDemo();
		String[] expected = {"   #   ","  ###  "," ##### ", "#######"};
		String [] actual = instance.getPyramidMatrix(4);
		assertArrayEquals(expected, actual);
	}	
	
	@Test 
	void testArraySpiralSimple() {
		AlgoDemo instance = new AlgoDemo();
		int[][] expected = {{1,2},{4,3}};
		
		int[][] actual = instance.getSpiralArray(2);
		assertArrayEquals(expected, actual);
	}	
	
	@Test 
	void testArraySpiralStep4() {
		AlgoDemo instance = new AlgoDemo();
		int[][] expected = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		
		int[][] actual = instance.getSpiralArray(4);
		assertArrayEquals(expected, actual);
	}	
	
	@Test 
	void testQuickSortSimpleSuccess() {
		AlgoDemo instance = new AlgoDemo();
		List<Integer> list = Arrays.asList(10,1,2);
		assertEquals(instance.quickSort(list,0,list.size()-1), Arrays.asList(1,2,10));
	}

	@Test 
	void testQuickSortComplexSuccess() {
		AlgoDemo instance = new AlgoDemo();
		List<Integer> list = Arrays.asList(10,-300,-200, 300, 1000, 1,2);
		List<Integer> result = instance.quickSort(list,0,list.size()-1);
		assertEquals(result, Arrays.asList(-300,-200, 1,2,10,300,1000));
	}

	@Test 
	void testQuickSortComplex2Success() {
		AlgoDemo instance = new AlgoDemo();
		List<Integer> list = Arrays.asList(10,-300,7000,-89900,-200, 300, 1000, 1,2);
		List<Integer> result = instance.quickSort(list,0,list.size()-1);
		assertEquals(result, Arrays.asList(-89900,-300,-200, 1,2,10,300,1000,7000));
	}	
}
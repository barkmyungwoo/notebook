package ncs.test1;

import java.util.*;

public class ArrayTest {

	public static void main(String[] args) {
		ArrayTest at = new ArrayTest();
		int[] array = new int[10];
		Random rn = new java.util.Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(100);
		}

		at.print(array);
		
		System.out.println("가장 큰 값 : "+ at.max(array));
		System.out.println("가장 작은 값 : "+ at.min(array));
		System.out.println("짝수의 개수 : "+ at.evenCount(array));
		System.out.println("홀수의 개수 : "+ at.oddCount(array));
		System.out.println("합 계 : "+at.sum(array));
		System.out.printf("평 균 : %.2f", at.avg(array));
	}

	public int sum(int[] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		return sum;
	}

	public double avg(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		return (double) (sum / arr.length);
	}

	public int max(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++)
			max = (max < arr[i]) ? arr[i] : max;

		return max;
	}

	public int min(int[] arr) {
		int min = 100;
		for (int i = 0; i < arr.length; i++)
			min = (min > arr[i]) ? arr[i] : min;

		return min;
	}

	public int evenCount(int[] arr) {
		int cnt =0;
		for (int i = 0; i < arr.length; i++)
			if(arr[i]%2==0)
				++cnt;
		return cnt;
	}

	public int oddCount(int[] arr) {
		int cnt =0;
		for (int i = 0; i < arr.length; i++)
			if(arr[i]%2==1)
				++cnt;
		return cnt;
	}

	public void print(int[] arr) {
		System.out.print("array : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

package com.threads.example;

import java.util.ArrayList;
import java.util.List;

public class SumOfListMain {
	
	public static final int thread_pool = 10;

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		int sum =0;
		for(int i=0; i<20; i++){
			numbers.add(i);
			sum += i;
		}
		System.out.println(sum);
		System.out.println(numbers);
		SumOfList task = new SumOfList(numbers);
		
		List<Thread> tlist = new ArrayList<Thread>();
		for(int i=0; i<thread_pool; i++){
			Thread t = new Thread(task);
			tlist.add(t);
		}
		
		for(Thread t : tlist){
			t.start();
		}

		for(Thread t : tlist){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(task.getSum());
	}

}

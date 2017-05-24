package com.threads.example;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SumOfList implements Runnable {

	//public List<Integer> list;
	public Queue<Integer> queue;
	public long sum;
	
	public SumOfList() {
	}
	public SumOfList(List<Integer> list) {
		Queue<Integer> q = new ConcurrentLinkedQueue<Integer>(list);
		this.queue = q;
		System.out.println(q);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is starting...");
		//synchronized (queue) {
			while(queue.peek() != null){
				synchronized (queue) {
					if(queue.peek() != null){
						System.out.println(Thread.currentThread().getName() + " is accessing queue.." +queue);
						sum += queue.poll();
					}
				}
				//Thread.yield();
			}
		//}
		System.out.println(Thread.currentThread().getName() + " is ending...");
	}
	
	public long getSum(){
		return sum;
	}
}

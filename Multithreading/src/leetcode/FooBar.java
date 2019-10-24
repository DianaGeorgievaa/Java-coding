package leetcode;

import java.util.concurrent.Semaphore;

class FooBar {
	
	private int n;
	Semaphore foo;
	Semaphore bar;

	public FooBar(int n) {
		this.n = n;
		foo = new Semaphore(1);
		bar = new Semaphore(0);
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			foo.acquire();
			printFoo.run();
			bar.release();
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			bar.acquire();
			printBar.run();
			foo.release();
		}
	}
}
package com.xstyx.distromatic.utils;

public interface IRunnable {
	abstract void run();
	abstract void onComplete(Object result);
	abstract void onFinish();
}

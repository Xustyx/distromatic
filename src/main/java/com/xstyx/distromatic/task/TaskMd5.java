package com.xstyx.distromatic.task;

import org.springframework.util.DigestUtils;

import com.xstyx.distromatic.utils.IRunnable;
import com.xstyx.distromatic.utils.Status;
import com.xstyx.distromatic.utils.WordGenerator;

public class TaskMd5 extends Task {
	
	private String hash;
	private WordGenerator wordGenerator;
	
	public static final long MAX_WORD_SIZE = 8;
	public static final String DEFAULT_CHARSET = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static final String HASH_KEY = "hash";
	public static final String CHARSET_KEY = "charset";
	
	public TaskMd5(){
		this.wordGenerator = new WordGenerator(DEFAULT_CHARSET);
	}
	
	public void run(IRunnable observer){
		long i = this.getPart();
		String word = "";
		
		this.setStatus(Status.Running);
		
		while(Status.Stopped.equals(this.getStatus()) || word.length() <= MAX_WORD_SIZE){
			word = wordGenerator.generate(i);
			
			if(checkMd5(word)){
				observer.onComplete(word);
			}
			
			i += this.getTotal();
		}
		
		observer.onFinish();
	}
	
	
	private boolean checkMd5(String word){
		return this.hash.equals(DigestUtils.md5DigestAsHex(word.getBytes()));
	}

	public void setCharset(String charset) {
		this.wordGenerator = new WordGenerator(charset);
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
}

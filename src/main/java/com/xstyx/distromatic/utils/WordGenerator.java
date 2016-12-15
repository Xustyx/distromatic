package com.xstyx.distromatic.utils;

public class WordGenerator {
	
	private String charset;
	
	private long pos;
    private long maxSize = 8;
    
    private String word = "";
	
	public WordGenerator(String charset){
		this.charset = charset;
	}
	
	private String generateWord(long relativePos){
		long base = this.getBase();
		long q = relativePos;
		String word = "";
		
		char c;
		
		while(q != 0){
			c = this.getCharset().charAt((int)(q % base));
			word =  c + word;
			q /= base;
		}
		
		if (word.length() == 0){
			word += this.getCharset().charAt(0);
		}
		
		return word;
	}
	
	public String generate(long pos){
		this.pos = pos;
		
		long length = this.getWordLength();
		long lastLimit = this.getLimit(length - 1) + 1;
		String word = this.generateWord(this.pos - lastLimit); 
		word = fillWithZero(length, word);
		
		this.word = word;
		
		return word;
	}
	
	private String fillWithZero(long n, String base){
		String word = base;
		long nZeros = n - base.length();
		
		for(int i = 0; i < nZeros; i++){
			word = "0" + word;
		}
		
		return word;
	}
	
	public long getWordLength(){
		long length = 0;
		
		do{
			length++;
		} while(this.getPos() > this.getLimit(length));

		return length;
	}
  
  	public long getLimit(long length){
      	long total = 0;
      
      	total += Math.pow(charset.length(), length) - 1;
      
      	for(int i = 1; i < length; i++){
          total += Math.pow(charset.length(), i);
      	}
      
      	return total;
  	}                                    
	
	public String getCharset() {
		return charset;
	}
	
	public long getBase(){
		return this.charset.length();
	}
	
	public long getPos() {
		return pos;
	}

	public long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public String getWord() {
		return word;
	}
}

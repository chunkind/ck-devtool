package com.ck.pr.cdgen.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;


public class WordExtractor {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\work\\workspace\\02_Application\\src\\test\\java\\ehimart\\app\\domain\\bo\\drc\\common\\util\\generator\\target.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(fileReader);
		
		String line = "";
		HashSet<String> s = new HashSet<String>();
		while((line = bufReader.readLine()) != null){
			if(line.contains("orderNo")){
				s.add(line.toString().replaceAll("\"", "").replaceAll(":", " ").replaceAll(",", "").trim());
			}
		}
		bufReader.close();
		
		Iterator<String> e = s.iterator();
		while (e.hasNext()) {
			System.out.println(e.next());
		}
	}
}

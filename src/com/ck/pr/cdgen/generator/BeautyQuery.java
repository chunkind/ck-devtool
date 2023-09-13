package com.ck.pr.cdgen.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BeautyQuery {

    public static void main(String[] args) {
//        StringBuilder result = new StringBuilder();
        List<String> result = new ArrayList<String>();
        
        try {
            String path = BeautyQuery.class.getResource("").getPath();
            String queryFileName = "beautyQuery.sql";
            BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + queryFileName));
            
            List<String> strList = new ArrayList<String>();
            String line = "";
            while((line = reader.readLine()) != null){
                String strs[] = line.split(" ");
                for(String s : strs){
                    strList.add(s);
                }
            }
            
            boolean isStart = false;
            String str = "";
            for(int i=0; i<strList.size(); i++){
                if("SELECT".equals(strList.get(i).toUpperCase())){
                    str = " "+strList.get(i);
                    isStart = true;
                }
                else if (isStart){
                    str = " "+strList.get(i);
                    isStart = false;
                }
                else if(strList.get(i).contains(",")){
                    str = " "+strList.get(i).replace(",", "")+"\n";
                }
                else if(strList.get(i).toUpperCase().contains("FROM")){
//                    strList.set(i-1,strList.get(i-1));
                    str = " "+strList.get(i).replace(",", "")+"\n";
                }
                else{
                    str = "      , "+strList.get(i);
                }
//                result.append(str);
                result.add(str);
            }
            
            for(int i=0; i<result.size(); i++){
                System.out.print(result.get(i).toString());
            }
            
//            System.out.println(result.toString());
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

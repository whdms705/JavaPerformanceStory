package ch09;


import java.io.*;
import java.util.*;


public class BasicIoReadUtil {
    // 읽은 내용을 일단 StringBuffer에 담고,줄이 바뀔 경우 ArrayList에 담아 리턴
    // 문자열을 하나씩 읽도록 되어 있기 때문에 느림
    public static ArrayList readCahrStream(String fileName)throws Exception{
        ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();

        //FileReader 문자열 기반의 스트림을 처리하기 위한 추상클래스이다.
        FileReader fr = null;
        try{
            fr = new FileReader(fileName);
            int data=0;
            //한줄씩 데이터를 담을 StringBuffer 생성
            StringBuffer sb = new StringBuffer();
            while((data=fr.read())!=-1){
                if(data=='\n' || data =='\r'){
                    list.add(sb);
                    sb=new StringBuffer();
                }else{
                    sb.append((char)data);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            throw e;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }finally {
            if(fr!=null) fr.close();
        }

        return list;
    }

    public static String readCahrStreamWithBuffer(String fileName)throws Exception{
        StringBuffer retSB = new StringBuffer();
        FileReader fr = null;
        try{
            fr = new FileReader(fileName);
            int bufferSize = 1024*1024;
            char readBuffer[] = new char[bufferSize];
            int resultSize=0;
            while((resultSize=fr.read(readBuffer))!=-1){
                if(resultSize==bufferSize){
                    retSB.append(readBuffer);
                }else{
                    for(int loop=0;loop<resultSize;loop++){
                        retSB.append(readBuffer[loop]);
                    }
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            throw e;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            if(fr!=null) fr.close();
        }
        return retSB.toString();
    }

    //BufferedReader도 문자열 단위나 문자열 배열 단위로 읽을 수 있는 기능을 제공하지만
    //추가로 라인 단위로 읽을 수 있는 readLine()메서드를 제공한다.
    public static ArrayList<String> readBufferedReader(String fileName)throws Exception{
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(fileName));
            String data;
            while((data=br.readLine())!=null){
                list.add(data);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            throw e;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            if(br!=null) br.close();
        }
        return list;
    }


    public static void main(String[] args)throws Exception {
        String fileName="C:\\";
        //StopWatch sw=new StopWatch();
        ArrayList list1 = BasicIoReadUtil.readCahrStream(fileName);
        System.out.println(list1.size());
    }

}

package me.inao.ecdhexample;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Connection {
    @Getter
    Socket conn;
    public boolean init(){
        try{
            this.conn = new Socket("localhost", 1337);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void write(String data){
        try{
            PrintStream outStream = new PrintStream(conn.getOutputStream());
            outStream.println(data);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String read(){
        try{
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            return inputStream.readLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

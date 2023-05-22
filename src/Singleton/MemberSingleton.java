package Singleton;

import Peoples.Member;
import Useful.Sports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class MemberSingleton {
    private static MemberSingleton instance = null;
    private ArrayList<Member> members = new ArrayList<Member>();

    public static MemberSingleton getInstance() {
        if (instance == null) {
            instance = new MemberSingleton();
        }
        return instance;
    }

    public static void setInstance(MemberSingleton instance) {
        MemberSingleton.instance = instance;
    }

    public ArrayList<Member> readMemberCSV(){
        String path = "src/Files/members.csv";
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            if(line == null){
                System.out.println("File is empty");
            }
            else{
                while(line != null){
                    String[] data = line.split(",");

                    var newMember = new Member(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Sports.valueOf(data[4]), Integer.parseInt(data[5]));
                    members.add(newMember);
                    line = br.readLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return members;
    }

    public void writeMemberCSV(ArrayList<Member> members){
        try{
            var writer = new FileWriter("src/Files/members.csv");
            for(var member: members){
                writer.write(member.toCSV());
                writer.write("\n");
            }

            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}

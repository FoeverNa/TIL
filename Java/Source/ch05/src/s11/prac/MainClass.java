package s11.prac;

import java.io.*;
import java.util.ArrayList;

class User implements Serializable{
    private String name;
    private transient String password;
    private String email;
    public int age;
    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age; }

    public String toString() {
        return "(" + name + ", " + password + ", " + email + ", " + age + ")";
    }

}



public class MainClass {

    private static final String USERINFO_SER = "user.ser";

    public static void main(String[] args) {
//        conductSerializing();
//        conductDeserializing();
        System.out.println(USERINFO_SER);
    }

    private static void conductSerializing() {
        try (FileOutputStream fos = new FileOutputStream(USERINFO_SER);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream out = new ObjectOutputStream(bos)) {

            User u1 = new User("이방원", "1234", 30);
            User u2 = new User("무휼", "8877", 25);

            ArrayList<User> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.out.println("직렬화 완료");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private static void conductDeserializing() {
        try(FileInputStream fis = new FileInputStream(USERINFO_SER);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis)) {

            User u1 = (User) in.readObject();
            User u2 = (User) in.readObject();
            ArrayList list = (ArrayList) in.readObject();

            System.out.println(u1.toString());
            System.out.println(u2.toString());
            System.out.println("count :: " + list.size());
            System.out.println(list.toString());



        } catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }

    }

}

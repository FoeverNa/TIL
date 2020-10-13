package s11.prac;

import java.io.*;
import java.net.URISyntaxException;

public class Main {

    static void copyStream(InputStream input, OutputStream output) throws IOException {

        byte[] buff = new byte[1024];
        int read = 0;
        while ((read = input.read(buff)) > 0) {
            output.write(buff, 0, read);
        }
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

//        try(InputStream input = System.in) {
//            int read = -1;
//            while((read = input.read()) != -1){
//                System.out.printf("Int: %d char: %c\n", read, read);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }


//        try(InputStream input = System.in) {
//            int read = 0;
//            byte[] bytes = new byte[512];
//            while((read = input.read(bytes)) != 0) {
//                System.out.println(Arrays.toString(bytes));
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//        try(InputStreamReader input = new InputStreamReader(System.in)) {
//            int read = -1;
//            while((read = input.read()) != -1) {
//                System.out.printf("Int: %d char: %c\n", read, read);
//
//
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//
//        try(InputStreamReader input = new InputStreamReader(System.in)) {
//            int read = -1;
//            char[] chars = new char[512];
//            while((read = input.read(chars)) != 1) {
//                System.out.println(Arrays.toString(chars));
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//        System.out.println(System.in.markSupported());
//
//        try(InputStream input = System.in) {
//            int read = -1;
//            while((read = input.read()) != 'q' ) {
//                System.out.printf("Int: %d char: %c\n", read, read);
//                if(read == 'm'){
//                    input.mark(32);
//                }
//                if ((char)read == 'r') {
//
//                    input.reset();
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//        char [] memory = "메모리 입출력 테스트 입력".toCharArray();
//        char [] cbuf = new char[4];
//        int read = 0;
//        try(CharArrayReader reader = new CharArrayReader(memory);
//            CharArrayWriter writer = new CharArrayWriter();) {
//
//            while((read = reader.read(cbuf)) > 0){
//                writer.write(cbuf, 0, read);
//            }
//            System.out.println(writer);
//
//        } catch (IOException e){
//            System.out.println(e);
//        }

//        System.out.println(File.separator);

//        String filePath = "C:\\Temp\\MyTemp";

//        String filePath = "C:" + File.separator + "Temp" + File.separator + "MyTemp";
////        System.out.println(filePath);
//
//        File fileOne = new File(filePath);
//        System.out.println(fileOne.mkdir());

//        File fileTwo = new File(filePath, "file2.txt");
//        System.out.println(fileTwo.createNewFile());

//        File fileThree = new File(fileOne, "file3.txt");
//        System.out.println(fileThree.createNewFile());
//
//        File fileFour =  new File(new URI("file:///C:/Temp/MyTemp/file4.txt"));
//        System.out.println(fileFour.createNewFile());
//        fileFour.deleteOnExit();
//
//        System.out.println(fileTwo.getName());
//        System.out.println(fileTwo.getParent());
//
//        System.out.println(fileTwo.isAbsolute());
//        System.out.println(fileTwo.getCanonicalPath());
//
//        System.out.println(fileOne.isDirectory());
//        System.out.println(fileTwo.isFile());
//
//        System.out.println(Arrays.toString(fileOne.list()));
//        System.out.println(Arrays.toString(fileOne.listFiles()));
//

//        File srcFile = new File(fileOne, "src.txt");
//        srcFile.createNewFile();
//        File dstFile = new File(fileOne, "dst.txt");
//        dstFile.createNewFile();
//
//        try(FileInputStream src = new FileInputStream(srcFile);
//            FileOutputStream dst = new FileOutputStream(dstFile);) {
//            int read = -1;
//            while((read = src.read()) != -1) {
//                dst.write(read);
//            }
//        } catch (IOException e){
//            System.out.println(e);
//        }
//
//        try(FileReader src = new FileReader(srcFile);
//            FileWriter dst = new FileWriter(dstFile,true)) {
//            int read = 0;
//            char[] buff = new char[4];
//            while((read = src.read(buff))> 0) {
//                dst.write(buff,0,read);
//            }
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//
//        File src = new File("C:/Windows/explorer.exe");
//        File dst = new File("C:/Temp/MyTemp/explorer.exe");
//
//        try(FileInputStream in = new FileInputStream(src);
//            FileOutputStream out = new FileOutputStream(dst);
//            BufferedInputStream buffIn = new BufferedInputStream(in);
//            BufferedOutputStream buffOut = new BufferedOutputStream(out);) {
//            long start = System.nanoTime();
//            copyStream(in, out);
//            System.out.println(System.nanoTime() - start);
//
//            start = System.nanoTime();
//            copyStream(buffIn, buffOut);
//            System.out.println(System.nanoTime() - start);
//
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//        File src = new File("C:/Temp/MyTemp/data.dat");
//        DataOutputStream out = new DataOutputStream(new FileOutputStream(src)); // 보조스트림이기에 메인 스트림에 객체를 생성해서 입력할필요가있다
//
//        out.writeUTF("자바왕");
//        out.writeInt(128);
//        out.writeFloat(523.411f);
//
//        DataInputStream in = new DataInputStream(new FileInputStream(src));
//        String str = in.readUTF();
//        int integer = in.readInt();
//        float floatVal = in.readFloat();
//
//        System.out.println(str + " " + integer + " " + floatVal);
//
//        char [] memory = "메모리 입출력 테스트 입력".toCharArray();
//        char [] buff = new char[4];
//        int read = 0;
//        try(CharArrayReader reader = new CharArrayReader(memory);
//            CharArrayWriter writer = new CharArrayWriter();) {
//
//            while((read = reader.read(buff)) > 0){
//                writer.write(buff, 0, read);
//            }
//            System.out.println(Arrays.toString(writer.toCharArray()));
//
//        } catch (IOException e){
//            System.out.println(e);
//        }

//        System.out.println("데이터를 입력하세요");
//        try(InputStream is = System.in;
//            InputStreamReader reader = new InputStreamReader(is);
//            BufferedReader buffer = new BufferedReader(reader);) {
//            String str = buffer.readLine();
//            System.out.println("입력값: " + str);
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }

//
//        class Foo implements Serializable {
//
//
//            static final long serialVersionUID = 1L;
//
//            String userName;
//            int userID;
//            transient String passWord;
//            // Triansient (제어자)의 경우 Serialzie에 포함되지 않음( 저장/ 불러오기 대상에서 제외 된다)
//
//            public Foo() {}
//
//            public Foo(String userName, int userID, String passWord) {
//                this.userName = userName;
//                this.userID = userID;
//                this.passWord = passWord;
//            }
//
//            @Override
//            public String toString() {
//                return userName + " " + userID + " " + passWord;
//            }
//        }
//
//        Foo foo = new Foo("johsep", 1344, "gigawifi");
//
//        System.out.println(foo);
//
////        File dst = new File("C://Temp/Mytemp/obj.data"); // 확장자는 상관이 없다
//
//        byte[] serializedMember;
//
//        try(ByteArrayOutputStream baos = new ByteArrayOutputStream() ;
//            ObjectOutputStream oos = new ObjectOutputStream(baos);) {
//            oos.writeObject(foo);
//            serializedMember = baos.toByteArray();
//            System.out.println(Arrays.toString(serializedMember));
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }


//        class ParentFoo{
//            int memVarOne;
//            double memVarTwo;
//        }
//
//        class ChildFoo extends ParentFoo implements Serializable {
//
//            int childMember;
//
//            public ChildFoo(int childMember) {
//                this.memVarOne = 123;
//                this.memVarTwo = 456.7;
//                this.childMember = childMember;
//            }
//
//            private void writeObject(ObjectOutputStream out) throws IOException {
//                out.writeInt(memVarOne);
//                out.writeDouble(memVarTwo);
//                out.defaultWriteObject();
//            }
//
//            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//                memVarOne = in.read();
//                memVarTwo = in.readDouble();
//                in.defaultReadObject();
//            }
//
//            public String toString() {
//                return memVarOne + "," + memVarTwo + "," + childMember;
//            }
//        }
//
//        ChildFoo childFoo = new ChildFoo(987);
//        System.out.println(childFoo);
//
//        File dst = new File("C:/Temp/MyTemp/obj.data"); //확장자는 상관이 없다
//
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dst));
//             ObjectInputStream in = new ObjectInputStream(new FileInputStream(dst))) {
//            out.writeObject(childFoo);
//            Object read = in.readObject();
//            if (read != null && read instanceof ChildFoo) {
//                ChildFoo readFoo = (ChildFoo) read;
//                System.out.println(readFoo); // HanSol-The=Outsider 1423 null
//                //결과의 password가 null로 나온것은 transient로 만들었기 때문이다
//
//            }
//        } catch (ClassNotFoundException e) { // 다른 예외 발생시킨다
//            e.printStackTrace();
//        }


//        class Job{
//
//            String job ;
//        }
//
//
//
//        class Person extends Job implements Serializable{
//            String name;
//            int age;
//
//            public Person(){}
//
//            public Person(String name, int age, String job) {
//                super.job = job;
//                this.name = name;
//                this.age = age;
//            }
//
//            public String toString() {
//                return  name +" , " + age +" , " + job ;
//            }
//
//
//            private void writeObject(ObjectOutputStream out) throws IOException {
//                System.out.println("write");
//                out.writeUTF(job);
//                out.defaultWriteObject();
//            }
//
//
//            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//                System.out.println("read");
//                job = in.readUTF();
//               in.defaultReadObject();
//            }
//        }
//
//        File dst = new File("C:/Temp/MyTemp/obj.data"); //확장자는 상관이 없다
//
//
//        Person personLee = new Person("이순신", 23, "학생");
//        Person personKim = new Person("김유신", 43, "개발자");
//
//        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dst));
//            ObjectInputStream in   = new ObjectInputStream(new FileInputStream(dst))) {
//
//            out.writeObject(personLee);
//            out.writeObject(personKim);
//
//            Person lee = (Person) in.readObject();
//            Person kim = (Person) in.readObject();
//            System.out.println(lee);
//            System.out.println(kim);
//
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
//
//        class ParentFoo {
//            int memVarOne;
//            double memVarTwo;
//
//        }
//
//        class ChildFoo extends ParentFoo implements Serializable {
//            String childMember; // 얘는 childMember이기 때문에 알아서 직렬화된다
//
//
//            public ChildFoo(String childMember, int memVarOne, double memVarTwo) {
//                this.childMember = childMember;
//                this.memVarOne = memVarOne;
//                this.memVarTwo = memVarTwo;
//            }
//
//            private void writeObject(ObjectOutputStream out) throws IOException {
//                System.out.println("write");
//                out.writeInt(memVarOne); // 직접 부모객체의 멤버 변수를 직접 out에 써주기어야 한다
//                out.writeDouble(memVarTwo); // 원하지 않는 변수가 있다면 trsient대신 그냥 생략해주어도 된다
//                out.defaultWriteObject(); //child foo에 있는애들을 직렬화해주는 애
//            }
//
//            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//                System.out.println("read");
//                memVarOne = in.readInt(); // write를 한 순서 그대로 읽어야만 읽는게 가능하다
//                memVarTwo = in.readDouble();
//                in.defaultReadObject();
//
//            }
//
//            @Override
//            public String toString() {
//                return "이름: " + childMember + "나이: " + memVarOne + "신장: " + memVarTwo;
//            }
//        }
//
//
//        File dst = new File("C:/Temp/MyTemp/obj.data"); //확장자는 상관이 없다
//
//
//        ChildFoo personLee = new ChildFoo("이순신", 23, 180.5);
//        ChildFoo personKim = new ChildFoo("김유신", 43, 173.7);
//
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dst));
//             ObjectInputStream in = new ObjectInputStream(new FileInputStream(dst))) {
//
//            out.writeObject(personLee);
//            out.writeObject(personKim);
//
//            ChildFoo lee = (ChildFoo) in.readObject();
//            ChildFoo kim = (ChildFoo) in.readObject();
//            System.out.println(lee);
//            System.out.println(kim);
//
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e);
//        }


//        try (InputStream input = System.in) {
//            System.out.println("입력하세요");
//            int read = 0;
//            byte[] bytes = new byte[512];
//            while ((read = input.read(bytes)) != 0) {
//                if ((char) bytes[0] == 'q') {
//                    break;
//                }
//
//                System.out.println(Arrays.toString(bytes));
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (InputStreamReader input = new InputStreamReader(System.in)) {
//            System.out.println("입력하세요");
//            int read = 0;
//            char[] chars = new char[4];
//            while ((read = input.read(chars)) != 0) {
//                if (chars[0] == 'q') {
//                    break;
//                }
//                System.out.print(Arrays.toString(chars));
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        class Foo implements Serializable {
//            static final long serialVersionUID = 1L;
//            final String userName;
//            final int userID;
//            transient String password;
//
//            public Foo(String userName, int userID, String password) {
//                this.userName = userName;
//                this.userID = userID;
//                this.password = password;
//            }
//
//            @Override
//            public String toString() {
//                return userName + " " + userID + " " + password;
//            }
//        }
//
//        Foo user1 = new Foo("sam", 870212, "samzzang");
//        Foo user2 = new Foo("marvin", 930330, "sudoman");
//
//        File file = new File("C://Temp/MyTemp/user.dat");
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//             ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//            out.writeObject(user1);
//            out.writeObject(user2);
//            Foo userOne = (Foo)in.readObject();
//            Foo userTwo = (Foo)in.readObject();
//            System.out.println(userOne);
//            System.out.println(userTwo);
//        } catch (IOException | ClassNotFoundException e){
//            System.out.println(e);
//        }

        class ParentFoo {
            int memVarOne;
            double memVarTwo;

        }

        class ChildFoo extends ParentFoo implements Serializable {
            String childMember; // 얘는 childMember이기 때문에 알아서 직렬화된다

            public ChildFoo(int memVarOne , double memVarTwo, String childMember) {
                super.memVarOne = memVarOne;
                super.memVarTwo = memVarTwo;
                this.childMember = childMember;
            }

            private void writeObject(ObjectOutputStream out) throws IOException {
                out.writeInt(memVarOne);
                out.writeDouble(memVarTwo);
                out.writeUTF(childMember);
            }

            private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
                memVarOne = in.readInt();
                memVarTwo = in.readDouble();
                childMember = in.readUTF();
            }

            @Override
            public String toString() {
                return "ChildFoo{" +
                        "memVarOne=" + memVarOne +
                        ", memVarTwo=" + memVarTwo +
                        ", childMember='" + childMember + '\'' +
                        '}';
            }
        }

        ChildFoo foo = new ChildFoo(1,2.09,"이거도어");

        File file = new File("C://Temp/MyTemp/user.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            out.writeObject(foo);
            ChildFoo reFoo = (ChildFoo) in.readObject();
            System.out.println(reFoo);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

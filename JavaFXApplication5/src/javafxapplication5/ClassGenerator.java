/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import UserClasses.finalTestt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 *
 * @author Issa
 */
public class ClassGenerator {
    public static String getClassText(ClassDetails classDetails) throws FileNotFoundException, IOException, ClassNotFoundException {
        String s = "package UserClasses;\n";
        List<String> primitives = new ArrayList<String>();
        List<String> attributes = new ArrayList<String>();
        int z = 0;//for name of attribbutes
        primitives.add("int");
        primitives.add("float");
        primitives.add("double");
        primitives.add("char");
        primitives.add("boolean");
        primitives.add("byte");
        primitives.add("long");
        primitives.add("short");
        s += "public class " + classDetails.getClassName();
        if (classDetails.isSubClass() == true) {
            s = s + " extends " + classDetails.getSuperClass();
        }
        else
            s=s+" extends superDictionary";
        s = s + "{\n";
        //attributes declaration
        
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            if (attributes.contains(classDetails.getAttributes().get(i).getName())) {
                System.out.println("error: cannot use same name for 2 attributes");//pop up aw shi
            } else {
                attributes.add(classDetails.getAttributes().get(i).getName());
            }
            s = s + String.format("    private final %s %s;\n", classDetails.getAttributes().get(i).getType(),classDetails.getAttributes().get(i).getName());
            attributes.add(classDetails.getAttributes().get(i).getName());
        }
        //classDetails.getClassName()
        //full constructor declaration
        s = s + "public " + classDetails.getClassName() + "(";
        //attributes of super class
        List<String> superType = new ArrayList<String>();
        //List<String> superName=new ArrayList<String>();
        if (classDetails.isSubClass() == true) {
            File f = new File("./attributes/" + classDetails.getClassName() + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {//System.out.println(line);
                superType.add(line);
            }
        }
        for (int i = 0; i < superType.size(); i++) {
            s = s + String.format("%s S%d,", superType.get(i), z);
            z++;
        }
        //attributes of this class
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            s = s + String.format("%s S%d,",classDetails.getAttributes().get(i).getType(), z);
            z++;
            //s = s + typeField.get(i).getSelectionModel().getSelectedItem().toString() + " " + nameField.get(i).getText().trim() + ",";
            finalTestt sas=new finalTestt("sdasd",100);
        }
        if(classDetails.getAttributes().size()>0)
        s = s.substring(0, s.length() - 1);//remove last ,
        s = s + "){\n";
        //super(......)
        z = 0;
        for (int i = 0; i < superType.size(); i++) {
            if (i == 0) {
                s = s + "super(";
            }
            s = s + String.format("S%d,", z);
            z++;
            if (i == superType.size() - 1) {
                s = s.substring(0, s.length() - 1) + ");\n";
            }
        }
        //this.dsdds=dsdsa;
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            s = s + String.format("this.%s=S%d;\n", classDetails.getAttributes().get(i).getName(), z);
            z++;
            /// s = s +"this." + nameField.get(i).getText().trim() + " = " + nameField.get(i).getText().trim() + ";\n";
        }
        s = s + "\n}";
        String classSuper;
        if (classDetails.isSubClass()) {
            classSuper = classDetails.getSuperClass();
        } else {
            classSuper = "";
        }
        Pair<String, Integer> hashPair = hashCodeText(classDetails);
        saveAttributes(classDetails, superType, hashPair.getSecond());//+ compareToText(typeField,nameField,method,primitives) ta7et
        return s + equalText(classDetails, primitives) + stringText(classDetails, primitives) + hashPair.getFirst() + compareToText(classDetails, primitives) + "}";}
    private static String equalText(ClassDetails classDetails, List<String> primitives) {

//        List<String> primitives=new ArrayList<String>();
//        primitives.add("int");
//        primitives.add("float");
//        primitives.add("double");
//        primitives.add("char");
//        primitives.add("boolean");
//        primitives.add("byte");
//        primitives.add("long");
//        primitives.add("short");
        String s = "\n@Override\n"
                + "public boolean equals(Object otherObj){\n"
                + "if(!super.equals(otherObj))\n"
                + "	return false;";
        boolean b = false;
        //casting
        s = s + String.format("\n%s other = (%s) otherObj;\n", classDetails.getClassName(), classDetails.getClassName());
        s = s + "return ";
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            if (classDetails.getAttributes().get(i).isChecked()== true) {
                b = true;
                if (primitives.contains(classDetails.getAttributes().get(i).getType())) {
                    s = s + String.format("this.%s==other.%s && ", classDetails.getAttributes().get(i).getName(), classDetails.getAttributes().get(i).getName());
                } else {
                    s = s + String.format("((this.%s==null && other.%s==null)||(this.%s!=null && this.%s.equals(other.%s))) && ",classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName());
                }
            }
        }
        //remove last &&

        if (b == false) {
            s = s + " true";//no item selected
        } else {
            s = s.substring(0, s.length() - 3);
        }
        s = s + ";}";
        return s;
    }

    private static String stringText(ClassDetails classDetails, List<String> primitives) {
        int i;
        String s = "\n@Override\n"
                + "public String toString(){return super.toString() + \"[\" + ";
        for (i = 0; i < classDetails.getAttributes().size(); i++) {
            s = s + String.format("\"%s=\" + %s",classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName());

            if (!(primitives.contains(classDetails.getAttributes().get(i).getType()))) //               s = s + nameField.get(i).getText() + " + ";
            //           else
            {
                s = s + ".toString()";
            }
            if (i != classDetails.getAttributes().size() - 1) {
                s = s + " + \",\"";
            }
            s = s + " + ";
        }
//       if (i !=0)
//           s = s.substring(0,s.length()-3);
        return s + "\"]\";\n}";
    }

    private static void saveAttributes(ClassDetails classDetails,List<String> superType, Integer prime) throws FileNotFoundException {
        String path="./attributes/" + classDetails.getClassName() + ".txt";
        File f = new File(path);
        PrintWriter p = new PrintWriter(f);
        p.println(prime);
        for (int i = 0; i < superType.size(); i++) {
            p.println(superType.get(i));
        }
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            p.println(classDetails.getAttributes().get(i).getType());
        }
        p.close();
    }

    public static boolean isPrime(int n) {
        // Corner case
        if (n <= 1) {
            return false;
        }

        // Check from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0 && n != 2) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> getPrimes(int begin, int count) {
        List<Integer> primes = new ArrayList<Integer>();
        int i = 0;
        //boolean b = false;

        while (i < count) {
            if (isPrime(begin)) {
                i++;
                primes.add(begin);
            }
            begin++;
        }
        return primes;
    }

    private static Pair hashCodeText(ClassDetails classDetails) throws IOException {
        int checkedNbr = 0;
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            if (classDetails.getAttributes().get(i).isChecked() == true) {
                checkedNbr++;
            }
        }

        String s = "\n@Override\n"
                + "public int hashCode(){\n"
                + "return super.hashCode() + ";
        List<Integer> primes;
        String line = "1";
        if (classDetails.isSubClass() == false) {
            primes = getPrimes(2, checkedNbr);
        } else {
            File f = new File("./attributes/" + classDetails.getSuperClass() + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            line = reader.readLine();
            primes = getPrimes(Integer.parseInt(line) + 1, checkedNbr);
        }

       // System.out.println(primes.toString());
        Map<String, String> builtInMap = new HashMap<String, String>();
        builtInMap.put("int", "Integer");
        builtInMap.put("long", "Long");
        builtInMap.put("double", "Double");
        builtInMap.put("float", "Float");
//       Integer.valueOf(s).hashCode();
        builtInMap.put("bool", "Boolean");
        builtInMap.put("char", "Character");
        builtInMap.put("byte", "Byte");
        // builtInMap.put("void", Void.TYPE );
        builtInMap.put("short", "Short");
        int j = 0;
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            if (classDetails.getAttributes().get(i).isChecked() == true) {
                if (builtInMap.containsKey(classDetails.getAttributes().get(i).getType())) {
                    s = s + String.format("%d*%s.valueOf(%s).hashCode() + ", primes.get(j), builtInMap.get(classDetails.getAttributes().get(i).getType()),classDetails.getAttributes().get(i).getName());
                } else {
                    s = s + String.format("%d*%s.hashCode() + ", primes.get(j),classDetails.getAttributes().get(i).getName());
                }
                j++;
            }
        }
        s = s.substring(0, s.length() - 3) + ";}\n";
        //System.out.println("");
        if (primes.size() != 0) {
            return new Pair(s, primes.get(primes.size() - 1));
        } else {
            return new Pair(s, Integer.parseInt(line));
        }
    }

     private static String compareToText(ClassDetails classDetails,List<String> primitives) throws ClassNotFoundException {
       Map<String, String> builtInMap = new HashMap<String, String>();
      
        builtInMap.put("int", "Integer");
        builtInMap.put("long", "Long");
        builtInMap.put("double", "Double");
        builtInMap.put("float", "Float");
//       Integer.valueOf(s).hashCode();
        builtInMap.put("bool", "Boolean");
        builtInMap.put("char", "Character");
        builtInMap.put("byte", "Byte");
        // builtInMap.put("void", Void.TYPE );
        builtInMap.put("short", "Short");
        String s = "@Override\n" +
                 "public int compareTo(superDictionary other){\n if(!(other.getClass()==getClass()))\nSystem.out.println(\"\");\n"
                + String.format("%s others=(%s)other;\n", classDetails.getClassName(), classDetails.getClassName()) + "if(super.compareTo(other)==0 && ";
       // int ii;
       
        String ss = "\nreturn (int)(super.compareTo(other) + ";
        for (int i = 0; i < classDetails.getAttributes().size(); i++) {
            if (classDetails.getAttributes().get(i).isChecked() == true) {
                if (primitives.contains(classDetails.getAttributes().get(i).getType())) {//System.out.println(typeField.get(i));
                    //System.out.println(builtInMap.get(typeField.get(i)));
                    s = s + String.format("(%s.valueOf(%s) - %s.valueOf(others.%s))==0 && ", builtInMap.get(classDetails.getAttributes().get(i).getType()),classDetails.getAttributes().get(i).getName(),  builtInMap.get(classDetails.getAttributes().get(i).getType()),classDetails.getAttributes().get(i).getName());
                    ss = ss + String.format("(%s - others.%s) + ", classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName());
                } else {
                    s = s + String.format("(%s.compareTo(others.%s))==0 && ", classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName());
                    ss = ss + String.format("%s.compareTo(others.%s) + ", classDetails.getAttributes().get(i).getName(),classDetails.getAttributes().get(i).getName());
                }
            }
        }
        ss = ss.substring(0, ss.length() - 3) + ");}";
        s = s.substring(0, s.length() - 3) + ")\n\treturn 0;" + ss;
        return s;
    }
    public static void compileClass(ClassDetails classDetails) throws FileNotFoundException, IOException, ClassNotFoundException{
    
        String source = ".\\src\\UserClasses\\" + classDetails.getClassName() + ".java";
        String tempSource = ".\\src\\UserClasses\\" + classDetails.getClassName() + ".class";
        String sourceClass = ".\\build\\classes\\UserClasses\\" + classDetails.getClassName() + ".class";
        //File f=new File(source);
       // PrintWriter writer = new PrintWriter(f);
        String getClass = getClassText(classDetails);
        //System.out.println(getClass);

	
//cons c=new cons();
//c.compareTo(c)
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\UserClasses\\"+classDetails.getClassName()+".java"))) {

			//String content = "This is the content to write into file\n";

			//bw.write(content);
                        bw.write(getClass);

			// no need to close it.
			//bw.close();

			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
        //writer.print(source);
//        writer.println("ss");
//        writer.println("sssss");
//        writer.println(getClass);
//        writer.println("ssssd");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, source);      
        
        Files.move(Paths.get(tempSource), Paths.get(sourceClass), StandardCopyOption.REPLACE_EXISTING);
        
    }
}



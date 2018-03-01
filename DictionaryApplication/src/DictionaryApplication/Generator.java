/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryApplication;

import static FxmlFiles.Start.dictionaries;
import static FxmlFiles.Start.pool;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 *
 * @author user
 */
public class Generator {//done
     public static List<String> getClassObject(String selectedClass){
//        selectedClass=selectedClass.substring(0,selectedClass.indexOf("."));
        List<String> a=new ArrayList<String>();
//        List<String> key = new ArrayList<String>(pool.keySet());
//        for(String s:key){String w=s.substring(0,s.indexOf("."));
//            if(w.equals(selectedClass))
//                a.add(s.substring(s.indexOf(".")+1));
//        }
//        return a;
         a.addAll(pool.get(selectedClass).keySet());
         return a;
    }
     public static List<String> getClassNames() {
        List<String> fnames = new ArrayList<String>();
        File folder = new File(".\\UserClasses1");
        File[] listOfFiles = folder.listFiles();
           // String extension = "";
for (File fileName : listOfFiles) {
    if (fileName.isFile()) {
int i = fileName.getName().lastIndexOf(".java");
if (i >= 0) {
   fnames.add(fileName.getName().substring(0,i));
}
    }}
//    fnames.add("int");
//    fnames.add("double");
//    fnames.add("boolean");
//    fnames.add("short");
//    fnames.add("long");
//    fnames.add("char");
//    fnames.add("byte");
//    fnames.add("String");
//    fnames.add("float");
    fnames.remove("SuperType");
        return fnames;
    }

    public static String GetText(ClassDetails cls) {
        String s = "";
        s = s + "public " + cls.getClassName() + "(";
        return s;
    }

    public static String getClassText(List<ComboBox> typeField, List<TextField> nameField, String className, List<CheckBox> method, CheckBox sub, ComboBox superClass) throws FileNotFoundException, IOException, ClassNotFoundException {
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
        s += "public class " + className;
        if (sub.isSelected() == true) {
            s = s + " extends " + superClass.getValue().toString().trim();
        }
        else
            s=s+" extends SuperType";
        s = s + "{\n";
        //attributes declaration
        for (int i = 0; i < typeField.size(); i++) {
            if (attributes.contains(nameField.get(i).getText())) {
                System.out.println("error: cannot use same name for 2 attributes");//pop up aw shi
            } else {
                attributes.add(nameField.get(i).getText());
            }
            s = s + String.format("    private final %s %s;\n", typeField.get(i).getSelectionModel().getSelectedItem().toString(), nameField.get(i).getText().trim());
            attributes.add(nameField.get(i).getText());
        }

        //full constructor declaration
        s = s + "public " + className + "(";
        //attributes of super class
        List<String> superType = new ArrayList<String>();
        //List<String> superName=new ArrayList<String>();
        if (sub.isSelected() == true) {
            File f = new File("./attributes/" + superClass.getValue().toString().trim() + ".txt");
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
        for (int i = 0; i < typeField.size(); i++) {
            s = s + String.format("%s S%d,", typeField.get(i).getSelectionModel().getSelectedItem().toString(), z);
            z++;
            //s = s + typeField.get(i).getSelectionModel().getSelectedItem().toString() + " " + nameField.get(i).getText().trim() + ",";
            
        }
        if(typeField.size()>0)
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
        for (int i = 0; i < typeField.size(); i++) {
            s = s + String.format("this.%s=S%d;\n", nameField.get(i).getText().trim(), z);
            z++;
            /// s = s +"this." + nameField.get(i).getText().trim() + " = " + nameField.get(i).getText().trim() + ";\n";
        }
        s = s + "\n}";
        String classSuper;
        if (sub.isSelected()) {
            classSuper = superClass.getValue().toString().trim();
        } else {
            classSuper = "";
        }
        Pair<String, Integer> hashPair = hashCodeText(typeField, nameField, sub, classSuper, method);
        saveAttributes("./attributes/" + className + ".txt", superType, typeField, hashPair.getEnemy());//+ compareToText(typeField,nameField,method,primitives) ta7et
        return s + equalText(typeField, nameField, method, className, primitives) + stringText(typeField, nameField, primitives) + hashPair.getFriend() + compareToText(typeField, nameField, method, primitives, className) + "}";}
    private static String equalText(List<ComboBox> typeField, List<TextField> nameField, List<CheckBox> method, String className, List<String> primitives) {

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
        s = s + String.format("\n%s other = (%s) otherObj;\n", className, className);
        s = s + "return ";
        for (int i = 0; i < method.size(); i++) {
            if (method.get(i).isSelected() == true) {
                b = true;
                if (primitives.contains(typeField.get(i).getSelectionModel().getSelectedItem().toString())) {
                    s = s + String.format("this.%s==other.%s && ", nameField.get(i).getText(), nameField.get(i).getText());
                } else {
                    s = s + String.format("((this.%s==null && other.%s==null)||(this.%s!=null && this.%s.equals(other.%s))) && ", nameField.get(i).getText(), nameField.get(i).getText(), nameField.get(i).getText(), nameField.get(i).getText(), nameField.get(i).getText());
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

    private static String stringText(List<ComboBox> typeField, List<TextField> nameField, List<String> primitives) {
        int i;
        String s = "\n@Override\n"
                + "public String toString(){return super.toString() + \"[\" + ";
        for (i = 0; i < typeField.size(); i++) {
            s = s + String.format("\"%s=\" + %s", nameField.get(i).getText(), nameField.get(i).getText());

            if (!(primitives.contains(typeField.get(i).getSelectionModel().getSelectedItem().toString()))) //               s = s + nameField.get(i).getText() + " + ";
            //           else
            {
                s = s + ".toString()";
            }
            if (i != typeField.size() - 1) {
                s = s + " + \",\"";
            }
            s = s + " + ";
        }
//       if (i !=0)
//           s = s.substring(0,s.length()-3);
        return s + "\"]\";\n}";
    }

    private static void saveAttributes(String path, List<String> superType, List<ComboBox> typeField, Integer prime) throws FileNotFoundException {
        File f = new File(path);
        PrintWriter p = new PrintWriter(f);
        p.println(prime);
        for (int i = 0; i < superType.size(); i++) {
            p.println(superType.get(i));
        }
        for (int i = 0; i < typeField.size(); i++) {
            p.println(typeField.get(i).getSelectionModel().getSelectedItem().toString());
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

    private static Pair hashCodeText(List<ComboBox> typeField, List<TextField> nameField, CheckBox sub, String superClass, List<CheckBox> method) throws IOException {
        int checkedNbr = 0;
        for (int i = 0; i < method.size(); i++) {
            if (method.get(i).isSelected() == true) {
                checkedNbr++;
            }
        }

        String s = "\n@Override\n"
                + "public int hashCode(){\n"
                + "return super.hashCode() + ";
        List<Integer> primes;
        String line = "1";
        if (sub.isSelected() == false) {
            primes = getPrimes(2, checkedNbr);
        } else {
            File f = new File("./attributes/" + superClass.toString().trim() + ".txt");
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
        for (int i = 0; i < nameField.size(); i++) {
            if (method.get(i).isSelected() == true) {
                if (builtInMap.containsKey(typeField.get(i).getSelectionModel().getSelectedItem().toString())) {
                    s = s + String.format("%d*%s.valueOf(%s).hashCode() + ", primes.get(j), builtInMap.get(typeField.get(i).getSelectionModel().getSelectedItem().toString()), nameField.get(i).getText());
                } else {
                    s = s + String.format("%d*%s.hashCode() + ", primes.get(j), nameField.get(i).getText());
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

     private static String compareToText(List<ComboBox> typeField, List<TextField> nameField, List<CheckBox> method, List<String> primitives, String className) throws ClassNotFoundException {
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
        String s = "@Override\n"
                + "public int compareTo(SuperType other){\n if(!(other.getClass()==getClass()))\nSystem.out.println(\"\");\n"
                + String.format("%s others=(%s)other;\n", className, className) + "if(super.compareTo(other)==0 && ";
//           if (sub.isSelected()==false)
//               s = s + className + "))\nthrow InvalidComparisonTypeException;\n";
//           else{
//               String path="projects." + superClass;
//        Class c=Class.forName(path);
//        List<String> superClassesName=new ArrayList<String>();
//            Object o=new Object();
//           while(c != o.getClass()){
//               c=c.getSuperclass();             
//              superClassesName.add(c.getSimpleName());
//              s = s + superClassesName.get(superClassesName.size()-2) + "))\nthrow new InvalidComparisonTypeException();\n";
//           }
//           }
        String ss = "\nreturn (int)(super.compareTo(other) + ";
        for (int i = 0; i < nameField.size(); i++) {
            if (method.get(i).isSelected() == true) {
                if (primitives.contains(typeField.get(i).getSelectionModel().getSelectedItem().toString())) {//System.out.println(typeField.get(i));
                    //System.out.println(builtInMap.get(typeField.get(i)));
                    s = s + String.format("(%s.valueOf(%s) - %s.valueOf(others.%s))==0 && ", builtInMap.get(typeField.get(i).getSelectionModel().getSelectedItem().toString()),nameField.get(i).getText(),  builtInMap.get(typeField.get(i).getSelectionModel().getSelectedItem().toString()),nameField.get(i).getText());
                    ss = ss + String.format("(%s - others.%s) + ", nameField.get(i).getText(), nameField.get(i).getText());
                } else {
                    s = s + String.format("(%s.compareTo(others.%s))==0 && ", nameField.get(i).getText(), nameField.get(i).getText());
                    ss = ss + String.format("%s.compareTo(others.%s) + ", nameField.get(i).getText(), nameField.get(i).getText());
                }
            }
        }
        ss = ss.substring(0, ss.length() - 3) + ");}";
        s = s.substring(0, s.length() - 3) + ")\n\treturn 0;" + ss;
        return s;
    }
    public static void compileClass(List<ComboBox> typeField,List<TextField> nameField,String className,List<CheckBox> method,CheckBox sub,ComboBox superClass) throws FileNotFoundException, IOException, ClassNotFoundException{
    
        String source = ".\\src\\UserClasses\\" + className + ".java";
        String tempSource = ".\\src\\UserClasses\\" + className + ".class";
        String sourceClass = ".\\build\\classes\\UserClasses\\" + className + ".class";
        //File f=new File(source);
       // PrintWriter writer = new PrintWriter(f);
        String getClass = getClassText(typeField,nameField,className,method,sub,superClass);
        //System.out.println(getClass);

	
//cons c=new cons();
//c.compareTo(c)
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\UserClasses\\"+className+".java"))) {

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
    public static Set<String> dictionaryObjects(String className){
         Set<SuperType> keys=dictionaries.get(className).getElements().keySet();
//        if(keys==null)
//            System.out.println("empty");
//        if(keys.size()==0)
//            System.out.println("0");
//        System.out.println(keys.size());
//        System.out.println(keys.toArray()[0].toString());
        Set<String> poolKeys= pool.get(className).keySet();
        //for(SuperType key:keys)
        //    System.out.println(key.toString());
        Set<String> dictionaryObjects=new HashSet<String>();
        for(String key:poolKeys){//System.out.println(key);
            //System.out.println(keys.size());
            if(keys.contains(pool.get(className).get(key)))
                dictionaryObjects.add(key);
        }
         return dictionaryObjects;
       
    }
    public static void deleteMedia(String path){System.out.println("11");
       File oldMedia=new File(path);
//        String[]entries = oldMedia.list();
//        System.out.println(entries.length);
//for(String s: entries){System.out.println(s);
//    File currentFile = new File(oldMedia.getPath(),s);
//    currentFile.delete();
//}
        File[] classFolders= oldMedia.listFiles();
        ArrayList<File> objectFolders=new ArrayList<>();
        for(int i=0;i<classFolders.length;i++){
            if(classFolders[i].list().length==0)
            {classFolders[i].delete();continue;}
            File[] objectFold=classFolders[i].listFiles();
            for(int j=0;j<objectFold.length;j++)
                objectFolders.add(objectFold[j]);
        }
        ArrayList<File> mediaObjectFolders=new ArrayList<File>();
        for(int i=0;i<objectFolders.size();i++){
            File[] objectFold=objectFolders.get(i).listFiles();
            for(int j=0;j<objectFold.length;j++)
                mediaObjectFolders.add(objectFold[j]);
        }
        for(int i=0;i<mediaObjectFolders.size();i++)
        {File[] objectFold=mediaObjectFolders.get(i).listFiles();
        for(int j=0;j<objectFold.length;j++)
                objectFold[j].delete();
        mediaObjectFolders.get(i).delete();
        }
        for(int i=0;i<objectFolders.size();i++)
        objectFolders.get(i).delete();
        for(int i=0;i<classFolders.length;i++)
        classFolders[i].delete();
        oldMedia.delete();
        
    
}
        
    public static void deleteDirectory(File source) throws IOException {File[] files;
        if(source.isDirectory()==true){System.out.println("isDre" + source.getName());files=source.listFiles();
        for(int i=0;i<files.length;i++){System.out.println(files[i]);
            if(files[i].isDirectory()==true)
                deleteDirectory(files[i]);
            else
                Files.delete(files[i].toPath());
        }
    }

}
//    private static void copyFile(File source, File target) throws IOException {        
//    try (
//            InputStream in = new FileInputStream(source);
//            OutputStream out = new FileOutputStream(target)
//    ) {
//        byte[] buf = new byte[1024];
//        int length;
//        while ((length = in.read(buf)) > 0) {
//            out.write(buf, 0, length);
//        }
//    }}
//    public static void copy(File sourceLocation, File targetLocation) throws IOException {
//    if (sourceLocation.isDirectory()) {
//        copyDirectory(sourceLocation, targetLocation);
//    } else {
//        copyFile(sourceLocation, targetLocation);
//    }
//}
}


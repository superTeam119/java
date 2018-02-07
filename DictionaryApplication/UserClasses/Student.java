package UserClasses;
public class Student extends Person{
    private final int grade;
public Student(String name S0,int age S1,int S2){
super(S0,S1);
this.grade=S2;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Student other = (Student) otherObj;
return this.grade==other.grade ;}
@Override
public String toString(){return super.toString() + "[" + "grade=" + grade + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 5*Integer.valueOf(grade).hashCode();}
@Override
public int compareTo(superDictionary other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Student others=(Student)other;
if(super.compareTo(other)==0 && (Integer.valueOf(grade) - Integer.valueOf(others.grade))==0 )
	return 0;
return (int)(super.compareTo(other) + (grade - others.grade));}}
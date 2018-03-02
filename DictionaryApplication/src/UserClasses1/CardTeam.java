package UserClasses1;
import DictionaryApplication.SuperType;
public class CardTeam extends SuperType{
    private final Person personA;
    private final Person person;
public CardTeam(Person S0,Person S1){
this.personA=S0;
this.person=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
CardTeam other = (CardTeam) otherObj;
return ((this.personA==null && other.personA==null)||(this.personA!=null && this.personA.equals(other.personA))) && ((this.person==null && other.person==null)||(this.person!=null && this.person.equals(other.person))) ;}
@Override
public String toString(){return super.toString() + "[" + "personA=" + personA.toString() + "," + "person=" + person.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*personA.hashCode() + 3*person.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
CardTeam others=(CardTeam)other;
if(super.compareTo(other)==0 && (personA.compareTo(others.personA))==0 && (person.compareTo(others.person))==0 )
	return 0;
return (int)(super.compareTo(other) + personA.compareTo(others.personA) + person.compareTo(others.person));}}
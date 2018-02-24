package UserClasses1;
import DictionaryApplication.SuperType;
public class Account extends SuperType{
    private final double balance;
    private final String type;
public Account(double S0,String S1){
this.balance=S0;
this.type=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Account other = (Account) otherObj;
return this.balance==other.balance && ((this.type==null && other.type==null)||(this.type!=null && this.type.equals(other.type))) ;}
@Override
public String toString(){return super.toString() + "[" + "balance=" + balance + "," + "type=" + type.toString() + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*Double.valueOf(balance).hashCode() + 3*type.hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("error types");
Account others=(Account)other;
if(super.compareTo(other)==0 && (Double.valueOf(balance) - Double.valueOf(others.balance))==0 && (type.compareTo(others.type))==0 )
	return 0;
return (int)(super.compareTo(other) + (balance - others.balance) + type.compareTo(others.type));}}
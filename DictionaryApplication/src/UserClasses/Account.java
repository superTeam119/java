package UserClasses;
public class Account extends SuperType{
    private final Employee owner;
    private final int balance;
public Account(Employee S0,int S1){
this.owner=S0;
this.balance=S1;

}
@Override
public boolean equals(Object otherObj){
if(!super.equals(otherObj))
	return false;
Account other = (Account) otherObj;
return ((this.owner==null && other.owner==null)||(this.owner!=null && this.owner.equals(other.owner))) && this.balance==other.balance ;}
@Override
public String toString(){return super.toString() + "[" + "owner=" + owner.toString() + "," + "balance=" + balance + "]";
}
@Override
public int hashCode(){
return super.hashCode() + 2*owner.hashCode() + 3*Integer.valueOf(balance).hashCode();}
@Override
public int compareTo(SuperType other){
 if(!(other.getClass()==getClass()))
System.out.println("");
Account others=(Account)other;
if(super.compareTo(other)==0 && (owner.compareTo(others.owner))==0 && (Integer.valueOf(balance) - Integer.valueOf(others.balance))==0 )
	return 0;
return (int)(super.compareTo(other) + owner.compareTo(others.owner) + (balance - others.balance));}}
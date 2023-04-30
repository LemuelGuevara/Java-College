/*
 * Name: Guevara, Lemuel John D.
 * Section: 1CSD
 *
 * */
package MachineProblems.MP3HealthClub;

import java.io.*;
import java.util.*;

// enums
enum ProgramMenuChoices
{
    OPTION1("1. Add an Account"), OPTION2("2. Delete an Account"),
    OPTION3("3. Display an Account"), OPTION4("4. Edit an Account"),
    OPTION5("5. Search an Account"), OPTION6("6. Display Total by Payment Term"),
    OPTION7("7. Display All Accounts"), OPTION8("8. Display All Acounts");

    private final String option;
    ProgramMenuChoices(String option) {this.option = option;}
    public String getOption() {return option;}
}

enum MemberEnums
{
    REGULAR(900, 1200, 3890, 8230, 3),
    VIP(1000, 1500, 4865, 10650, 5);

    private final double miscFee, monthly, quarterly, semiAnnual, maxSupMembers;

    MemberEnums(int miscFee, int monthly, int quarterly, int semiAnnual, int maxSupMembers)
    {
        this.miscFee = miscFee;
        this.monthly = monthly;
        this.quarterly = quarterly;
        this.semiAnnual = semiAnnual;
        this.maxSupMembers = maxSupMembers;
    }

    public double getMiscFee() {return miscFee;}
    public double getMonthly() {return monthly;}
    public double getQuarterly() {return quarterly;}
    public double getSemiAnnual() {return semiAnnual;}
    public double getMaxSupMembers() {return maxSupMembers;}
}

// Interfaces
interface CollectionPrinter
{
    void showContents(List<?> list) throws Exception;
    void showContents(Map<String, ?> map) throws Exception;
}

// Utils
abstract class Utils
{
    String delimeter = " ";

    public Scanner fileScanner(String fileName) throws Exception
    {
        return new Scanner(new File(fileName));
    }

    public Scanner userInput() {return new Scanner(System.in);}

    public String[] splitString(String string, String delimeter)
    {
        return string.split(delimeter);
    }
}

class FileHandler extends Utils
{

}

class EndOfFile implements Serializable {}

class Person
{
    private String fname;
    private String lname;
    private String age;
    private String address;

    public Person() {}

    public Person(String fname, String lname, String age, String address)
    {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.address = address;
    }

    public String getFname() {return fname;}
    public void setFname(String fname) {this.fname = fname;}
    public String getLname() {return lname;}
    public void setLname(String lname) {this.lname = lname;}
    public String getAge() {return age;}
    public void setAge(String age) {this.age = age;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    @Override
    public String toString()
    {
        return getFname() + " " + getLname() + " " + getAge() + " " + getAddress();
    }
}

class Account extends Utils implements Serializable
{
    private String ID;
    private char memberType;
    private char payTerm;
    private int supMember;

    public Account() {}

    public Account(String ID, char memberType, char payTerm, int supMember)
    {
        this.ID = ID;
        this.memberType = memberType;
        this.payTerm = payTerm;
    }

    public String getID() {return ID;}
    public void setID(String ID) {this.ID = ID;}
    public char getMemberType() {return memberType;}
    public void setMemberType(char memberType) {this.memberType = memberType;}
    public char getPayTerm() {return payTerm;}
    public void setPayTerm(char payTerm) {this.payTerm = payTerm;}
    public int getSupMember() {return supMember;}
    public void setSupMember(int supMember) {this.supMember = supMember;}

    @Override
    public String toString() {

        return ID + delimeter + memberType + delimeter + payTerm + delimeter + supMember;
    }
}

public class MP3HealthClub
{
    public static void main(String[] args) throws Exception {
        File objName = new File("accounts.txt");
        ObjectOutputStream outWrite = new ObjectOutputStream(new FileOutputStream(objName));
        if(!objName.exists())
            objName.createNewFile();

        List<Object> outName = new ArrayList<>();
        outName.add(new Account("111",'O','2',1));
        outName.add(new Account("567",'L','1',0));
        outName.add(new Account("456",'O','3',2));
        outName.add(new Account("123",'L','2',1));
        outName.add(new Account("890",'O','1',1));
        outName.add(new Account("786",'L','3',1));
        outName.add(new Account("057",'O','3',2));
        outName.add(new Account("945",'L','2',1));
        outName.add(new Account("655",'O','3',3));
        outName.add(new Account("897",'L','1',1));
        outName.add(new Account("801",'O','2',2));
        outName.add(new EndOfFile());

        for (Object account : outName) outWrite.writeObject(account);
        outWrite.close();
    }
}

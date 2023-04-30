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
    // reads the given file and retunrs it as list of strings
    public String[] readFile(String fileName) throws Exception
    {
        List<String> information = new ArrayList<>();
        Scanner scanFile = fileScanner(fileName);

        while(scanFile.hasNextLine())
        {
            String line = scanFile.nextLine();
            information.add(line);
        }

        return information.toArray(new String[0]);
    }


    // Prints the contents of the file
    public void printFileContents(String[] file)
    {
        for (String line : file)
            System.out.println(line);
    }

    // Appends a string into the given file
    public void addToFile(String string, String fileName)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write("\n" + string);
            writer.close();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    //public void addToLine()

    public void deleteFromFile(String lineToDelete, String fileName) throws Exception
    {
    }
}

class EndOfFile implements Serializable {}

class FileSerializer implements Serializable
{
    public void serializeFile(String[] file, String filePath) throws Exception
    {
        FileOutputStream fileOutput = new FileOutputStream(filePath);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

        for (String string: file)
            objectOutput.writeObject(string);
        objectOutput.writeObject(new EndOfFile());
        objectOutput.close();
    }

    // deserializes a given file then puts into a string array
    public String[] deserializeFile(String fileName) throws Exception
    {
        FileInputStream fileInput = new FileInputStream(fileName);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);

        List<String> deserializedFile = new ArrayList<>();
        Object object;

        while(!((object = objectInput.readObject()) instanceof EndOfFile))
            deserializedFile.add((String) object);
        objectInput.close();

        return deserializedFile.toArray(new String[0]);
    }
}

class ObjectCollections implements CollectionPrinter
{
    @Override
    public void showContents(List<?> list) {
        for (Object object: list)
            System.out.println(object);
    }

    @Override
    public void showContents(Map<String, ?> map) {
        for (Map.Entry<String, ?> pair: map.entrySet())
            System.out.println("ID: " + pair.getKey() + " | " + "Person: " + pair.getValue());
    }
}

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

    public Map<String, Person> toMap(String[] personFile)
    {
        Map<String, Person> personMap = new HashMap<>();
        String ID, firstName, lastname, age, address;

        for (String person : personFile)
        {
            String[] personInfo = person.split(" ");
            ID = personInfo[0];
            firstName = personInfo[1];
            lastname = personInfo[2];
            age = personInfo[3];
            address = personInfo[4];

            personMap.put(ID, new Person(firstName, lastname, age, address));
        }

        return personMap;
    }

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
        this.supMember = supMember;
    }

    public String getID() {return ID;}
    public void setID(String ID) {this.ID = ID;}
    public char getMemberType() {return memberType;}
    public void setMemberType(char memberType) {this.memberType = memberType;}
    public char getPayTerm() {return payTerm;}
    public void setPayTerm(char payTerm) {this.payTerm = payTerm;}
    public int getSupMember() {return supMember;}
    public void setSupMember(int supMember) {this.supMember = supMember;}

    // Converts the given account file into a list with type Account
    public List<Account> toList(String[] accountFile)
    {
        String ID;
        char memberType;
        char paymentTerm;
        int numberOfSupMembers;

        List<Account> accounts = new ArrayList<>();

        for (String account: accountFile)
        {
            String[] accountInfo = splitString(account, delimeter);
            ID = accountInfo[0];
            memberType = accountInfo[1].charAt(0);
            paymentTerm = accountInfo[2].charAt(0);
            numberOfSupMembers = Integer.parseInt(accountInfo[3]);

            accounts.add(new Account(ID, memberType, paymentTerm, numberOfSupMembers));
        }

        return accounts;
    }

    @Override
    public String toString() {

        return ID + delimeter + memberType + delimeter + payTerm + delimeter + supMember;
    }
}

class MemberCalculator extends Utils
{
    private MemberEnums memberEnums;
    protected char paymentOption;
    protected int numberOfSupMembers;

    MemberCalculator(char memberType, char paymentOption, int numberOfSupMembers)
    {
        switch (memberType)
        {
            case 'R': this.memberEnums = MemberEnums.REGULAR; break;
            case 'V': this.memberEnums = MemberEnums.VIP; break;
        }

        this.paymentOption = paymentOption;
        this.numberOfSupMembers = numberOfSupMembers;
    }

    public double getMemberRate()
    {
        double memberRate = 0;

        if (paymentOption == 'M')
            memberRate = memberEnums.getMonthly() + (memberEnums.getMiscFee() * 12) * numberOfSupMembers;
        if (paymentOption == 'Q')
            memberRate = memberEnums.getQuarterly() + (memberEnums.getMiscFee() * 3) * numberOfSupMembers;
        if (paymentOption == 'S')
            memberRate = memberEnums.getSemiAnnual() + (memberEnums.getMiscFee() * 6) * numberOfSupMembers;
        if (paymentOption == 'C')
            memberRate = memberEnums.getMonthly() * 0.85 * 12;

        return memberRate;
    }
}

class AccountHandler extends Utils
{
    FileHandler fileHandler = new FileHandler();
    ObjectCollections objectCollection = new ObjectCollections();
    FileSerializer fileSerializer = new FileSerializer();

    Account account;
    List<Account> accountList = new ArrayList<>();
    Map<String, Person> personMap = new HashMap<>();

    private final String accountFile, personFile;

    AccountHandler(String accountFile, String personFile) throws Exception {
        this.accountFile = accountFile;
        this.personFile = personFile;
        getAccounts();
    }
    public void getAccounts() throws Exception
    {
        personMap = new Person().toMap(fileHandler.readFile(personFile));
        //accountList = new Account().toList(fileSerializer.deserializeFile(accountFile));
        accountList = new Account().toList(fileHandler.readFile(accountFile));
    }

    private String getID()
    {
        System.out.println("Enter ID:");
        return userInput().nextLine();
    }

    public void addAccount()
    {
        String ID, firstName, lastName, age, address;
        char memberType, paymentTerm;
        int numberOfSupMembers;

        System.out.println("Enter ID:");
        ID =  userInput().nextLine();
        System.out.println("Enter first name:");
        firstName = userInput().nextLine();
        System.out.println("Enter last name:");
        lastName = userInput().nextLine();
        System.out.println("Enter age:");
        age = userInput().nextLine();
        System.out.println("Enter address:");
        address = userInput().nextLine();
        System.out.println("Enter member type:");
        memberType = userInput().nextLine().charAt(0);
        memberType = Character.toUpperCase(memberType);
        System.out.println("Enter payment term:");
        paymentTerm = userInput().nextLine().charAt(0);
        paymentTerm = Character.toUpperCase(paymentTerm);
        System.out.println("Enter number of supplementary members:");
        numberOfSupMembers = userInput().nextInt();

        // Add to person class
        Person person = new Person(firstName, lastName, age, address);
        // Add to account class
        account = new Account(ID, memberType, paymentTerm, numberOfSupMembers);

        // add to file
        fileHandler.addToFile(ID + " " + person, personFile);
        fileHandler.addToFile(String.valueOf(account), accountFile);

        //fileSerializer.serializeFile(fileHandler.readFile(accountFile), accountFile);
    }

    public void deleteAccount() throws Exception {
        String ID;
        int index = 0;

        System.out.println("Enter ID:");
        ID = userInput().nextLine();

        // Deleting the account
        while (index < accountList.size())
        {
            Account account = accountList.get(index);
            String accountString = String.valueOf(account);

            if (account.getID().equals(ID))
            {
                accountList.remove(index);
                fileHandler.deleteFromFile(accountString, accountFile);
            }

            else
                ++index;
        }

        // Deleting the person
//        for (Map.Entry<String, Person> person: personMap.entrySet())
//        {
//            if (person.getKey().equals(ID))
//                personMap.remove(person.getKey());
//
//        }
    }

    public void displayPersonInfo()
    {
        objectCollection.showContents(personMap);
    }

    public void displayAccount()
    {
        String ID;
        System.out.println("Enter ID:");
        ID = userInput().nextLine();
        MemberCalculator membershipFee ;

        for (Account account: accountList)
        {
            membershipFee = new MemberCalculator(account.getMemberType(), account.getPayTerm(), account.getSupMember());

            if (account.getID().equals(ID))
                System.out.println(account + " " + membershipFee.getMemberRate());
        }
    }

    public void editAccount()
    {
        String ID = getID();
        System.out.println("Enter information to edit: ");
        String info = userInput().nextLine();
        info = info.toUpperCase();

        for (Map.Entry<String, Person> person: personMap.entrySet())
        {
            if (person.getKey().equals(ID))
            {
                if (info.equals("A"))
                {
                    System.out.println("Enter first name: ");
                    person.getValue().setFname(userInput().nextLine());
                }

                if (info.equals("B"))
                {
                    System.out.println("Enter last name: ");
                    person.getValue().setLname(userInput().nextLine());
                }

                if (info.equals("C"))
                {
                    System.out.println("Enter age:");
                    person.getValue().setAge(userInput().nextLine());
                }

                if (info.equals("D"))
                {
                    System.out.println("Enter address:");
                    person.getValue().setAddress(userInput().nextLine());
                }
            }
        }

        for (Account account: accountList)
        {
            if (account.getID().equals(ID))
            {
                if (info.equals("E"))
                {
                    System.out.println("Enter member type: ");
                    account.setMemberType(userInput().next().charAt(0));
                }

                if (info.equals("F"))
                {
                    System.out.println("Enter payment term: ");
                    account.setPayTerm(userInput().nextLine().charAt(0));
                }

                if (info.equals("G"))
                {
                    System.out.println("Enter number of supplementary members:");
                    account.setSupMember(userInput().nextInt());
                }
            }
            System.out.println(account);
        }
    }
}

class Program extends Utils
{
    String personsFileName = "mapMP3.txt";
    String accountFileName = "acct.txt";

    AccountHandler accountHandler = new AccountHandler(accountFileName, personsFileName);

    Program() throws Exception {}

    private void showChoices()
    {
        for (ProgramMenuChoices choice: ProgramMenuChoices.values())
            System.out.println(choice.getOption());
    }

    private void getChoice() throws Exception
    {
        FileSerializer fileSerializer = new FileSerializer();

        int choice;

        System.out.println("Enter choice:");
        choice = userInput().nextInt();
        System.out.println(choice);

        switch (choice)
        {
            case 1:
                accountHandler.addAccount();
                break;
            case 2:

                accountHandler.deleteAccount();
                break;
            case 3:
                accountHandler.displayAccount();
                break;
            case 4:
                accountHandler.editAccount();
                accountHandler.displayPersonInfo();
                accountHandler.displayAccount();
                break;
        }
    }

    public void initializeProgram() throws Exception
    {
        showChoices();
        getChoice();
    }
}

public class MP3HealthClub
{
    public static void main(String[] args) throws Exception {
        Program program = new Program();
        program.initializeProgram();
    }
}

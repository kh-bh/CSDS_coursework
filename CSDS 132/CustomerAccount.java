// Bhoomika Khatri

// This is a class that models a customer account and having multiple plans
public class CustomerAccount {
  
  // A field that stores the name on the account
  private String name;
  
  // A field that stores the address on the account
  private String address;
  
  // A field that stores the account (1st and 2nd)
  private PhoneAccount phoneAccount;
  
  // A field that stores the current cash balance 
  private double amount;
  
  // A constructor that initializes the account and address on this account
  public CustomerAccount(String name, String address) {
    this.name = name;
    this.address = address;
  }
  
  // A method that sets the name on the account to the value it needs (name)
  public void setName(String name) {
    this.name = name;
  }
  
  // A method that returns what the name on the account is
  public String getName() {
    return this.name;
  }
  
  // A method that sets what the address of the person who uses the account is
  public void setAddress(String address) {
    this.address = address;
  }
  
  // A method that returns what the address that the person who holds the account is
  public String getAddress() {
    return this.address;
  }
  
  // A method that sets the first phone account
  public void setPhoneAccount1(PhoneAccount phoneAccount) {
    this.phoneAccount = phoneAccount;
  }
  
  // A method that gets what the value of the first phone account is
  public PhoneAccount getPhoneAccount1(){
    return phoneAccount;
  }
  
  // A method that sets the second phone account
  public void setPhoneAccount2(PhoneAccount phoneAccount) {
    this.phoneAccount = phoneAccount;
  }
  
  // A method that gets what the value of the second phone account is
  public PhoneAccount getPhoneAccount2(){
    return phoneAccount;
  }
  
  // A method that returns the cash balance of the account
  public double getCashBalance(){
    this.amount = amount;
    return amount;
  }
  
  // A method that sets the cash amount
  public void decreaseBalance(double amount){
    amount = amount - this.amount;
  }
  
  // A method that sets what happens after the end of the month
  public void processEndOfMonth(){
    if (2.5 > amount) {  // the original that I tried (phoneAccount.getMonthlyCharge() > amount) {
      phoneAccount.startMonth();
    }
    else{
      phoneAccount.setActivated(false);
    }
  }
  
  // A method that sets the increase of balance
  public void increaseBalance(double amount) {
    if (phoneAccount == null) {
      amount += amount;
    }
    else {
      phoneAccount.setActivated(true);
    }
  }
  
}

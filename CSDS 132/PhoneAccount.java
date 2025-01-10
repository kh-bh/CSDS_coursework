// Bhoomika Khatri

// A class that sets a Phone account for each persons phone plan
public class PhoneAccount {
  
  // A field that stores the phone number for the account  
  private String phonePlan;
  
  // A field that stores what plan Name the customer would have
  private PhonePlan planName;
  
  // A field that stores whether the phone is active in (true/false)
  private boolean activate = false;
  
  // A field that stores the number of minutes that the phone number was on call for
  private int minutesNumber;
  
  // A field that stores the number of messages that the phone number sends
  private int messageBalance;
  
  // A field that stores the megabytes sent by the number of the phoneplan
  private int dataBalance;
  
  // A field that stores the customer account for the customer
  private CustomerAccount customerName;
  
  /* A constructor that sets the phone number and plan
   * This wouldn't compile so I wasn't able to test this, but it doesn't work
   * I'm pretty sure it doesn't work because a variable was misset, but I rewrote it two
   * other times and wasn't able to make it work.
  *public PhoneAccount(String phoneNumber, PhonePlan phonePlan) {
    *this.phoneNumber = planName;
    *this.phonePlan = phonePlan;
  *}
  */
  
  // A method that will return what the Phone number for the account is
  public String getPhoneNumber() {
    this.phonePlan = phonePlan;
    return phonePlan;
  }
  
  // A method that will return the phone plan used on this plan
  public PhonePlan getPhonePlan() {
    return planName;
  }
  
  //A method that changes the Phone Plan used with this phone
  public void setPhonePlan(PhonePlan phonePlan) {
    this.planName = phonePlan;
  }
  
  // A method that will return true or false depending on the phone account status
  public boolean isActivated(){
    return this.activate;
  }
  
  // A method that sets whether the phone is active or not
  public void setActivated(boolean activate) {
    this.activate = activate;
  }
  
  // A method that gets the number of minutes the phone number made
  public int getMinuteBalance() {
    return this.minutesNumber;
  }
  
  // A method that gets the number of texts made by the phone number
  public int getMessageBalance(){
    return this.messageBalance;
  }
  
  // A method that returns the amount of megabytes downloaded by the Phone
  public int getDataBalance() {
    return this.dataBalance;
  }
  
  // A method that sets the minutes, texts, and megabytes, to 0!
  public void startMonth() {
    this.dataBalance = 0;
    this.messageBalance = 0;
    this.minutesNumber = 0;
  }
  
  // A method that simulates being able to send (or not send) a text message
  public boolean sendTextMessage(boolean isRoaming) { 
    if (getPhonePlan() == null) {
      return false;
    }
    else if (planName.allowRoaming() == false && isRoaming == true) {
      return false;
    }
    else {
      if (messageBalance < planName.getMessageLimit()) {
        return false;
      }
      else {
        planName.setMessageRate(+1);
        return true;
      }
    }         
  }
  
  // A method that simulates downloading data to the phone with true + false
  public boolean useData (int megabytes, boolean isRoaming) {
    if (getPhonePlan() == null) {
      return false;
    }
    else if (planName.allowRoaming() == false && isRoaming == true) {
      return false;
    }
    else {
      if ((megabytes + dataBalance) < planName.getDataLimit()) {
        dataBalance += megabytes;
        return true;
      }
      else {
        return false;
      }
    }
  }
  
  // A method that figures out whether the call is roaming or not
  public int makeCall(int minutes, boolean isRoaming) {
    if ((minutes + minutesNumber) <= planName.getMinuteLimit()) {
      minutesNumber += minutes;
      return minutes;
    }
    else {
      return minutes;
    }
  }
  
  // A method that sets the customer account for this phone account
  public void setCustomerAccount (CustomerAccount customer) {
    this.customerName = customer;
  }
  
  // A method that gets what the customer Account is
  public CustomerAccount getCustomer() {
    return customerName;
  }
}
// Bhoomika Khatri

// A class to represent the features of a phone plan by month, as well as if roaming is allowed 
public class PhonePlan {
  
  // A field that stores the monthly charge
  private double monthlyCharge;
  
  // A field that stores the minutes avalible per month
  private int minuteLimit;
  
  // A field that stores the messages allowed to be sent per month
  private int messageLimit;
  
  // A field that stores the megabytes that can be downloaded on this phone plan
  private int megabyteLimit;
  
  // A field that stores the amount charged after each minute has passed past the alloted amount on the plan
  private double minuteRate;
  
  // A field that stores the amount charges after each text sent over the limit
  private double messageRate;
  
  // A field that stores the charge for each megabyte past the download rate
  private double downloadRate;
  
  // A field that stores whether a phone can or cannot use roaming charges
  private boolean allowRoaming;
  
  // A field that stores the charge for a roaming call when not allowed a roaming phone call
  private double roamingRate;
  
  // A constructor that sets what variables a new phone plan needs and the order it uses it
  public PhonePlan(double monthlyCharge, int monthlyMinuteLimit, int monthlyMessageLimit, 
                   int monthlyDataLimit, double minuteRate, double messageRate, double dataRate, 
                   boolean allowRoaming, double roamingRate) {
    this.monthlyCharge = monthlyCharge;
    this.minuteLimit = monthlyMinuteLimit;
    this.messageLimit = monthlyMessageLimit;
    this.megabyteLimit = monthlyDataLimit;
    this.minuteRate = minuteRate;
    this.messageRate = messageRate;
    this.downloadRate = dataRate;
    this.allowRoaming = allowRoaming;
    this.roamingRate = roamingRate;
  }
  
  // A method that gets the monthly charge of the phone plan
  public double getMonthlyCharge() {
    return this.monthlyCharge;
  }
  
  // A method that sets what the monthly charge of the phone plan will be
  public void setMonthlyCharge(double monthlyCharge) {
    this.monthlyCharge = monthlyCharge;
  }
  
  // A method that gets the amount of minutes left in the phone plan
  public int getMinuteLimit() {
    return this.minuteLimit;
  }
  
  // A method that sets what the amount of minutes left in the phone plan is
  public void setMinuteLimit(int minuteLimit) {
    this.minuteLimit = minuteLimit;
  }
  
  // A method that gets the number of messages allowed to be sent per month on the phone plan
  public int getMessageLimit() {
    return this.messageLimit;
  }
  
  // A method that sets what the messages allowed to be sent per month are in the phone plan is
  public void setMessageLimit(int messageLimit) {
    this.messageLimit = messageLimit;
  }
  
  // A method that gets the data limit that the phone plan allows (megabyte downloaded)
  public int getDataLimit() {
    return this.megabyteLimit;
  }
  
  // A method that sets the data limit that the phone plan can use (megabyte downloaded)
  public void setDataLimit(int megabyteLimit) {
    this.megabyteLimit = megabyteLimit;
  }
  
  // A method that gets the amount charged per minute when a phone call goes beyond what the phone plan allows
  public double getMinuteRate() {
    return this.minuteRate;
  }
  
  // A method that sets the amount charged per minute when a phone call goes beyond what the phone plan allows
  public void setMinuteRate(double minuteRate) {
    this.minuteRate = minuteRate;
  }
  
  // A method that sets the amount charged per text sent over the allotted amount
  public double getMessageRate() {
    return this.messageRate;
  }
  
  // A method that gets the amount charged per text message sent over the limit set by plan
  public void setMessageRate(double messageRate) {
    this.messageRate = messageRate;
  }
  
  // A method that sets the amount charged per megabyte download over (this is over, last one was base)
  public double getDataRate() {
    return this.downloadRate;
  }
  
  // A method that gets the amount charges per megabyte download past the amount allotted
  public void setDataRate(double downloadRate) {
    this.downloadRate = downloadRate;
  }
  
  // A method that returns true or false for if the the phone can use roaming data
  public boolean allowRoaming(){
    return this.allowRoaming;
  }
  
  // A method that gets the true or false value for if the phone can use roaming data
  public void setAllowRoaming(boolean allowRoaming) {
    this.allowRoaming = allowRoaming;
  }
  
  // A method that sets the amount charged per minute for a roaming phone call (when not allowed roaming)
  public double getRoamingRate() {
    return this.roamingRate;
  }
  // A method that gets the amount charged per minute for a roaming phone call
  public void setRoamingRate(double roamingRate) {
    this.roamingRate = roamingRate;
  }
}

package modules;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void validateFirstName(){
        if(this.firstName.isBlank()){
            throw new RuntimeException("First Name cannot be blank");
        }
    }
    public void validateLastName(){
        if(this.lastName.isBlank()){
            throw new RuntimeException("Last Name cannot be blank");
        }
    }

    public void validatePhoneNumber(){
        if(this.phoneNumber.length()!=10){
            throw new RuntimeException("Phone number should be 10 digits long");
        }
        if(this.phoneNumber.isBlank()){
            throw new RuntimeException("Phone number cannot be blank");
        }
        if(!this.phoneNumber.startsWith("0")){
            throw new RuntimeException("Phone number should start with 0");
        }
        for(int i=0;i<10;i++){
            if(this.phoneNumber.charAt(i)<'0' && this.phoneNumber.charAt(i)>'9'){
                throw new RuntimeException("Phone number should be digits");
            }
        }
    }
}

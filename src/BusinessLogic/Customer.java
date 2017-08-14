package BusinessLogic;


public class Customer extends Account
{
    private String phoneNumber;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    private Order order;

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public boolean setPhoneNumber(String phoneNumber)
    {
        if(phoneNumber.length() == 13 && phoneNumber.charAt(0) == '+')
        {
            for (int i = 1; i < phoneNumber.length(); i++)
            {
                if(phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9')
                {
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }

    public Customer(String name, String surname, int ID, String phoneNumber, String password)
    {
        super(name, surname, ID);
        setPassword(password);
        setPhoneNumber(phoneNumber);
    }


    public void createOrder(Order o){
        this.order = o;
    }

    public void makeOrder(){
        //sent order to a server;
        while(true){
            checkOrderStatus();
        }
    }

    public void checkOrderStatus(){
        //go to database or a server and check for the order's status
    }
}

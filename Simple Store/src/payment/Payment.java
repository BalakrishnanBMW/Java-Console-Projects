package payment;

import order.Order;

import java.util.Date;

public class Payment {


    private String PaymentMethod;
    private int paymentId;
    private Order order;
    Date date = new Date();
    static int id = 1;
    private String paymentMethod;

    public Payment(Order order, String paymentMethod) {
        this.setPaymentId(id++);
        this.setOrder(order);
        this.setPaymentMethod(paymentMethod);
    }


    public int getPaymentId() {
        return paymentId;
    }

    private void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String toString() {
        return "\n\t--- Payment Detail ---\n\nDate : "+this.date +
                "\nPayment Mode : " +this.paymentMethod +
                "\n\nProduct Name : "+this.order.getProductName() +
                "\nPrice per Unit : "+ this.order.getPricePerUnit() +
                "\nNumber of Units : "+ this.order.getCount() +
                "\nTotal price : "+ this.order.getPricePerUnit() * this.order.getCount() +
                "\n\nBuyer : "+this.order.getPayer().getName() +
                "\nBuyer Mail : "+this.order.getPayer().getMail() +
                "\nBuyer Address : "+this.order.getPayer().getAddress() +
                "\n\nSeller : " + this.order.getPayee().getName() +
                "\nSeller Mail : "+this.order.getPayee().getMail() +
                "\nSeller Address : "+this.order.getPayee().getAddress() +
                "\n\n Order Status : Delivered \nPaid Amount : "+this.order.getPricePerUnit() * this.order.getCount() +
                "\n\t----------";
    }

}

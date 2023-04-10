package com.admin.pojo;

public class TransportOrders {

    private int transporterOrderId;
    private int transporterId;
    private int serviceId;
    private String pickUpLocation;
    private String deliverylocation;
    private String orderStatus;


    public TransportOrders(int transporterOrderId, int transporterId, int serviceId, String pickUpLocation, String deliverylocation, String orderStatus) {
        this.transporterOrderId = transporterOrderId;
        this.transporterId = transporterId;
        this.serviceId = serviceId;
        this.pickUpLocation = pickUpLocation;
        this.deliverylocation = deliverylocation;
        this.orderStatus = orderStatus;
    }

    public TransportOrders() {
    }

    public int getTransporterOrderId() {
        return transporterOrderId;
    }

    public int getTransporterId() {
        return transporterId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDeliverylocation() {
        return deliverylocation;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setTransporterOrderId(int transporterOrderId) {
        this.transporterOrderId = transporterOrderId;
    }

    public void setTransporterId(int transporterId) {
        this.transporterId = transporterId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setDeliverylocation(String deliverylocation) {
        this.deliverylocation = deliverylocation;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

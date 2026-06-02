package com.rishahtech.worldpay.round2;

import java.util.List;

interface PaymentStep {
    void execute(Order order);

    default void compensate(Order order) {
        // Optional rollback logic
    }
}

class Order {
}

class ValidateUser implements PaymentStep {

    @Override
    public void execute(Order order) {
        System.out.println("Validating User");
    }

    @Override
    public void compensate(Order order) {
        System.out.println("Rollback User Validation");
    }
}

class InventoryStep implements PaymentStep {

    @Override
    public void execute(Order order) {
        System.out.println("Reserving Inventory");
    }

    @Override
    public void compensate(Order order) {
        System.out.println("Release Inventory");
    }
}

class PaymentProcessingStep implements PaymentStep {

    @Override
    public void execute(Order order) {
        System.out.println("Processing Payment");
    }

    @Override
    public void compensate(Order order) {
        System.out.println("Refund Payment");
    }
}

class NotificationStep {

    public void send(Order order) {
        System.out.println("Sending Failure Notification");
    }
}

class Orchestration {

    private final List<PaymentStep> steps;
    private final NotificationStep notificationStep;

    public Orchestration(List<PaymentStep> steps,
                         NotificationStep notificationStep) {
        this.steps = steps;
        this.notificationStep = notificationStep;
    }

    public void process(Order order) {

        try {
            for (PaymentStep step : steps) {
                step.execute(order);
            }

            System.out.println("Order Processed Successfully");

        } catch (Exception ex) {

            System.out.println("Workflow Failed");

            notificationStep.send(order);

            // Compensation logic can be added here
        }
    }
}

public class MainClient {

    public static void main(String[] args) {

        Order order = new Order();

        Orchestration orchestration = new Orchestration(
                List.of(
                        new ValidateUser(),
                        new InventoryStep(),
                        new PaymentProcessingStep()
                ),
                new NotificationStep()
        );

        orchestration.process(order);
    }
}
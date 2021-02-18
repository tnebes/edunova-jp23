package dataHandler;

import dataClasses.Status;

public class StatusHandler {

    public static Status getStatusByID(byte id) {
        for (Status status : Controller.getStatuses()) {
            if (status.getId() == id) {
                return status;
            }
        }
        System.out.printf("Status with id %d not found.\n", id);
        return null;
    }

    public static Status getLastStatus() {
        return Controller.getStatuses().get(Controller.getStatuses().size() - 1);
    }

    public static void showStatuses() {
        for (Status status : Controller.getStatuses()) {
            System.out.println(status.toString());
        }
    }
}

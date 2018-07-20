package models;

public enum TicketPriority {
    HIGHPRIORITY("High-Priority"), LOWPRIORITY("Low-Priority");

    private String name;

    TicketPriority(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    private static final String PRIORITY_HIGHPRIORITY = "HIGHPRIORITY";
    private static final String PRIORITY_LOWPRIORITY = "LOWPRIORITY";

    public static TicketPriority fromName(String name) {
        switch (name) {
            case PRIORITY_HIGHPRIORITY:
                return HIGHPRIORITY;
            case PRIORITY_LOWPRIORITY:
                return LOWPRIORITY;
            default:
                return null;
        }
    }
}

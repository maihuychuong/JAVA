package store.service;

public enum OrderStatus {
    PENDING("Chờ xử lý"),
    PENDING_PAID("Đã thanh toán"),
    SHIPPED("Hàng đang được giao"),
    CANCELED("Đã hủy");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

package de.tum.in.ase.eist.util;

public class CustomerSortingOptions {
    private SortingOrder sortingOrder = SortingOrder.ASCENDING;
    private SortField sortField = SortField.ID;

    public CustomerSortingOptions() {}

    public CustomerSortingOptions(SortField sortField) {
        this.sortField = sortField;
    }

    public CustomerSortingOptions(SortingOrder sortingOrder, SortField sortField) {
        this.sortingOrder = sortingOrder;
        this.sortField = sortField;
    }

    public SortingOrder getSortingOrder() {
        return sortingOrder;
    }

    public void setSortingOrder(SortingOrder sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
    }

    public enum SortingOrder {
        ASCENDING, DESCENDING
    }

    public enum SortField {
        ID, FIRST_NAME, LAST_NAME, BIRTHDAY
    }
}
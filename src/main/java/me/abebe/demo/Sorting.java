package me.abebe.demo;

public enum Sorting {
    TOP("top"),
    LATEST("latest"),
    POPULAR("popular");

    private final String method;

    Sorting(final String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}

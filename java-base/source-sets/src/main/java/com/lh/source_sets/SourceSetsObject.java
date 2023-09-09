package com.lh.source_sets;

/**
 * @author lh
 */
public class SourceSetsObject {
    private final String user;
    private final String password;

    public SourceSetsObject(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "SourceSetsObject{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package ru.jvst.stepik.functionalprogramming;

import java.util.*;

class PrintLoginQuiz {

    public static void main(String[] args) {
        Account account1 = new Account("Account1", "pro");
        Account account2 = new Account("Account2", "pro");
        Account account3 = new Account("Account3", "simple");
        Set usersSet = new HashSet();
        usersSet.add(new User("User1", account1));
        usersSet.add(new User("User2", account2));
        usersSet.add(new User("User3", account3));
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account1");//print User1
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account3");//doesn't print anything
        PrintLoginQuiz.printLoginIfPro(usersSet, "Account22");//doesn't print anything
    }
    public static void printLoginIfPro(Set<User> users, String id) {
        users.stream()
                .filter(user -> user.getAccount()
                        .filter(account -> account.getType().equals("pro"))
                        .map(Account::getId)
                        .map(id::equals)
                        .orElse(false))
                .map(User::getLogin)
                .forEach(System.out::println);
    }
}

class Account {
    private String id;
    private String type;

    public Account(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

class User {
    private String login;
    private Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }
}
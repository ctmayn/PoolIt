package com.mysampleapp.demo.poolit;

import com.amazonaws.models.nosql.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> friends;
    private String name;
    private List<String> events;
    private int score;
    private String userID;
    private String accountID;

    public User(String name) {
        friends = new ArrayList<String>();
        this.name = name;
        events = new ArrayList<String>();
        score = 0;
    }
    
    public User(UsersDO i) {
        this.name = i.getName();
        friends = new ArrayList<String>();
        for (int j = 0; j < i.getFriends().size(); j++) {
            friends.add(i.getFriends().get(j).getAccountId());
        }
        events = new ArrayList<String>();
        for (int j = 0; j < i.getEvents().size(); j++) {
            events.add(i.getEvents().get(j).getUserId());
        }
        this.score = i.getScore();
        this.userID = i.getUserId();
        this.accountID = i.getAccountId();
    }

    /**
     * Returns the list of friends associated with this user
     * @return The friends attached to this account
     */
    public List<String> getFriends() { return friends; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getEvents() { return events; }
    /*public void addEvent(String name, String info, double target, Date date, User[] members) {
        Event e = new Event(name, info, target, this, date); // Fill in relevant info
        for (User u : members) {
            e.addPending(u);
        }
        String id = e.getID();
        events.add(id);

        // Push event to server, add event to server's copy of each member's copy of "events"
        Server.getInstance().addEvent(e);
    }*/

    public void incrementScore(int i) { score += i; }


    public String getID() { return userID; }

    public void setID(String userID) { this.userID = userID; }

    public int getScore() { return score; }


    public void sync() {
        // Find server's copy of this User, sync values
    }

    public String getAccountID(){
        return accountID;
    }

    public void removeFriend(User friend){
        String id = friend.getID();
        for(String i: friends){
            if(id == i){
                friends.remove(i);
            }
        }
    }
}

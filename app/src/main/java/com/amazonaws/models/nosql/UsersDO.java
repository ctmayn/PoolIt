package com.amazonaws.models.nosql;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "poolit-mobilehub-8986227-Users")

public class UsersDO {
    private String _userId;
    private String _accountId;
    private List<EventsDO> _events;
    private List<UsersDO> _friends;
    private String _name;
    private int _score;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "accountId")
    public String getAccountId() {
        return _accountId;
    }

    public String setAccountId(final String _accountId) {
        this._accountId = _accountId;
        return _accountId;
    }
    @DynamoDBAttribute(attributeName = "events")
    public List<EventsDO> getEvents() {
        return _events;
    }

    public void setEvents(final List<EventsDO> _events) {
        this._events = _events;
    }
    @DynamoDBAttribute(attributeName = "friends")
    public List<UsersDO> getFriends() {
        return _friends;
    }

    public void setFriends(final List<UsersDO> _friends) {
        this._friends = _friends;
    }
    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return _name;
    }

    public void setName(final String _name) {
        this._name = _name;
    }
    @DynamoDBAttribute(attributeName = "score")
    public int getScore() {
        return _score;
    }

    public void setScore(final int _score) {
        this._score = _score;
    }

}

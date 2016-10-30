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

@DynamoDBTable(tableName = "poolit-mobilehub-8986227-Events")

public class EventsDO {
    private String _userId;
    private List<String> _contributors;
    private Double _currentAmount;
    private List<String> _members;
    private List<String> _pending;
    private Double _target;
    private String _title;
    private List<Double> _contributions;
    private UsersDO _owner;
    private String _details;

    @DynamoDBHashKey(attributeName = "userId")

    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }
    public void setUserId(final String _userId) {
        this._userId = _userId;
    }

    @DynamoDBAttribute(attributeName = "contributors")
    public List<String> getContributors() {
        return _contributors;
    }
    public void setContributors(final List<String> _contributors) {
        this._contributors = _contributors;
    }

    @DynamoDBAttribute(attributeName = "currentAmount")
    public Double getCurrentAmount() {
        return _currentAmount;
    }
    public void setCurrentAmount(final Double _currentAmount) {
        this._currentAmount = _currentAmount;
    }

    @DynamoDBAttribute(attributeName = "members")
    public List<String> getMembers() {
        return _members;
    }
    public void setMembers(final List<String> _members) {
        this._members = _members;
    }

    @DynamoDBAttribute(attributeName = "pending")
    public List<String> getPending() {
        return _pending;
    }
    public void setPending(final List<String> _pending) {
        this._pending = _pending;
    }

    @DynamoDBAttribute(attributeName = "constributions")
    public List<Double> getContributions() {
        return _contributions;
    }
    public void set_contributions(final List<Double> _contributions) {
        this._contributions = _contributions;
    }

    @DynamoDBAttribute(attributeName = "target")
    public Double getTarget() {
        return _target;
    }
    public void setTarget(final Double _target) {
        this._target = _target;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return _title;
    }
    public void setTitle(final String _title) {this._title = _title;}

    @DynamoDBAttribute(attributeName = "details")
    public String getDetails() {
        return _details;
    }
    public void setDetails(final String _details) {
        this._details = _details;
    }


    @DynamoDBAttribute(attributeName = "owner")
    public void setOwner(final UsersDO _owner) { this._owner = _owner;}
    public UsersDO getOwner() {
        return _owner;
    }

}

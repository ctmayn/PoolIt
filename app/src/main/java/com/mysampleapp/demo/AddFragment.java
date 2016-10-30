package com.mysampleapp.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.models.nosql.UsersDO;
import com.mysampleapp.demo.nosql.DemoNoSQLTableUsers;

/**
 * Created by Christopher on 10/30/2016.
 */

public class AddFragment extends Fragment {

    public static boolean thing = false;
    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void addFriend(String name) {
        final DynamoDBMapper dynamoDBMapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();
        final UsersDO user = new UsersDO();
        thing = true;

        DemoConfiguration.tableDB.insertSampleData();
    }
}

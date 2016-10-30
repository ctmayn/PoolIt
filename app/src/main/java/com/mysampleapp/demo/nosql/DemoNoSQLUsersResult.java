package com.mysampleapp.demo.nosql;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.models.nosql.UsersDO;

import java.util.Set;

public class DemoNoSQLUsersResult implements DemoNoSQLResult {
    private static final int KEY_TEXT_COLOR = 0xFF333333;
    private final UsersDO result;

    DemoNoSQLUsersResult(final UsersDO result) {
        this.result = result;
    }
    @Override
    public void updateItem() {
        final DynamoDBMapper mapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();
        final String originalValue = result.setAccountId(AWSMobileClient.defaultMobileClient().getIdentityManager().getCachedUserID());
        result.setAccountId(DemoSampleDataGenerator.getRandomSampleString("bankInfo"));
        try {
            mapper.save(result);
        } catch (final AmazonClientException ex) {
            // Restore original data if save fails, and re-throw.
            result.setAccountId(originalValue);
            throw ex;
        }
    }

    @Override
    public void deleteItem() {
        final DynamoDBMapper mapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();
        mapper.delete(result);
    }

    private void setKeyTextViewStyle(final TextView textView) {
        textView.setTextColor(KEY_TEXT_COLOR);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(dp(5), dp(2), dp(5), 0);
        textView.setLayoutParams(layoutParams);
    }

    /**
     * @param dp number of design pixels.
     * @return number of pixels corresponding to the desired design pixels.
     */
    private int dp(int dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
    private void setValueTextViewStyle(final TextView textView) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(dp(15), 0, dp(15), dp(2));
        textView.setLayoutParams(layoutParams);
    }

    private void setKeyAndValueTextViewStyles(final TextView keyTextView, final TextView valueTextView) {
        setKeyTextViewStyle(keyTextView);
        setValueTextViewStyle(valueTextView);
    }

    private static String bytesToHexString(byte[] bytes) {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("%02X", bytes[0]));
        for(int index = 1; index < bytes.length; index++) {
            builder.append(String.format(" %02X", bytes[index]));
        }
        return builder.toString();
    }

    private static String byteSetsToHexStrings(Set<byte[]> bytesSet) {
        final StringBuilder builder = new StringBuilder();
        int index = 0;
        for (byte[] bytes : bytesSet) {
            builder.append(String.format("%d: ", ++index));
            builder.append(bytesToHexString(bytes));
            if (index < bytesSet.size()) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    @Override
    public View getView(final Context context, final View convertView, int position) {
        final LinearLayout layout;
        final TextView resultNumberTextView;
        final TextView userIdKeyTextView;
        final TextView userIdValueTextView;
        final TextView bankInfoKeyTextView;
        final TextView bankInfoValueTextView;
        final TextView eventsKeyTextView;
        final TextView eventsValueTextView;
        final TextView friendsKeyTextView;
        final TextView friendsValueTextView;
        final TextView passwordKeyTextView;
        final TextView passwordValueTextView;
        final TextView scoreKeyTextView;
        final TextView scoreValueTextView;
        if (convertView == null) {
            layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            resultNumberTextView = new TextView(context);
            resultNumberTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            layout.addView(resultNumberTextView);


            userIdKeyTextView = new TextView(context);
            userIdValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(userIdKeyTextView, userIdValueTextView);
            layout.addView(userIdKeyTextView);
            layout.addView(userIdValueTextView);

            bankInfoKeyTextView = new TextView(context);
            bankInfoValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(bankInfoKeyTextView, bankInfoValueTextView);
            layout.addView(bankInfoKeyTextView);
            layout.addView(bankInfoValueTextView);

            eventsKeyTextView = new TextView(context);
            eventsValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(eventsKeyTextView, eventsValueTextView);
            layout.addView(eventsKeyTextView);
            layout.addView(eventsValueTextView);

            friendsKeyTextView = new TextView(context);
            friendsValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(friendsKeyTextView, friendsValueTextView);
            layout.addView(friendsKeyTextView);
            layout.addView(friendsValueTextView);

            passwordKeyTextView = new TextView(context);
            passwordValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(passwordKeyTextView, passwordValueTextView);
            layout.addView(passwordKeyTextView);
            layout.addView(passwordValueTextView);

            scoreKeyTextView = new TextView(context);
            scoreValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(scoreKeyTextView, scoreValueTextView);
            layout.addView(scoreKeyTextView);
            layout.addView(scoreValueTextView);
        } else {
            layout = (LinearLayout) convertView;
            resultNumberTextView = (TextView) layout.getChildAt(0);

            userIdKeyTextView = (TextView) layout.getChildAt(1);
            userIdValueTextView = (TextView) layout.getChildAt(2);

            bankInfoKeyTextView = (TextView) layout.getChildAt(3);
            bankInfoValueTextView = (TextView) layout.getChildAt(4);

            eventsKeyTextView = (TextView) layout.getChildAt(5);
            eventsValueTextView = (TextView) layout.getChildAt(6);

            friendsKeyTextView = (TextView) layout.getChildAt(7);
            friendsValueTextView = (TextView) layout.getChildAt(8);

            passwordKeyTextView = (TextView) layout.getChildAt(9);
            passwordValueTextView = (TextView) layout.getChildAt(10);

            scoreKeyTextView = (TextView) layout.getChildAt(11);
            scoreValueTextView = (TextView) layout.getChildAt(12);
        }

        resultNumberTextView.setText(String.format("#%d", + position+1));
        userIdKeyTextView.setText("userId");
        userIdValueTextView.setText(result.getUserId());
        bankInfoKeyTextView.setText("bankInfo");
        bankInfoValueTextView.setText(result.getAccountId());
        eventsKeyTextView.setText("events");
        eventsValueTextView.setText(result.getEvents().toString());
        friendsKeyTextView.setText("friends");
        friendsValueTextView.setText(result.getFriends().toString());
        passwordKeyTextView.setText("password");
        passwordValueTextView.setText(result.getName());
        scoreKeyTextView.setText("score");
        scoreValueTextView.setText("" + result.getScore());
        return layout;
    }
}

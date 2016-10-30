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
import com.amazonaws.models.nosql.EventsDO;

import java.util.Set;

public class DemoNoSQLEventsResult implements DemoNoSQLResult {
    private static final int KEY_TEXT_COLOR = 0xFF333333;
    private final EventsDO result;

    DemoNoSQLEventsResult(final EventsDO result) {
        this.result = result;
    }
    @Override
    public void updateItem() {
        final DynamoDBMapper mapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();
        final double originalValue = result.getCurrentAmount();
        result.setCurrentAmount(DemoSampleDataGenerator.getRandomSampleNumber());
        try {
            mapper.save(result);
        } catch (final AmazonClientException ex) {
            // Restore original data if save fails, and re-throw.
            result.setCurrentAmount(originalValue);
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
        final TextView contributorsKeyTextView;
        final TextView contributorsValueTextView;
        final TextView currentAmountKeyTextView;
        final TextView currentAmountValueTextView;
        final TextView membersKeyTextView;
        final TextView membersValueTextView;
        final TextView targetKeyTextView;
        final TextView targetValueTextView;
        final TextView titleKeyTextView;
        final TextView titleValueTextView;
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

            contributorsKeyTextView = new TextView(context);
            contributorsValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(contributorsKeyTextView, contributorsValueTextView);
            layout.addView(contributorsKeyTextView);
            layout.addView(contributorsValueTextView);

            currentAmountKeyTextView = new TextView(context);
            currentAmountValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(currentAmountKeyTextView, currentAmountValueTextView);
            layout.addView(currentAmountKeyTextView);
            layout.addView(currentAmountValueTextView);

            membersKeyTextView = new TextView(context);
            membersValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(membersKeyTextView, membersValueTextView);
            layout.addView(membersKeyTextView);
            layout.addView(membersValueTextView);

            targetKeyTextView = new TextView(context);
            targetValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(targetKeyTextView, targetValueTextView);
            layout.addView(targetKeyTextView);
            layout.addView(targetValueTextView);

            titleKeyTextView = new TextView(context);
            titleValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(titleKeyTextView, titleValueTextView);
            layout.addView(titleKeyTextView);
            layout.addView(titleValueTextView);
        } else {
            layout = (LinearLayout) convertView;
            resultNumberTextView = (TextView) layout.getChildAt(0);

            userIdKeyTextView = (TextView) layout.getChildAt(1);
            userIdValueTextView = (TextView) layout.getChildAt(2);

            contributorsKeyTextView = (TextView) layout.getChildAt(3);
            contributorsValueTextView = (TextView) layout.getChildAt(4);

            currentAmountKeyTextView = (TextView) layout.getChildAt(5);
            currentAmountValueTextView = (TextView) layout.getChildAt(6);

            membersKeyTextView = (TextView) layout.getChildAt(7);
            membersValueTextView = (TextView) layout.getChildAt(8);

            targetKeyTextView = (TextView) layout.getChildAt(9);
            targetValueTextView = (TextView) layout.getChildAt(10);

            titleKeyTextView = (TextView) layout.getChildAt(11);
            titleValueTextView = (TextView) layout.getChildAt(12);
        }

        resultNumberTextView.setText(String.format("#%d", + position+1));
        userIdKeyTextView.setText("userId");
        userIdValueTextView.setText(result.getUserId());
        contributorsKeyTextView.setText("contributors");
        contributorsValueTextView.setText(result.getContributors().toString());
        currentAmountKeyTextView.setText("currentAmount");
        currentAmountValueTextView.setText("" + result.getCurrentAmount().longValue());
        membersKeyTextView.setText("members");
        membersValueTextView.setText(result.getMembers().toString());
        targetKeyTextView.setText("target");
        targetValueTextView.setText("" + result.getTarget().longValue());
        titleKeyTextView.setText("title");
        titleValueTextView.setText(result.getTitle());
        return layout;
    }
}

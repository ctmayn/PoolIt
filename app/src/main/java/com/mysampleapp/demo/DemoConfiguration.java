package com.mysampleapp.demo;

import android.provider.ContactsContract;
import android.support.v4.app.Fragment;

import com.amazonaws.models.nosql.UsersDO;
import com.mysampleapp.R;
import com.mysampleapp.demo.AddFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.amazonaws.models.*;
import com.mysampleapp.demo.nosql.DemoNoSQLTableUsers;
import com.mysampleapp.demo.nosql.NoSQLSelectTableDemoFragment;

public class DemoConfiguration {
    private static final List<DemoFeature> demoFeatures = new ArrayList<DemoFeature>();
    public static DemoNoSQLTableUsers tableDB = new DemoNoSQLTableUsers();


    //public static User

    private static class manager {
        static ArrayList<String> list;

        static ArrayList<String> getFriends() {
            list = new ArrayList<String>();
            list.add("apple");
            list.add("banana");
            return list;
        }

        static ArrayList<String> getEvents() {
            list = new ArrayList<String>();
            list.add("apple");
            list.add("banana");
            return list;
        }
    }


    static {
        DemoFeature profile = addDemoFeature("user_identity", R.mipmap.user_identity, R.string.feature_profile_title,
                R.string.empty, R.string.empty,
                new DemoItem(R.string.main_fragment_title_user_settings, R.mipmap.user_profile_data,
                        R.string.main_fragment_title_user_settings,
                        UserSettingsDemoFragment.class));
        profile.addDemo(new DemoItem(R.string.user_identity, R.mipmap.user_identity,
                R.string.user_identity, IdentityDemoFragment.class));
        demoFeatureAdd(profile);
        DemoFeature friends = addDemoFeature("user_data_storage", R.mipmap.user_data_storage,
                R.string.feature_friends, R.string.empty, R.string.empty, null);
        friends.addDemo(new DemoItem(R.string.user1, R.mipmap.user_identity, R.string.user1,
               IdentityDemoFragment.class));
        friends.addDemo(new DemoItem(R.string.user2, R.mipmap.user_identity, R.string.user2,
                IdentityDemoFragment.class));
        friends.addDemo(new DemoItem(R.string.user3, R.mipmap.user_identity, R.string.user3,
                IdentityDemoFragment.class));
        friends.addDemo(new DemoItem(R.string.add_friend, R.mipmap.icon_check, R.string.add_friend,
                AddFragment.class));
        demoFeatureAdd(friends);
        DemoFeature events = addDemoFeature("nosql_database", R.mipmap.icon_star, R.string.feature_my_events,
                R.string.empty, R.string.empty, null);
        events.addDemo(new DemoItem(R.string.event1, R.mipmap.icon_star, R.string.event1,
                IdentityDemoFragment.class));
        events.addDemo(new DemoItem(R.string.add_event, R.mipmap.icon_check, R.string.add_event,
                AddFragment.class));
        demoFeatureAdd(events);

    }

    public static List<DemoFeature> getDemoFeatureList() {
        return Collections.unmodifiableList(demoFeatures);
    }

    public static DemoFeature getDemoFeatureByName(final String name) {
        for (DemoFeature demoFeature : demoFeatures) {
            if (demoFeature.name.equals(name)) {
                return demoFeature;
            }
        }
        return null;
    }

    private static DemoFeature addDemoFeature(final String name, final int iconResId, final int titleResId,
                                       final int subtitleResId, final int overviewResId,
                                       final DemoItem demoItems) {
        DemoFeature demoFeature = new DemoFeature(name, iconResId, titleResId, subtitleResId,
                overviewResId, demoItems);
        return demoFeature;
    }

    private static void demoFeatureAdd(DemoFeature demoFeature) {
        demoFeatures.add(demoFeature);
    }

    public static class DemoFeature {
        public String name;
        public int iconResId;
        public int titleResId;
        public int subtitleResId;
        public int overviewResId;
        public ArrayList<DemoItem> demos = new ArrayList<DemoItem>();

        public DemoFeature() {

        }

        public DemoFeature(final String name, final int iconResId, final int titleResId,
                           final int subtitleResId, final int overviewResId,
                           final DemoItem demoItem) {
            this.name = name;
            this.iconResId = iconResId;
            this.titleResId = titleResId;
            this.subtitleResId = subtitleResId;
            this.overviewResId = overviewResId;
            if (demoItem != null) {
                demos.add(demoItem);
            }

        }

        public void addDemo(final DemoItem demoItem) {
            System.out.println(demoItem.fragmentClassName);
            demos.add(demoItem);
        }
    }

    public static class DemoItem {
        public int titleResId;
        public int iconResId;
        public int buttonTextResId;
        public String fragmentClassName;

        public DemoItem(final int titleResId, final int iconResId, final int buttonTextResId,
                        final Class<? extends Fragment> fragmentClass) {
            this.titleResId = titleResId;
            this.iconResId = iconResId;
            this.buttonTextResId = buttonTextResId;
            this.fragmentClassName = fragmentClass.getName();
        }
    }
}
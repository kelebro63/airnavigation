package com.example.airnavigate.Views.Main;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseDialogFragment;
import com.example.airnavigate.Views.Main.ThematicBloks.MainListFragment;

/**
 * Dispatches fragments on behalf of navigation drawer activity
 */
public class FragmentDispatcher {


    private FragmentManager mManager;
    private Resources mResources;


    public FragmentDispatcher(@NonNull FragmentManager mManager,
                              @NonNull Resources mResources) {

        this.mManager = mManager;
        this.mResources = mResources;

    }

    void onCreate() {
       // bus.register(this);

    }


    void onDestroy() {
       // bus.unregister(this);
    }


    void displayNavigationDrawerItem(int position, boolean calledByUserClick) {

        Fragment currentSelectionFragment = null;

        String tag = null;
        switch (position) {
            case NavDrawerItems.RECIPES:
                currentSelectionFragment = mManager.findFragmentByTag(MainListFragment.TAG);
                if (currentSelectionFragment == null) {
                    currentSelectionFragment = new MainListFragment();
                    tag = MainListFragment.TAG;
                }
                break;
//            case NavDrawerItems.HOWTOS:
//                currentSelectionFragment = mManager.findFragmentByTag(HowToFragment.TAG);
//                if (currentSelectionFragment == null) {
//                    currentSelectionFragment = new HowToFragment();
//                    tag = HowToFragment.TAG;
//                }
//                break;
//            case NavDrawerItems.FAVORITES:
//                currentSelectionFragment = mManager.findFragmentByTag(FavoriteRecipesFragment.TAG);
//                if (currentSelectionFragment == null) {
//                    currentSelectionFragment = new FavoriteRecipesFragment();
//                    tag = FavoriteRecipesFragment.TAG;
//                }
//                break;
//            case NavDrawerItems.SHOPPING:
//                if (calledByUserClick || mManager.getBackStackEntryCount() <= 0) {
//                    currentSelectionFragment = mManager.findFragmentByTag(FragmentShoppingList.TAG);
//                    if (currentSelectionFragment == null) {
//                        currentSelectionFragment = new FragmentShoppingList();
//                        tag = FragmentShoppingList.TAG;
//                    }
//                } else {
//                    //just let Fragment manager restore backstack, don't commit any fragment
//                    currentSelectionFragment = null;
//                }
//                break;
//            case NavDrawerItems.ESSENTIALS:
//                if (calledByUserClick || mManager.getBackStackEntryCount() <= 0) {
//                    currentSelectionFragment = mManager.findFragmentByTag(FragmentEssentials.TAG);
//                    if (currentSelectionFragment == null) {
//                        currentSelectionFragment = new FragmentEssentials();
//                        tag = FragmentEssentials.TAG;
//                    }
//                } else {
//                    //just let Fragment manager restore backstack, don't commit any fragment
//                    currentSelectionFragment = null;
//                }
//                break;
//            case NavDrawerItems.ABOUT_US:
//
//                boolean showAboutUsAsDialog = mResources.getBoolean(R.bool.show_about_us_as_dialog);
//                if (showAboutUsAsDialog) {
//                    showFragmentAsDialog(new FragmentAboutUs(), FragmentAboutUs.TAG);
//                    return;
//                }
//
//                currentSelectionFragment = mManager.findFragmentByTag(FragmentAboutUs.TAG);
//                if (currentSelectionFragment == null) {
//                    currentSelectionFragment = new FragmentAboutUs();
//                    tag = FragmentAboutUs.TAG;
//                }
//                break;
//            case NavDrawerItems.SETTINGS:
//                boolean showSettingsAsDialog = mResources.getBoolean(R.bool.show_settings_as_dialog);
//
//                if (showSettingsAsDialog) {
//                    showFragmentAsDialog(new FragmentSettings(), FragmentSettings.TAG);
//                    return;
//                }
//                currentSelectionFragment = mManager.findFragmentByTag(FragmentSettings.TAG);
//
//                if (currentSelectionFragment == null) {
//                    currentSelectionFragment = new FragmentSettings();
//                    tag = FragmentSettings.TAG;
//                }
//
//                break;
//            default:
//                throw new IllegalArgumentException("Navdrawer item not supported");
        }

        if (currentSelectionFragment != null && !currentSelectionFragment.isAdded()) {
            //if fragment is not null and is not yet added, it means user selection happened, we need to commit it
            //when we selected a navDrawer item, we need to clear the back stack
            for (int i = 0; i < mManager.getBackStackEntryCount(); ++i) {
                mManager.popBackStack();
            }
            mManager.beginTransaction().replace(R.id.container, currentSelectionFragment, tag)
                    .commit();
        }
    }


    private void showFragmentAsDialog(@NonNull BaseDialogFragment fragment, @NonNull String tag) {
        Fragment existing = mManager.findFragmentByTag(tag);
        if (existing != null) {
            return;
        }
        fragment.show(mManager, tag);


    }

//    boolean isSpecialCasePosition(int position) {
//        boolean isSettingsDialog = position == NavDrawerItems.SETTINGS
//                && mResources.getBoolean(R.bool.show_settings_as_dialog);
//        /*
//        boolean isTellFriend = position == NavDrawerItems.TELL_FRIEND;
//        boolean isFeedback = position == NavDrawerItems.APP_FEEDBACK;
//        */
//
//        boolean isAboutUsDialog = position == NavDrawerItems.ABOUT_US &&
//                mResources.getBoolean(R.bool.show_about_us_as_dialog);
//
//        return isSettingsDialog
//                //|| isTellFriend
//                //|| isFeedback
//                || isAboutUsDialog;
//    }

    /**
     * This method is used in Phone mode, it is used by FragmentEssentials only.
     */
//    public void displayEssentialsItemDetails(String title, String type) {
//
//        FragmentEssentialsDetails details = (FragmentEssentialsDetails) mManager.findFragmentByTag(FragmentEssentialsDetails.TAG);
//
//        if (details == null) {
//            details = FragmentEssentialsDetails.createNew(title, type);
//        }
//
//        mManager.beginTransaction()
//                .setCustomAnimations(R.anim.appear_from_right, R.anim.disappear_to_left, R.anim.appear_from_left, R.anim.disappear_to_right)
//                .replace(R.id.container, details, FragmentEssentialsDetails.TAG)
//                .addToBackStack(FragmentEssentialsDetails.TAG)
//                .commit();
//
//    }
//
//    /**
//     * This method is used in Phone mode, it is used by FragmentShoppingList only.
//     */
//    public void displayShoppingItemDetails(String uid) {
//
//        FragmentShoppingItemDetails details = (FragmentShoppingItemDetails) mManager.findFragmentByTag(FragmentShoppingItemDetails.TAG);
//
//        if (details == null) {
//            details = FragmentShoppingItemDetails.createNew(uid);
//        }
//
//        mManager.beginTransaction()
//                .setCustomAnimations(R.anim.appear_from_right, R.anim.disappear_to_left, R.anim.appear_from_left, R.anim.disappear_to_right)
//                .replace(
//                        R.id.container,
//                        details,
//                        FragmentShoppingItemDetails.TAG
//                )
//                .addToBackStack(FragmentShoppingItemDetails.TAG)
//                .commit();
//
//    }

    public static class NavDrawerItems {
        public static final int RECIPES = 1;
        public static final int HOWTOS = 2;
        public static final int FAVORITES = 3;
        public static final int SHOPPING = 4;
        public static final int ESSENTIALS = 6;
        public static final int ABOUT_US = 7;
        public static final int SETTINGS = 8;
    }


}

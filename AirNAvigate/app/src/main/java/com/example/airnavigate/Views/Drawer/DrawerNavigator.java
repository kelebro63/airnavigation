package com.example.airnavigate.Views.Drawer;

/**
 * Navigates user to another screen
 */
public interface DrawerNavigator {
    void navigateTo(@NavigationConstants.MenuItemId int menuItemId);
}

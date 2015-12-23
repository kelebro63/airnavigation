package com.example.airnavigate.Views.Drawer;

/**
 * Navigation drawer menu item model
 */
class DrawerItem {

    private Type type;
    private TwoStateIcon icons;
    private String title;
    private boolean isSelected;

    public DrawerItem(Type type, TwoStateIcon icons, String title) {
        this.type = type;
        this.icons = icons;
        this.title = title;
    }



    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public TwoStateIcon getIcons() {
        return icons;
    }

    public void setIcons(TwoStateIcon icons) {
        this.icons = icons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }



    public static enum Type {
        TOP, HEADER, MAIN_ITEM, MORE_ITEM
    }

    public static class TwoStateIcon {
        private int iconInactiveResource;
        private int iconActiveResource;

        public TwoStateIcon(int iconInactiveResource, int iconActiveResource) {
            this.iconInactiveResource = iconInactiveResource;
            this.iconActiveResource = iconActiveResource;
        }

        public int getIconInactiveResource() {
            return iconInactiveResource;
        }

        public void setIconInactiveResource(int iconInactiveResource) {
            this.iconInactiveResource = iconInactiveResource;
        }

        public int getIconActiveResource() {
            return iconActiveResource;
        }

        public void setIconActiveResource(int iconActiveResource) {
            this.iconActiveResource = iconActiveResource;
        }
    }
}

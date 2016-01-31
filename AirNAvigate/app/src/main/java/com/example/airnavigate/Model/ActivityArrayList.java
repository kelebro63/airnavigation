package com.example.airnavigate.Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Subclass of ArrayList<Status> to defeat runtime generic type erasure. GreenDao needs it to define for (de)serialization of the property<br>
 * Used to define career list property
 */
public class ActivityArrayList extends ArrayList<Activity> {
    public ActivityArrayList(int capacity) {
        super(capacity);
    }

    public ActivityArrayList() {
    }

    public ActivityArrayList(Collection<? extends Activity> collection) {
        super(collection);
    }
}

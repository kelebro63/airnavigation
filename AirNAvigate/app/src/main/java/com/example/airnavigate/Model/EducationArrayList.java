package com.example.airnavigate.Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Subclass of ArrayList<Status> to defeat runtime generic type erasure. GreenDao needs it to define for (de)serialization of the property<br>
 * Used to define career list property
 */
public class EducationArrayList extends ArrayList<Education> {
    public EducationArrayList(int capacity) {
        super(capacity);
    }

    public EducationArrayList() {
    }

    public EducationArrayList(Collection<? extends Education> collection) {
        super(collection);
    }
}

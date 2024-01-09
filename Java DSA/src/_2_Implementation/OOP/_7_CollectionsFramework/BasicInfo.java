package _2_Implementation.OOP._7_CollectionsFramework;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BasicInfo {
    /* Visualizing the connections:

        Collections Framework:
        https://techvidvan.com/tutorials/wp-content/uploads/sites/2/2020/03/collection-framework-hierarchy-in-java.jpg

        Map Framework better overview:
        https://www.tuteworld.com/java/img/Java-Map-Hierarchy.jpg
    */

    /*
        Collections Framework:

            'Collection' is an interface which is further extended by 'List', 'Set' & 'Queue' Interfaces.
            These child interfaces are then again extended or implemented by other interfaces or other
            classes.
            These other interfaces and classes are the predefined data structures that we can then easily
            make use of when required. (Stacks, Queues, Linked Lists)

            In short - makes coding easier by letting us make use of pre-defined data structure classes

        Like 'Collection' there is also the 'Map' Interface that is used internally for Tree Maps and
        other Abstract Maps (Enum Map, Hash Map)
     */
    public static void main(String[] args) {
        // The collection interface consists of abstract methods which are common to different data structures
        // Thus, if we try to create an object of Collection type, than we need to define the body for all those methods
        Collection obj = new Collection() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NotNull
            @Override
            public Iterator iterator() {
                return null;
            }

            @NotNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NotNull
            @Override
            public Object[] toArray(@NotNull Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NotNull Collection c) {
                return false;
            }

            @Override
            public boolean addAll(@NotNull Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(@NotNull Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(@NotNull Collection c) {
                return false;
            }

            @Override
            public void clear() {}
        };
    }
}

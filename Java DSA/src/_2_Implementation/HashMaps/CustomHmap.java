package _2_Implementation.HashMaps;

import java.util.*;

public class CustomHmap<T, U> {

    private class Entity {
        T key;
        U value;

        Entity(T key, U value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAP = 10;
    private static final float loadFactor = 0.75f;
    private ArrayList<LinkedList<Entity>> table;
    private int keys;

    public CustomHmap() {
        init(DEFAULT_CAP);
    }

    public CustomHmap(int capacity) {
        init(capacity);
    }

    private void init(int capacity) {
        this.table = new ArrayList<>();
        for(int i = 0; i < capacity; i++) {
            this.table.add(new LinkedList<>());
        }
    }

    private int hash(T key) {
        return key.hashCode() % table.size();
    }

    public void put(T key, U value) {
        Entity entity = new Entity(key, value);
        LinkedList<Entity> LL = this.table.get(hash(key));
        boolean exists = false;
        for(Entity ent: LL) {
            if(ent.key.equals(key)) {
                exists = true;
                ent.value = entity.value;
                break;
            }
        }
        if(!exists) LL.add(entity);
        tableUpdate();
    }

    private void tableUpdate() {
        this.keys++;
        float currLoadFactor = (float) this.keys / this.table.size();
        if(currLoadFactor > loadFactor) tableResize();
    }

    private void tableResize() {
        ArrayList<LinkedList<Entity>> oldTable = this.table, newTable = new ArrayList<>();
        for(int i = 0; i < 2 * this.table.size(); i++) newTable.add(new LinkedList<>());
        this.table = newTable;
        this.keys = 0;
        for(LinkedList<Entity> LL: oldTable) {
            for(Entity entity: LL) {
                this.put(entity.key, entity.value); // key count will be adjusted in 'tableUpdate()'
            }
        }
    }

    public U get(T key) {
        int code = hash(key);
        LinkedList<Entity> LL = this.table.get(code);
        for(Entity entity: LL) if(entity.key.equals(key)) return entity.value;
        return null;
    }

    public void remove(T key) {
        int code = hash(key);
        LinkedList<Entity> LL = this.table.get(code);
        for(int i = 0; i < LL.size(); i++) {
            if(LL.get(i).key.equals(key)) {
                LL.remove(i);
                this.keys--;
                break;
            }
        }
    }

    public boolean containsKey(T key) {
        return get(key) != null;
    }

    public boolean containsValue(U value) {
        for(LinkedList<Entity> LL: this.table) {
            for(Entity entity: LL) {
                if(entity.value.equals(value)) return true;
            }
        }
        return false;
    }

    public Set<T> keySet() {
        Set<T> set = new HashSet<>();
        for(LinkedList<Entity> LL: this.table) {
            for(Entity entity: LL) set.add(entity.key);
        }
        return set;
    }

    public Collection<U> values() {
        Collection<U> values = new ArrayList<>();
        for(LinkedList<Entity> LL: this.table) {
            for(Entity entity: LL) values.add(entity.value);
        }
        return values;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.keys;
    }

    @Override
    public String toString() {
        Set<T> keys = this.keySet();
        StringBuilder strB = new StringBuilder("{");
        if(!this.isEmpty()) {
            for(T key: keys) strB.append(key).append("=").append(this.get(key)).append(", ");
            strB.replace(strB.length() - 2, strB.length(), "");
        }
        strB.append("}");
        return strB.toString();
    }
}

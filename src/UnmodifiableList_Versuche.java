import java.util.*;

/*
https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
 */

public class UnmodifiableList_Versuche {

    public static void main(String[] args){

        List<String> arrayList = new ArrayList<>();
        arrayList.add("Test");
        arrayList.add("eins");
        arrayList.add("dreiundzwanzig");

        List<String> unmodifiableArrayList = Collections.unmodifiableList(arrayList);
        List<Integer> unmodifiableList = Collections.unmodifiableList(Arrays.asList(1,2,3));

        assert(unmodifiableList.get(2)==3);
        // public E get(int index) {return list.get(index);}

        System.out.println(unmodifiableArrayList);  // [Test, eins, dreiundzwanzig]
        arrayList.add("23");
        System.out.println(unmodifiableArrayList);  // [Test, eins, dreiundzwanzig, 23]

        try{
            unmodifiableList.add(2);
        }catch(UnsupportedOperationException e) {
        }
        /*
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        public boolean containsAll(Collection<?> coll) {
            return c.containsAll(coll);
        }
        public boolean addAll(Collection<? extends E> coll) {
            throw new UnsupportedOperationException();
        }
        public boolean removeAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }
        public boolean retainAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }
        public void clear() {
            throw new UnsupportedOperationException();
        }
        //usw.
         */
    }
}

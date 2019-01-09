import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.TreeSet;

public class App {

    public static void main(String arg[]) {
      /*  TreeSet<Test> tests = new TreeSet<>();
        tests.add(new Test(2, 1));
        tests.add(new Test(5, 1));
        tests.add(new Test(3, 1));
        tests.add(new Test(3, 2));

        System.out.println(tests);
        ArrayList<Test> testss = new ArrayList<>();
        testss.add(new Test(2, 1));
        testss.add(new Test(5, 1));
        testss.add(new Test(3, 1));
        testss.add(new Test(3, 2));
        Collections.sort(testss);
        System.out.println(tests);*/


        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(6);
        Integer end = -1;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (i > 5-1||end.equals(arrayList.get(i))){
                end = arrayList.get(i);
                arrayList.set(i, 5);
            }
            else
                arrayList.set(i, 1);
        }
        System.out.println(arrayList);

    }


}

class Test implements Comparable<Test> {
    int x;
    int y;

    public Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Test o) {
        return o.x - this.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return x == test.x &&
                y == test.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
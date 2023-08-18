import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Heap<Node> heap = new Heap<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input != 0) {
                heap.add(new Node(input));
            } else {
                if (!heap.isEmpty()) {
                    System.out.println(heap.remove().value);
                } else {
                    System.out.println(0);
                }
            }
        }

    }

    public static class Node implements Comparable<Node>{
        int value;

        public Node(int value, Node next) {
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }


        @Override
        public int compareTo(Node o) {
            if (Math.abs(this.value) != Math.abs(o.value)) {
                return Math.abs(this.value) - Math.abs(o.value);
            } else {
                return this.value - o.value;
            }
        }
    }

    public static class Heap<E> {
        private final Comparator<? super E> comparator;
        private static final int DEFAULT_CAPACITY = 10;

        private int size;

        private Object[] array;

        public Heap() {
            this(DEFAULT_CAPACITY, null);
        }

        public Heap(int capacity) {
            this(capacity, null);
        }

        public Heap(Comparator<? super E> comparator) {
            this(DEFAULT_CAPACITY, comparator);
        }

        public Heap(int capacity, Comparator<? super E> comparator) {
            this.array = new Object[capacity];
            this.size = 0;
            this.comparator = comparator;
        }

        private int getParentIndex(int index) {
            return index / 2;
        }

        private int getLeftChildIndex(int index) {
            return index * 2;
        }

        private int getRightChildIndex(int index) {
            return index * 2 + 1;
        }

        private void resize(int capacity) {
            // 새로운 배열 생성
            Object[] newArray = new Object[capacity];

            // 기존 배열에서 새로운 배열로 요소들을 복사한다.
            for (int i = 1; i <= size; i++) {
                newArray[i] = array[i];
            }

        /*
        현재 배열은 GC 처리를 위해 null로 처리하고
        새로운 배열을 연결한다.
         */
            this.array = null;
            this.array = newArray;
        }

        public void add(E value) {
            // 배열이 꽉 차있을 때, 배열의 크기를 2배로 늘린다.
            // index 1부터 시작하므로 size + 1 == length이면 배열이 꽉 찬 상태이다.
            if (this.size + 1 == array.length) {
                resize(array.length * 2);
            }

            siftUp(this.size + 1, value);
            this.size++;
        }


        /**
         * @param index 추가할 노드의 인덱스
         * @param target 재배치할 노드
         */
        public void siftUp(int index, E target) {
            if (this.comparator != null) {
                siftUpComparator(index, target, this.comparator);
            } else {
                siftUpComparable(index, target);
            }
        }

        /**
         * Comparator를 이용한 sift-up
         */
        public void siftUpComparator(int index, E target, Comparator<? super E> comparator) {
            while (index > 1) {
                int parentIndex = getParentIndex(index);

                @SuppressWarnings("unchecked")
                E parent = (E) array[parentIndex];

                // 타겟 노드 값이 부모 노드보다 크면 반복문 종료
                if (comparator.compare(target, parent) >= 0) {
                    break;
                }

                array[index] = parent;
                index = parentIndex;
            }

            array[index] = target;
        }

        /**
         * 삽입 할 객체의 Comparable을 이용해서 sift-up
         */
        public void siftUpComparable(int index, E target) {
            @SuppressWarnings("unchecked")
            Comparable<? super E> comparable = (Comparable<? super E>) target;

            while (index > 1) {
                int parentIndex = getParentIndex(index);
                @SuppressWarnings("unchecked")
                E parentVal = (E) array[parentIndex];

                if (comparable.compareTo(parentVal) >= 0) {
                    break;
                }

                array[index] = parentVal;
                index = parentIndex;
            }

            array[index] = target;
        }

        @SuppressWarnings("unchecked")
        public E remove() {
            if (size < 1) {
                throw new NoSuchElementException();
            }

            E result = (E) array[1];
            E target = (E) array[size];
            array[size] = null;
            size--;

            siftDown(target);

            return result;
        }

        public void siftDown(E target) {
            if (this.comparator != null) {
                siftDownComparator(target);
            } else {
                siftDownComparable(target);
            }
        }

        @SuppressWarnings("unchecked")
        public void siftDownComparator(E target) {
            // 루트 노드 삭제
            array[1] = null;

            int parentIndex = 1;
            int childIndex;

            // 왼쪽 자식 노드가 없을 때까지 반복
            while ((childIndex = getLeftChildIndex(parentIndex)) <= size) {
                int rightChildIndex = getRightChildIndex(parentIndex);

                E child = (E) array[childIndex];

                // 오른쪽 자식이 왼쪽 자식보다 작은 경우 재배치 할 노드를 오른쪽 노드로 바꾼다.
                if (rightChildIndex <= size && this.comparator.compare(child, (E) array[rightChildIndex]) > 0) {
                    childIndex = rightChildIndex;
                    child = (E) array[rightChildIndex];
                }

                // 재배치할 노드가 자식 노드보다 작을 경우 종료
                if (this.comparator.compare(target, child) <= 0) {
                    break;
                }

                array[parentIndex] = child;
                parentIndex = childIndex;
            }

            array[parentIndex] = target;

            // 배열의 크기가 기본 크기보다 크면서 배열의 크기가 요소의 개수의 1/4일 때 배열의 크기를 줄인다.
            if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
                resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
            }
        }

        @SuppressWarnings("unchecked")
        private void siftDownComparable(E target) {

            Comparable<? super E> comparable = (Comparable<? super E>) target;

            // 루트 노드 삭제
            array[1] = null;

            int parentIndex = 1;
            int childIndex;

            // 왼쪽 자식 노드가 없을 때까지 반복
            while ((childIndex = getLeftChildIndex(parentIndex)) <= size) {
                int rightChildIndex = getRightChildIndex(parentIndex);

                E child = (E) array[childIndex];
                Comparable<? super E> childComparable = (Comparable<? super E>) child;

                // 오른쪽 자식이 왼쪽 자식보다 작은 경우 재배치 할 노드를 오른쪽 노드로 바꾼다.
                if (rightChildIndex <= size && childComparable.compareTo((E) array[rightChildIndex]) > 0) {
                    childIndex = rightChildIndex;
                    child = (E) array[rightChildIndex];
                }

                // 재배치할 노드가 자식 노드보다 작을 경우 종료
                if (comparable.compareTo((E) child) <= 0) {
                    break;
                }

                array[parentIndex] = child;
                parentIndex = childIndex;
            }

            array[parentIndex] = target;

            // 배열의 크기가 기본 크기보다 크면서 배열의 크기가 요소의 개수의 1/4일 때 배열의 크기를 줄인다.
            if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
                resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
            }
        }

        public int size() {
            return this.size;
        }

        @SuppressWarnings("unchecked")
        public E peek() {
            if (size < 1) {
                throw new NoSuchElementException();
            }

            return (E) array[1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public Object[] toArray() {
            return Arrays.copyOf(array, size + 1);
        }
    }

}

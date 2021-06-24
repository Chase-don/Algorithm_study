public class Test {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, new Merger<Integer>() {
            public Integer merger(Integer a, Integer b) {
                return a + b;
            }
        });

        //除了匿名内部类以外还可以用lambada来表示
//        SegmentTree<Integer> segmentTree1 = new SegmentTree<Integer>(nums, (a, b) -> a + b);
//        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));


    }
}

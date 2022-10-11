package company.vk.polis.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that allows us to get k max elements ordered descending in source list.
 */
public final class TopK {
    /**
     * Top-K with O(n logk) complexity.
     * @param list input list
     * @param k amount of max values to carry out
     * @return list with k max elements ordered descending
     * @param <T> type of elements
     */
    public <T extends Comparable<T>> List<T> topK(List<T> list, int k) {
        Heap<T> heap = new Heap<>(k);
        for (int i = 0; i < k; i++) {
            heap.insert(list.get(i));
        }
        for (int i = k; i < list.size(); i++) {
            T element = list.get(i);
            if (heap.peek().compareTo(element) < 0) {
                heap.extract();
                heap.insert(element);
            }
        }

        List<T> resultList = new ArrayList<>();
        while (heap.size() > 0) {
            resultList.add(heap.extract());
        }
        Collections.reverse(resultList);
        return resultList;
    }
}

class HeapSort:

    @staticmethod
    def __endian(arr, start, end, compare_func):
        # 根结点
        root = start
        # 左孩子
        child = root * 2 + 1
        print("start:%s, end:%s, root:%s, left:%s -> %s" % (start, end, root, child, arr))
        while child <= end:
            # 找出子节点中的一个与父节点比较
            if child + 1 <= end and compare_func(arr[child], arr[child + 1]):
                child += 1
            # 与父节点比较
            if compare_func(arr[root], arr[child]):
                arr[root], arr[child] = arr[child], arr[root]
                root = child
                child = root * 2 + 1
            else:
                # 因为是大/小顶堆，所以一旦不需要交换，就可以
                break

    @staticmethod
    def __big_endian(left_child, right_child):
        return left_child < right_child

    @staticmethod
    def __small_endian(left_child, right_child):
        return left_child > right_child

    @staticmethod
    def __heap_sort(arr, compare_func):
        # 无序区大根堆排序
        first = len(arr) // 2 - 1
        for start in range(first, -1, -1):
            # 从下到上，从左到右对每个节点进行调整，循环得到非叶子节点，调整所有的节点
            print(arr, start, len(arr) - 1)
            HeapSort.__endian(arr, start, len(arr) - 1, compare_func)

        for end in range(len(arr) - 1, 0, -1):
            # 顶部尾部互换位置
            arr[0], arr[end] = arr[end], arr[0]
            # 重新调整子节点的顺序，从顶开始调整
            HeapSort.__endian(arr, 0, end - 1, compare_func)

        return arr

    @staticmethod
    def big_heap_sort(arr):
        return HeapSort.__heap_sort(arr, HeapSort.__big_endian)

    @staticmethod
    def small_heap_sort(arr):
        return HeapSort.__heap_sort(arr, HeapSort.__small_endian)

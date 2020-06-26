from BaseAlgorithm.Python.BubbleSort import BubbleSort
from BaseAlgorithm.Python.DirectSelectSort import DirectSelectSort
from BaseAlgorithm.Python.HeapSort import HeapSort
from BaseAlgorithm.Python.InsertSort import InsertSort
from BaseAlgorithm.Python.MergeSort import MergeSort
from BaseAlgorithm.Python.QuickSort import QuickSort
from BaseAlgorithm.Python.RadixSort import RadixSort
from BaseAlgorithm.Python.ShellSort import ShellSort


def main():
    # array = [3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321]
    array = [5, 3, 2, 1, 9, 8, 4, 0]
    # print("冒泡排序：%s" % BubbleSort.sort(array))
    # print("直接选择排序：%s" % DirectSelectSort.sort(array))
    # print("基数排序：%s" % RadixSort.sort(array))
    # print("希尔排序：%s" % ShellSort.sort(array))
    # print("插入排序：%s" % InsertSort.sort(array))
    # print("堆排序（小顶堆）：%s" % HeapSort.small_heap_sort(array))
    # print("堆排序（大顶堆）：%s" % HeapSort.big_heap_sort(array))
    # print("快速排序：%s" % QuickSort.sort(array))
    print("归并排序：%s" % MergeSort.sort(array))


if __name__ == '__main__':
    main()

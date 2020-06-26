class QuickSort:

    @staticmethod
    def sort(array):
        # 递归
        return QuickSort.__sort(array, 0, len(array) - 1)

    @staticmethod
    def __sort(array, start, end):
        print("start:%s, end:%s->%s" % (start, end, array))
        # i,j用于遍历
        i, j = start, end
        # 标杆
        pivot = array[start]
        while i < j:
            # 先从j开始（右边）
            while i < j and array[j] > pivot:
                j = j - 1
            # 后从i开始（左边）
            while i < j and array[i] < pivot:
                i = i + 1
            # 如果相等并且小于
            if array[i] == array[j] and i < j:
                i = i + 1
            else:
                # 置换
                print("i:%s(%s), j:%s(%s), pivot:%s, array:%s" % (
                    i, array[i], j, array[j], pivot, array
                ))
                array[i], array[j] = array[j], array[i]

        print("\n")

        # 递归处理
        if i - 1 > start:
            array = QuickSort.__sort(array, start, i - 1)
        if j + 1 < end:
            array = QuickSort.__sort(array, j + 1, end)

        return array



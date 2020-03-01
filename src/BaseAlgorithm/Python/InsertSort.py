class InsertSort:

    @staticmethod
    def sort(array):
        # 第一个元素就是有序序列了
        for i in range(1, len(array)):
            # 从后往前依次插入
            for j in range(i, 0, -1):
                if array[j] > array[j - 1]:
                    continue
                array[j], array[j - 1] = array[j - 1], array[j]
        return array

class DirectSelectSort:

    @staticmethod
    def sort(array):
        min_index = len(array) - 1
        for i in range(min_index):
            index = 0
            # 找到最大数的索引
            for j in range(1, min_index + 1):
                if array[index] > array[j]:
                    continue
                index = j

            # 交换数据
            if index < min_index:
                array[min_index], array[index] = array[index], array[min_index]
            min_index = min_index - 1
            print("i:%s, min_index:%s, index:%s, array:%s" % (
                i, min_index, index, array
            ))

        return array

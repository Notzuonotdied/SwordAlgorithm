import math


class RadixSort:

    @staticmethod
    def sort(array):
        index, max_item, level = RadixSort.find_max(array)
        print(index, max_item, level)

        for l in range(level):
            bucket = RadixSort.init_dict()
            # 取数据
            for i, item in enumerate(array):
                key = math.floor(item % math.pow(10, l + 1) // math.pow(10, l))
                # print("原：%s，位数：%s，对应位数的值：%s" % (item, l, key))
                bucket[key].append(item)

            print(bucket)
            tmp_index = 0
            for i in range(0, 10):
                for tmp in bucket[i]:
                    array[tmp_index] = tmp
                    tmp_index = tmp_index + 1

        return array

    @staticmethod
    def init_dict():
        result = {}
        for index in range(10):
            result[index] = []

        return result

    @staticmethod
    def find_max(array):
        index = 0
        max_item = array[index]

        for i, item in enumerate(array):
            if item > max_item:
                index = i
                max_item = item

        # 最大数的位数
        level = 0
        temp_item = max_item
        while temp_item != 0:
            level = level + 1
            temp_item = temp_item // 10

        return index, max_item, level

import math


class ShellSort:

    @staticmethod
    def sort(array):
        length = len(array)
        step = length
        while step != 0:
            step = math.floor(step / 2)
            print("step:%s" % step)
            for index in range(0, step, 1):
                # 根据步长，抽离出index，用于插入排序
                list_after_step = []
                i = index
                while i < length:
                    list_after_step.append(i)
                    i = i + step

                print("\t list_after_step:%s" % list_after_step)
                # 插入排序
                for i in range(1, len(list_after_step)):
                    # 从后往前依次插入
                    for j in range(i, 0, -1):
                        back = list_after_step[j]
                        front = list_after_step[j - 1]
                        if array[back] > array[front]:
                            continue
                        array[back], array[front] = array[front], array[back]

        return array

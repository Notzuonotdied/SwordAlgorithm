class BubbleSort:

    @staticmethod
    def sort(array):
        min_index = len(array) - 1
        for i in range(min_index + 1):
            index = 0
            for j in range(1, min_index + 1):
                if array[index] > array[j]:
                    continue
                index = j

            if index < min_index:
                array[index], array[min_index] = array[min_index], array[index]
            min_index = min_index - 1
        return array

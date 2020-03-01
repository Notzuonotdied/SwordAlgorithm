class MergeSort:

    @staticmethod
    def sort(lists):
        if len(lists) <= 1:
            return lists
        # 分块
        num = int(len(lists) / 2)
        left = MergeSort.sort(lists[:num])
        right = MergeSort.sort(lists[num:])
        return MergeSort.__merge(left, right)

    @staticmethod
    def __merge(left, right):
        r, l = 0, 0
        result = []
        while l < len(left) and r < len(right):
            if left[l] <= right[r]:
                result.append(left[l])
                l += 1
            else:
                result.append(right[r])
                r += 1
        # 剩下的已排序的部分直接添加就好了
        result += list(left[l:])
        result += list(right[r:])
        return result

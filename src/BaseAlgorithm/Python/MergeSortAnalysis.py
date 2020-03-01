def merge(left, right):
    r, l = 0, 0
    result = []

    while l < len(left) and r < len(right):
        if left[l] < right[r]:
            result.append(left[l])
            l += 1
        else:
            result.append(right[r])
            r += 1
    result += list(left[l:])
    result += list(right[r:])
    return result


def MergeSort(array):
    if len(array) <= 1:
        return array

    # 分块
    num = len(array) // 2
    left = MergeSort(array[:num])
    right = MergeSort(array[num:])
    # 合并
    return merge(left, right)


def main(array):
    return MergeSort(array)


if __name__ == '__main__':
    print(main([5, 3, 2, 1, 9, 8, 4, 0]))

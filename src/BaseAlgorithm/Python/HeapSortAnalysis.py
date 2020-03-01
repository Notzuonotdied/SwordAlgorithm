def endian(array, start, end):
    root = start
    child = root * 2 + 1

    while child <= end:
        if child + 1 <= end and array[child] < array[child + 1]:
            child = child + 1
        if array[root] < array[child]:
            print("root:%s(%s), child:%s(%s), end:%s, array:%s" % (
                root, array[root], child, array[child], end, array
            ))
            array[root], array[child] = array[child], array[root]
            print("\t\t\t\t\t   array:%s" % array)
            root = child
            child = root * 2 + 1
        else:
            print("child:%s" % child)
            break


def main(array):
    # 找出需要排序的部分
    first = len(array) // 2 - 1

    # 搭建大顶堆
    for start in range(first, -1, -1):
        endian(array, start, len(array) - 1)

    print("\n")

    # 排序
    for end in range(len(array) - 1, 0, -1):
        print("end:%s, array:%s" % (end, array))
        array[0], array[end] = array[end], array[0]
        # 堆顶和未排序的最后一个元素交换位置
        print("\t\t\t\t\t   reverse：%s" % array)
        endian(array, 0, end - 1)
        print("\n")

    return array


if __name__ == '__main__':
    print(main([5, 3, 2, 1, 9, 8, 4, 0]))

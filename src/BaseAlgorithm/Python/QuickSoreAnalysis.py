def QuickSort(array, start, end):
    i, j = start, end
    pivot = array[start]

    while i < j:
        while i < j and array[j] > pivot:
            j = j - 1
        while i < j and array[i] < pivot:
            i = i + 1
        if array[i] == array[j] and i < j:
            i = i + 1
        else:
            array[i], array[j] = array[j], array[i]

    if i - 1 > start:
        QuickSort(array, start, i - 1)
    if j + 1 < end:
        QuickSort(array, j + 1, end)

    return array


def main(array):
    return QuickSort(array, 0, len(array) - 1)


if __name__ == '__main__':
    print(main([5, 3, 2, 1, 9, 8, 4, 0]))

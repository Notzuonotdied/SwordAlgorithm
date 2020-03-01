import pprint
import numpy as np


def main():
    N = int(input('请输入数字：'))
    myarray = np.zeros((N, N), dtype=np.int16)
    x, y = 0, N - 1
    res = myarray[x][y] = 1
    while res < N * N:
        while x + 1 < N and (not myarray[x + 1][y]):
            res += 1
            x += 1
            myarray[x][y] = res
        while y - 1 >= 0 and not myarray[x][y - 1]:
            res += 1
            y -= 1
            myarray[x][y] = res
        while x - 1 >= 0 and not myarray[x - 1][y]:
            res += 1
            x -= 1
            myarray[x][y] = res
        while y + 1 < N and not myarray[x][y + 1]:
            res += 1
            y += 1
            myarray[x][y] = res

    pprint.pprint(myarray)
    print(myarray)


if __name__ == '__main__':
    main()

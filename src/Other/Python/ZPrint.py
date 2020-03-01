import numpy as np


def main(n):
    result = np.zeros([n, n])
    print(result)

    # count是指计数，r是第几圈
    count = 1
    if 1 == n:
        result[0][0] = count
    else:
        # 上三角(1,2,3,4)
        for r in range(1, n + 1):
            for y in range(0, r):
                print("r:%s, (%s, %s), %s" % (r, r - 1 - y, y, count))
                # 判断遍历的方向
                if r % 2 == 0:
                    result[r - 1 - y][y] = count
                else:
                    result[y][r - 1 - y] = count
                count += 1
        # 下三角(5,6,7)
        for r in range(n + 1, 2 * n):
            for y in range(r - n, n):
                print("r:%s, (%s, %s), %s" % (r, r - 1 - y, y, count))
                # 判断遍历的方向
                if r % 2 == 0:
                    result[r - 1 - y][y] = count
                else:
                    result[y][r - 1 - y] = count
                count += 1

    print(result)


if __name__ == '__main__':
    main(4)

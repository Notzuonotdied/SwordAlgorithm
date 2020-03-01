class Solution:

    @staticmethod
    def romanToInt(s: str) -> int:
        data_dict = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }

        pri_val = data_dict[s[0]]
        result = pri_val
        for index in range(1, len(s)):
            temp = data_dict[s[index]]
            print("罗马数字：%s，对应的数字：%s，上一个值：%s" % (
                s[index], temp, pri_val
            ))
            if temp <= pri_val:
                result = result + temp
            else:
                result = result + temp - pri_val * 2
            # print("结果为：%s" % result)
            pri_val = temp
        print("%s->%s" % (s, result))


if __name__ == '__main__':
    Solution.romanToInt('III')
    Solution.romanToInt('IV')
    Solution.romanToInt('IX')
    Solution.romanToInt('LVIII')
    Solution.romanToInt('MCMXCIV')

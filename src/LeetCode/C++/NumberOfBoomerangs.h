#ifndef NUMBER_OF_BOOMERANGS_H
#define NUMBER_OF_BOOMERANGS_H

#include <cmath>
#include <algorithm>
#include <vector>

/*
给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的
距离相等（需要考虑元组的顺序）。

返回平面上所有回旋镖的数量。
 */

static unsigned Distance(int x1, int y1, int x2, int y2)
{ return static_cast<unsigned>(std::pow(x1 - x2, 2) + std::pow(y1 - y2, 2)); }

static int NumberOfBoomerangs(std::vector<std::vector<int>>& points) 
{
	typedef std::vector<int> Point;

	std::size_t N = points.size();

	if(N < 3)
	{
		return 0;
	}

	std::vector<std::vector<unsigned>> dis(N);
	// 初始化
	for(std::size_t i = 0; i < N; ++i)
	{
		dis[i].resize(N);
	}

	// 先算各个点之间的距离
	for(std::size_t i = 0; i < N; ++i)
	{
		const Point &p1 = points[i];
		for(std::size_t j = i + 1; j < N; ++j)
		{
			const Point &p2 = points[j];
			dis[i][j] = dis[j][i] = Distance(p1[0], p1[1], p2[0], p2[1]);
		}
	}

	int count = 1, result = 0;

	unsigned last = 0;
	for(std::size_t i = 0; i < N; ++i)
	{
		std::sort(dis[i].begin(), dis[i].end());

		for(std::size_t j = 0; j < N; ++j)
		{
			unsigned tmp = dis[i][j];
			if(last == 0)
			{
				last = tmp;
			}
			else if(tmp == last)
			{
				++count;
			}
			else 
			{
				result += count * (count - 1);
				last = tmp;
				count = 1;
			}
		}
	}

	return result;
}

#endif // NUMBER_OF_BOOMERANGS_H

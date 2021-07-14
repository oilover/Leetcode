from typing import List

class Solution:
    def mostVisitedPattern(self, username: List[str], timestamp: List[int], website: List[str]) -> List[str]:
        data = list(zip(username, timestamp, website))
        data.sort()
        print(data)
        userWebMap = {}
        for name,_,web in data:
            if not name in userWebMap: userWebMap[name] = []
            userWebMap[name].append(web)
        cnt = {}
        for name,webs in userWebMap.items():
            for i in range(len(webs)-2):
                path = ' '.join([webs[i], webs[i+1], webs[i+2]])
                if not path in cnt: cnt[path] = 0
                cnt[path]+=1

        res = list(cnt.items())
        res = list(map(lambda x:[-x[1],x[0]],res ))
        res.sort()
        print(res)
        return res[0][1].split(' ')

s = Solution()
# s.mostVisitedPattern(username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"])

s.mostVisitedPattern(["zkiikgv","zkiikgv","zkiikgv","zkiikgv"],
[436363475,
 710406388,
 386655081,
 797150921],
["wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"])
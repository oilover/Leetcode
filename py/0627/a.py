from typing import List


class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        l, r = 0,n-1
        u, d = 0,m-1
        round = {}
        cur = 0
        x,y = 0,0
        now = []
        res = [[0]*n for i in range(m)] 
        while True:
            x,y = l,u
            now = [(x,y)]
            # round
            while y<r:
                y+=1
                now.append((x,y))
            y = r
            u += 1
            if u>d: break
            while x<d:
                x+=1
                now.append((x,y))
            r -= 1
            if r<l: break
            while y>l:
                y -= 1
                now.append((x,y))
            d-=1
            if u>d: break
            while x>u:
                x-=1
                now.append((x,y))
            l+=1
            if l>r: break
            print(now)
            for i,(x,y) in enumerate(now):
                t = now[(i+k)%len(now)]
                res[x][y] = grid[t[0]][t[1]]
        # print('a',now,res)
        for i,(x,y) in enumerate(now):
            t = now[(i+k)%len(now)]
            res[x][y] = grid[t[0]][t[1]]
            # print(x,y,t, res)
        print(grid)
        return res

s=Solution()
print(s.rotateGrid([[40,10],[30,20]],1)        )
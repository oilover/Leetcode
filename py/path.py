# import List from lis
class Solution:
    def exist(self, board, word: str) -> bool:
        if len(board)==0: return False
        n,m = len(board), len(board[0])
        def dfs(x,y,i):
            if x<0 or y<0 or x>=n or y>=m or board[x][y]!=word[i]:
                return False
            if i==len(word)-1: return True
            board[x][y] = '$'
            if dfs(x+1,y,i+1): return True
            if dfs(x-1,y,i+1): return True
            if dfs(x,y-1,i+1): return True
            if dfs(x,y+1,i+1): return True
            board[x][y] = word[i]
            return False
        for i in range(n):
            for j in range(m):
                if dfs(i,j,0): return True
        return False

solution = Solution()
print(solution.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
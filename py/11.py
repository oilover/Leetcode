
class Solution:
    def getMinRooms(self, meetings):
        events = []
        for meeting in meetings:
            events.append((meeting[0],1))
            events.append((meeting[1],-1))
        events.sort()
        res = 0
        cnt = 0
        for e in events:
            cnt += e[1]
            res = max(res, cnt)
        return res

s = Solution()
print(s.getMinRooms([["07:20", "08:20"], ["08:20", "17:30"], ["08:20", "17:30"]]))
print(s.getMinRooms([["07:20", "08:20"], ["08:20", "17:30"], ["08:19", "17:30"]]))
print(s.getMinRooms([["07:20", "08:20"], ["08:19", "17:30"], ["08:19", "17:30"]]))
print(s.getMinRooms([["07:20", "08:20"], ["06:30", "07:30"], ["08:00", "09:00"], ["10:00", "10:30"]]))
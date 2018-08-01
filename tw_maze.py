import sys
class MyError(Exception):
    def __init__(self, value):
        self.value = value
    def __str__(self):
        return repr(self.value)

def transfer(point):
    return tuple([2*x+1 for x in point])
def midpoint(p0,p1):
    return ((p0[0]+p1[0])/2, (p0[1]+p1[1])/2)
def dist(p1, p2):
    return abs(p1[0]-p2[0]) + abs(p1[1]-p2[1])
def numInRange(n):
    return 0<n and n<=4000
def parsePoint(string):
    p = string.split(',')
    if len(p)!=2: raise MyError("Incorrect command format.")
    return (int(p[0]), int(p[1]))

class Maze:
    def pointInRange(self,p):
        return 0<=p[0] and p[0]<self.n and 0<=p[1] and p[1]<self.m 
    def setRoad(self,p):
        self.maze[round(p[0])][round(p[1])] = 'R'
    def __init__(self, cmd):
        # cmd = command.split('\n')[:2]
        tmp = cmd[0].split(' ')
        try:
            if len(tmp)!=2:
                raise MyError("Incorrect command format.")
            self.n, self.m = int(tmp[0]), int(tmp[1])
            if not numInRange(self.n) or not numInRange(self.m):
                raise MyError("Number out of range.")
            N,M = 2*self.n+1, 2*self.m+1
            roads = cmd[1].split(';')
            self.maze = [['W']*M for i in range(N)]
            for road in roads:
                path = road.split(' ')
                if len(path)!=2:
                    raise MyError("Incorrect command format.")
                p0,p1 = parsePoint(path[0]), parsePoint(path[1])
                if not self.pointInRange(p0) or not self.pointInRange(p1):
                    raise MyError("Number out of range.")
                if dist(p0,p1)!=1:
                    raise MyError("Maze format error.")
                p0,p1 = transfer(p0),transfer(p1)
                self.setRoad(p0)
                self.setRoad(p1)
                self.setRoad(midpoint(p0,p1))
        except ValueError:
            print('Invalid number format.')
            sys.exit(0)
        except MyError as e:
            print(e.value)
            sys.exit(0)
        for line in self.maze:
            print(' '.join(line))

if __name__=='__main__':
    cmd = ['','']
    cmd[0] = input()
    cmd[1] = input()
    maze = Maze(cmd)

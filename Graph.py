# enconding = utf-8

DIRECTED = 0
UNDIRECTED = 1

def E2G(E): # Construct Graph from set of edges(pair) 
	G = {}
	for e in E:
		u , v = e[0], e[1]
		if not u in G:
			G[u] = []
		G[u].append(v)
	return G

class Graph:   #directed graph
	def __init__(self):
		self.V = {} 
		self.V2 = {}     # reversed edge -- jinru de bian
		self.E = []
		#self.adj = {}
		self.L = {}  # label of nodes
		self.timing_order = set() # set of pairs (e1,e2) mean e1 should be earlier than e2
		self.type = DIRECTED

	def NE(self): #number of edges
		return len(self.E)

	def NV(self):
		return len(self.V)

	def addEdge(self, edge):
		#self.V.add(u)
		#self.V.add(v)
		u = edge['from']
		v = edge['to'];
		if not u in self.V:
			self.V[u] = {}
		if not v in self.V2:
			self.V2[v] = {}
		if not 'ID' in edge: 
			edge['ID'] = len(self.E)
		self.V[u].append(edge) #{'from':u, 'to':v, 'time':t, color':color}
	#	self.V[v].add(edge) #{'from':v, 'to':u, 'color':color}
		self.V2[v].append(edge)
		self.E.append(edge)
		
	def postProcess(self):
		pass
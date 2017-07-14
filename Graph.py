# enconding = utf-8

class Graph:   #directed graph
	def __init__(self):
		self.V = {} 
		self.V2 = {}     # reversed edge -- jinru de bian
		self.E = []
		#self.adj = {}
		self.L = {}  # label of nodes

	def addEdge(self, edge):
		#self.V.add(u)
		#self.V.add(v)
		u = edge['from']
		v = edge['to'];
		if not u in self.V:
			self.V[u] = {}
		if not v in self.V2:
			self.V2[v] = {}
		self.V[u].append(edge) #{'from':u, 'to':v, 'time':t, color':color}
	#	self.V[v].add(edge) #{'from':v, 'to':u, 'color':color}
		self.V2[v].append(edge)
		self.E.append(edge)
		
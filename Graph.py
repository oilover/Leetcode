# enconding = utf-8

class Graph:   #directed graph
	def __init__(self):
		self.V = {} #set()
		self.V2 = {}     # jinru de bian
		self.E = []
		#self.adj = {}
		self.L = []  # label

	def addEdge(self, edge):
		#self.V.add(u)
		#self.V.add(v)
		u = edge['from']
		v = edge['to'];
		if not u in self.V:
			self.V[u] = {}
		if not v in self.V2:
			self.V2[v] = {}
		self.V[u].add(edge) #{'from':u, 'to':v, 'color':color}
	#	self.V[v].add(edge) #{'from':v, 'to':u, 'color':color}
		self.V2[v].add(edge)
		self.E.append(edge)
		
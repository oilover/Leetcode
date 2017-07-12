
from Graph import Graph

def DualSim(Q, G):
	sim = {}
	for v in Q.V:
		sim[v] = set()
		for u in G.V:
			if Q.label[u]==G.label[v]:
				sim[v].add(u)
	while True:
		for edge in Q.E:
			v = edge['from']
			v2 = edge['to']
			for u in sim[v]: # u(G) correspond to v
				has = False
				for eu in G.V[u]: # edge from u
					u2 = eu['to']
					if u2 in sim[v2]:
						has = True
						break
				if not has : 
					sim[v].remove(u)
			if len(sim[v])==0 : return []
			v2 = edge['from']
			v = edge['to']
			for u in sim[v]: # u(G) correspond to v
				has = False
				for eu in G.V2[u]: # edge to u
					u2 = eu['from']
					if u2 in sim[v2]:
						has = True
						break
				if not has : 
					sim[v].remove(u)
			if len(sim[v])==0 : return []

	S_w = []
	for v in Q.V:
		for u in sim[v]:
			S_w.append((v,u))
	return S_w

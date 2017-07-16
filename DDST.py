from DualSim import *
from Queue import Queue
INF = 1e12

def reverseG(G):
	G2 = {}
	for u in G:
		for v in G[u]:
			if not v in G2: G2[v] = set()
			G2[v].add(u)

def match_relation(S): # Construct edge match relation 𝑆𝑒 &
# match graph 𝐺𝑚 from 𝑆
	# S is vertex match
	pass

def TopSort(G):
	indegree = {}
	for v in G: indegree[v] = 0
	Q = Queue()
	for v in G:
		for u in G[v]:
			if not u in indegree : indegree[u]=0
			indegree[u]+=1
	for u in indegree:
		if indegree[u]==0:
			Q.put(u)
	order = []
	while not Q.empty():
		u = Q.get()
		order.append(u)
		for v in G[u]:
			indegree[v]-=1
			if indegree[v]==0:
				Q.put(v)
	return order

block = {} # which connected component belong to 
CC = {} # connected component 
def D2U(G): # directed graph to undirected
	if G.type==UNDIRECTED: return G
	UG = Graph()
	for edge in G.E:
		UG.addEdge(edge);
		e = edge 
		e['from'],e['to'] = edge['to'],e['from']
		UG.addEdge(e);
	return UG

def dfs(G, u, b):
	block[u] = b
	if not b in CC:
		CC[b] = set()
	CC[b].add(u)
	for e in G[u]:
		v = e['to']
		if not v in block:
			dfs(G, v, b)

def get_connected_component(G):
	block = {}
	if G.type==DIRECTED:
		G = D2U(G)
	b = 1
	for u in G.V:
		if not u in block:
			dfs(G, u, b)
	return CC

def DDST(G, Q, w): # 𝒢: graph stream,\
# 𝒬: query graph, 𝑤: window size
	Sv, sim = DualSim(Q,G)
	simE, subG = V2EMatch(Q,G,sim)
	top_order = TopSort(Q.timing_order)
	ts = {}
	for x in range(Q.NE()): ts[x] = -1e7
	rsimE = reverseG(simE)
	while True:
		change = false
		for eQ in top_order:
			lim = -1e7 #lower bound
			for preEQ in Q.V2[eQ]:
				lim = max(lim, ts[preEQ])
			Min = 1e9
			for eG in simE[eQ]:
				if eG['time'] > lim:
					Min = min(Min, eG['time'])
				else:
					simE[eQ].remove(eG)
					rsimE[eG].remove(eQ)
					if len(rsimE[eG])==0:
						subG.remove(eG)
					change = True 
			ts[eQ] = Min
		for eQ in top_order[::-1]:
			lim = INF
			for postEQ in Q.V[eQ]:
				lim = min(lim, ts[postEQ])
			Max = -INF
			for eG in simE[eQ]:
				if eG['time'] < lim:
					Max = max(Max, eG['time'])
				else:
					simE[eQ].remove(eG)
					rsimE[eG].remove(eQ)
					if len(rsimE[eG])==0:
						subG.remove(eG)
					change = True 
			ts[eQ] = Max

		if not change: break
			
	return 	subG, simE





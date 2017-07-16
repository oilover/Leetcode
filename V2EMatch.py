from Graph import *
def V2EMatch(Q, G, sim):
	simE = {}
	#Se = set()
	subgraphG = set()
	sG = Graph()
	for eQ in Q.E:
		a = eQ['from'];
		b = eQ['to'];
		ID_Q = eQ['ID'];
		if not ID_Q in sim:
			sim[ID_Q] = set()
		for A in sim[a]:
			for eG in G.V[A]:
				B = eG['to']
				if eG['label'] == eQ['label'] and \
				B in sim[b]:	
					ID_G = eG['ID']
					simE[ID_Q].add(ID_G)
					subgraphG.add(ID_G)
					sG.addEdge(eG)
	return simE	, subgraphG, sG
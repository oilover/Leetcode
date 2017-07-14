
def V2EMatch(Q, G, sim):
	simE = {}
	for eQ in Q.E:
		a = eQ['from'];
		b = eQ['to'];
		ID_Q = eQ['ID'];
		for A in sim[a]:
			for eG in G.V[A]:
				if eG['label'] == eQ['label']
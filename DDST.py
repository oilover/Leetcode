from DualSim import *

def DDST(G, Q, w): # 𝒢: graph stream, 𝒬: query graph, 𝑤: window size
	S = DualSim(Q,G)
